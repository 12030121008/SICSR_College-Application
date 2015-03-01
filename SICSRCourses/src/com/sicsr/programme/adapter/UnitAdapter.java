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
import com.sicsr.programme.dto.UnitDto;
import com.sicsr.programme.fragment.TopicsListFragment;
import com.sicsr.programme.fragment.UnitsListFragment;
import com.sicsr.programme.viewholder.UnitsViewHolder;

public class UnitAdapter extends RecyclerView.Adapter<UnitsViewHolder> {

	private static final int ADAPTER_MODE_API = 1;
	private static final int ADAPTER_MODE_DATABASE = 2;
	private Cursor contentItemCursor;
	private int adapterMode;


	private UnitsListFragment mContext;
	private List<UnitDto> unitDtos;

	public UnitAdapter(UnitsListFragment mContext, List<UnitDto> unitDtos) {
		this.mContext = mContext;
		this.unitDtos = unitDtos;
	}

	public UnitAdapter(UnitsListFragment context, Cursor contentItemCursor) {
		this.mContext = context;
		this.contentItemCursor = contentItemCursor;
		this.adapterMode = ADAPTER_MODE_DATABASE;
	}

	@Override
	public int getItemCount() {
		if (this.adapterMode == ADAPTER_MODE_API) {
			return unitDtos.size();
		} else {
			return contentItemCursor.getCount();
		}
	}

	@Override
	public void onBindViewHolder(UnitsViewHolder holder, int position) {

		UnitDto subjectDto = null;

		if (this.adapterMode == ADAPTER_MODE_API) {
			subjectDto = unitDtos.get(position);
		} else {
			contentItemCursor.moveToPosition(position);
			subjectDto = new UnitDto(contentItemCursor);
		}
		holder.branch_name.setText(subjectDto.getName());
		holder.wrapper.setTag(subjectDto);
		holder.wrapper.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				UnitDto unitDto = (UnitDto) v.getTag();
				HomeActivity activity = (HomeActivity) mContext.getActivity();
				Bundle bundle = new Bundle();
				bundle.putInt("id", unitDto.getId());
				activity.addFragmentMain(new TopicsListFragment(), bundle);
			}
		});
	}

	@Override
	public UnitsViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
		View itemView = LayoutInflater.
				from(viewGroup.getContext()).
				inflate(R.layout.item_list, viewGroup, false);
		return new UnitsViewHolder(itemView,mContext);
	}

}
