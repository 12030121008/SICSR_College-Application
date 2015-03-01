package com.sicsr.programme.database.dao;

import com.sicsr.programme.activity.BaseActivity;
import com.sicsr.programme.database.DbOperationResponse;
import com.sicsr.programme.database.DbOperations;
import com.sicsr.programme.entity.TopicEntity;

 

public abstract class TopicDao extends BaseDao implements DbOperations<TopicEntity>{

	public TopicDao(BaseActivity initActivity) {
		super(initActivity);
	}
	
	public abstract DbOperationResponse findTopics(int unitId);

}
