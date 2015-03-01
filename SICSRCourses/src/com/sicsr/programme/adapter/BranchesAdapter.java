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
import com.sicsr.programme.dto.BranchDto;
import com.sicsr.programme.fragment.BranchesListFragment;
import com.sicsr.programme.fragment.SemesterListFragment;
import com.sicsr.programme.viewholder.BranchesViewHolder;

public class BranchesAdapter extends RecyclerView.Adapter<BranchesViewHolder> {

	private static final int ADAPTER_MODE_API = 1;
	private static final int ADAPTER_MODE_DATABASE = 2;
	private Cursor contentItemCursor;
	private int adapterMode;


	private BranchesListFragment mContext;
	private List<BranchDto> branchesDtos;

	public BranchesAdapter(BranchesListFragment mContext, List<BranchDto> customerAccountDtos) {
		this.mContext = mContext;
		this.branchesDtos = customerAccountDtos;
	}

	public BranchesAdapter(BranchesListFragment context, Cursor contentItemCursor) {
		this.mContext = context;
		this.contentItemCursor = contentItemCursor;
		this.adapterMode = ADAPTER_MODE_DATABASE;
	}

	@Override
	public int getItemCount() {
		if (this.adapterMode == ADAPTER_MODE_API) {
			return branchesDtos.size();
		} else {
			return contentItemCursor.getCount();
		}
	}

	@Override
	public void onBindViewHolder(BranchesViewHolder holder, int position) {

		BranchDto branchDto = null;

		if (this.adapterMode == ADAPTER_MODE_API) {
			branchDto = branchesDtos.get(position);
		} else {
			contentItemCursor.moveToPosition(position);
			branchDto = new BranchDto(contentItemCursor);
		}
		holder.branch_name.setText(branchDto.getName());
		holder.branch_outer.setTag(branchDto);
		holder.branch_outer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				BranchDto branchDto = (BranchDto) v.getTag();
				HomeActivity activity = (HomeActivity) mContext.getActivity();
				Bundle bundle = new Bundle();
				bundle.putInt("id", branchDto.getId());
				activity.addFragmentMain(new SemesterListFragment(), bundle);
			}
		});
	}

	@Override
	public BranchesViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
		View itemView = LayoutInflater.
				from(viewGroup.getContext()).
				inflate(R.layout.item_list, viewGroup, false);
		return new BranchesViewHolder(itemView,mContext);
	}

}
