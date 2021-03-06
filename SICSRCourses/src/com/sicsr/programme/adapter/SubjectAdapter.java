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
import com.sicsr.programme.dto.SubjectDto;
import com.sicsr.programme.fragment.SubjectListFragment;
import com.sicsr.programme.fragment.UnitsListFragment;
import com.sicsr.programme.viewholder.SubjectViewHolder;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectViewHolder> {

	private static final int ADAPTER_MODE_API = 1;
	private static final int ADAPTER_MODE_DATABASE = 2;
	private Cursor contentItemCursor;
	private int adapterMode;


	private SubjectListFragment mContext;
	private List<SubjectDto> subjectDtos;

	public SubjectAdapter(SubjectListFragment mContext, List<SubjectDto> semesterDtos) {
		this.mContext = mContext;
		this.subjectDtos = semesterDtos;
	}

	public SubjectAdapter(SubjectListFragment context, Cursor contentItemCursor) {
		this.mContext = context;
		this.contentItemCursor = contentItemCursor;
		this.adapterMode = ADAPTER_MODE_DATABASE;
	}

	@Override
	public int getItemCount() {
		if (this.adapterMode == ADAPTER_MODE_API) {
			return subjectDtos.size();
		} else {
			return contentItemCursor.getCount();
		}
	}

	@Override
	public void onBindViewHolder(SubjectViewHolder holder, int position) {

		SubjectDto subjectDto = null;

		if (this.adapterMode == ADAPTER_MODE_API) {
			subjectDto = subjectDtos.get(position);
		} else {
			contentItemCursor.moveToPosition(position);
			subjectDto = new SubjectDto(contentItemCursor);
		}
		holder.branch_name.setText(subjectDto.getName());
		holder.wrapper.setTag(subjectDto);
		holder.wrapper.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SubjectDto subjectDto = (SubjectDto) v.getTag();
				HomeActivity activity = (HomeActivity) mContext.getActivity();
				Bundle bundle = new Bundle();
				bundle.putInt("id", subjectDto.getId());
				activity.addFragmentMain(new UnitsListFragment(), bundle);
			}
		});
	}

	@Override
	public SubjectViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
		View itemView = LayoutInflater.
				from(viewGroup.getContext()).
				inflate(R.layout.item_list, viewGroup, false);
		return new SubjectViewHolder(itemView,mContext);
	}

}
