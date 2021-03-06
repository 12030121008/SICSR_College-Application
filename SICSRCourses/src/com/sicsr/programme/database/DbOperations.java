package com.sicsr.programme.database;

import com.sicsr.programme.entity.BaseEntity;



// Interface that contains all methods that every entity MUST implement

public interface DbOperations<T extends BaseEntity> {
 
	DbOperationResponse add(T entity);
	DbOperationResponse remove(Long entityId);
	DbOperationResponse update(Long entityId, T updatedEntity);
	DbOperationResponse exists(Long entityId);
	
	DbOperationResponse findMaxId();
	DbOperationResponse findById(Long entityId);
}
