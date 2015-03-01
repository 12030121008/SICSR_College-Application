package com.sicsr.programme.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.sicsr.programme.R;
import com.sicsr.programme.fragment.TopicsListFragment;

public class TopicsViewHolder extends RecyclerView.ViewHolder {

	public TextView branch_name;
	public View wrapper;
	TopicsListFragment mContext;
	public CheckBox chkTopicStatus;
	public ImageView imgBookmark;
	
	public TopicsViewHolder(View root, TopicsListFragment mContext) {
		super(root);
		this.mContext = mContext;
		branch_name = (TextView) root.findViewById(R.id.name);
		wrapper  = (View) root.findViewById(R.id.wrapper);
		chkTopicStatus = (CheckBox) root.findViewById(R.id.chkTopicStatus);
		imgBookmark = (ImageView) root.findViewById(R.id.imgBookmark);
	}

}
