package com.sicsr.programme.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sicsr.programme.R;
import com.sicsr.programme.fragment.UnitsListFragment;

public class UnitsViewHolder extends RecyclerView.ViewHolder {

	public TextView branch_name;
	public View wrapper;
	UnitsListFragment mContext;

	public UnitsViewHolder(View root, UnitsListFragment mContext) {
		super(root);
		this.mContext = mContext;
		branch_name = (TextView) root.findViewById(R.id.name);
		wrapper  = (View) root.findViewById(R.id.wrapper);

	}

}
