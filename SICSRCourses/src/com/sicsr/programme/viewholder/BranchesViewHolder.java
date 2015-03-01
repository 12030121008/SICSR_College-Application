package com.sicsr.programme.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sicsr.programme.R;
import com.sicsr.programme.fragment.BranchesListFragment;

public class BranchesViewHolder extends RecyclerView.ViewHolder {

	public TextView branch_name;
	public View branch_outer;
	BranchesListFragment mContext;

	public BranchesViewHolder(View root, BranchesListFragment mContext) {
		super(root);
		this.mContext = mContext;
		branch_name = (TextView) root.findViewById(R.id.name);
		branch_outer  = (View) root.findViewById(R.id.wrapper);

	}



}
