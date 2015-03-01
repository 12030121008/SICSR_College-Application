package com.sicsr.programme.adapter;

import java.util.List;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.sicsr.programme.R;
import com.sicsr.programme.activity.HomeActivity;
import com.sicsr.programme.dto.SemesterDto;
import com.sicsr.programme.fragment.SemesterListFragment;
import com.sicsr.programme.fragment.SubjectListFragment;
import com.sicsr.programme.viewholder.SemesterViewHolder;

public class SemesterAdapter extends RecyclerView.Adapter<SemesterViewHolder> {

	private static final int ADAPTER_MODE_API = 1;
	private static final int ADAPTER_MODE_DATABASE = 2;
	private Cursor contentItemCursor;
	private int adapterMode;


	private SemesterListFragment mContext;
	private List<SemesterDto> semesterDtos;

	public SemesterAdapter(SemesterListFragment mContext, List<SemesterDto> semesterDtos) {
		this.mContext = mContext;
		this.semesterDtos = semesterDtos;
	}

	public SemesterAdapter(SemesterListFragment context, Cursor contentItemCursor) {
		this.mContext = context;
		this.contentItemCursor = contentItemCursor;
		this.adapterMode = ADAPTER_MODE_DATABASE;
	}

	@Override
	public int getItemCount() {
		if (this.adapterMode == ADAPTER_MODE_API) {
			return semesterDtos.size();
		} else {
			return contentItemCursor.getCount();
		}
	}

	@Override
	public void onBindViewHolder(SemesterViewHolder holder, int position) {

		SemesterDto semesterDto = null;

		if (this.adapterMode == ADAPTER_MODE_API) {
			semesterDto = semesterDtos.get(position);
		} else {
			contentItemCursor.moveToPosition(position);
			semesterDto = new SemesterDto(contentItemCursor);
		}
		holder.branch_name.setText(semesterDto.getName());
		holder.wrapper.setTag(semesterDto);
		holder.wrapper.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SemesterDto semesterDto = (SemesterDto) v.getTag();
				HomeActivity activity = (HomeActivity) mContext.getActivity();
				Bundle bundle = new Bundle();
				bundle.putInt("id", semesterDto.getId());
				activity.addFragmentMain(new SubjectListFragment(), bundle);
			}
		});
	}

	@Override
	public SemesterViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
		View itemView = LayoutInflater.
				from(viewGroup.getContext()).
				inflate(R.layout.item_list, viewGroup, false);
		return new SemesterViewHolder(itemView,mContext);
	}

}
