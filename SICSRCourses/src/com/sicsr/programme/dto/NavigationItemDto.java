package com.sicsr.programme.dto;

public class NavigationItemDto extends BaseDto {

	private String title;
	private int drawableId;
	private Integer extraCount;
	private boolean isCategory = false;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDrawableId() {
		return drawableId;
	}
	public void setDrawableId(int drawableId) {
		this.drawableId = drawableId;
	}
	public Integer getExtraCount() {
		return extraCount;
	}
	public void setExtraCount(Integer extraCount) {
		this.extraCount = extraCount;
	}
	public boolean isCategory() {
		return isCategory;
	}
	public void setCategory(boolean isCategory) {
		this.isCategory = isCategory;
	}

}
