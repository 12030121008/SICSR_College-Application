package com.sicsr.programme.adapter;

import java.util.List;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.sicsr.programme.R;
import com.sicsr.programme.activity.BaseActivity;
import com.sicsr.programme.database.DbOperationResponse;
import com.sicsr.programme.database.dao.impl.TopicDaoImpl;
import com.sicsr.programme.dto.TopicDto;
import com.sicsr.programme.entity.TopicEntity;
import com.sicsr.programme.fragment.TopicsListFragment;
import com.sicsr.programme.viewholder.TopicsViewHolder;

public class TopicAdapter extends RecyclerView.Adapter<TopicsViewHolder> {

	private static final int ADAPTER_MODE_API = 1;
	private static final int ADAPTER_MODE_DATABASE = 2;
	private Cursor contentItemCursor;
	private int adapterMode;


	private TopicsListFragment mContext;
	private List<TopicDto> topicDtos;

	public TopicAdapter(TopicsListFragment mContext, List<TopicDto> topicDtos) {
		this.mContext = mContext;
		this.topicDtos = topicDtos;
	}

	public TopicAdapter(TopicsListFragment context, Cursor contentItemCursor) {
		this.mContext = context;
		this.contentItemCursor = contentItemCursor;
		this.adapterMode = ADAPTER_MODE_DATABASE;
	}

	@Override
	public int getItemCount() {
		if (this.adapterMode == ADAPTER_MODE_API) {
			return topicDtos.size();
		} else {
			return contentItemCursor.getCount();
		}
	}

	@Override
	public void onBindViewHolder(TopicsViewHolder holder, int position) {

		TopicDto topicDto = null;

		if (this.adapterMode == ADAPTER_MODE_API) {
			topicDto = topicDtos.get(position);
		} else {
			contentItemCursor.moveToPosition(position);
			topicDto = new TopicDto(contentItemCursor);
		}
		holder.branch_name.setText(topicDto.getName());

		if(topicDto.getCompleted() == 0){
			holder.chkTopicStatus.setChecked(false);
		}else{
			holder.chkTopicStatus.setChecked(true);
		}

		if(topicDto.getBookmarked() == 0){
			holder.imgBookmark.setActivated(false);
		}else{
			holder.imgBookmark.setActivated(true);
		}


		holder.chkTopicStatus.setTag(topicDto);
		holder.chkTopicStatus.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				TopicDto topicDto = (TopicDto) view.getTag();
				CheckBox  subjectCheck = (CheckBox) view;
				if(subjectCheck.isChecked()){
					topicDto.setCompleted(1);

				}else{
					topicDto.setCompleted(0);
				}

				TopicEntity topicEntity = new TopicEntity(topicDto);
				TopicDaoImpl topicDaoImpl = new TopicDaoImpl((BaseActivity)mContext.getActivity());
				DbOperationResponse topicUpdateOperationResponse =  topicDaoImpl.update(topicEntity.getId(), topicEntity);

				if(topicUpdateOperationResponse.getStatus() == DbOperationResponse.DB_RESPONSE_STATUS_SUCCESS){
					if(subjectCheck.isChecked()){
						Toast.makeText(mContext.getActivity(), "checked", Toast.LENGTH_SHORT).show();
					}
					Log.e(TopicAdapter.class.getName(), topicUpdateOperationResponse.getMessageString());
				}else{
					Toast.makeText(mContext.getActivity(), topicUpdateOperationResponse.getErrorString(), Toast.LENGTH_SHORT).show();
					Log.e(TopicAdapter.class.getName(), topicUpdateOperationResponse.getErrorString());
				}
			}
		});


		holder.imgBookmark.setTag(topicDto);
		holder.imgBookmark.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				TopicDto topicDto = (TopicDto) view.getTag();
				ImageView  bookmardked = (ImageView) view;
				if(bookmardked.isActivated()){
					topicDto.setBookmarked(0);
					bookmardked.setActivated(false);
				}else{
					topicDto.setBookmarked(1);
					bookmardked.setActivated(true);
				}

				TopicEntity topicEntity = new TopicEntity(topicDto);
				TopicDaoImpl topicDaoImpl = new TopicDaoImpl((BaseActivity)mContext.getActivity());
				DbOperationResponse topicUpdateOperationResponse =  topicDaoImpl.update(topicEntity.getId(), topicEntity);

				if(topicUpdateOperationResponse.getStatus()  == DbOperationResponse.DB_RESPONSE_STATUS_SUCCESS){
					Log.e(TopicAdapter.class.getName(), topicUpdateOperationResponse.getMessageString());
					if(bookmardked.isActivated()){
						Toast.makeText(mContext.getActivity(), "marked", Toast.LENGTH_SHORT).show();
					}
				}else{
					Toast.makeText(mContext.getActivity(), topicUpdateOperationResponse.getErrorString(), Toast.LENGTH_SHORT).show();
					Log.e(TopicAdapter.class.getName(), topicUpdateOperationResponse.getErrorString());
				}
			}
		});


	}

	@Override
	public TopicsViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
		View itemView = LayoutInflater.
				from(viewGroup.getContext()).
				inflate(R.layout.item_topic, viewGroup, false);
		return new TopicsViewHolder(itemView,mContext);
	}

}
