package com.naver.sdu0920.entities;

public class BoardPaging {
	private String find;
	private String selectbox;
	private int    startrow;
	private int    endrow;
	public String getFind() {
		return find;
	}
	public void setFind(String find) {
		this.find = find;
	}
	public String getSelectbox() {
		return selectbox;
	}
	public void setSelectbox(String selectbox) {
		this.selectbox = selectbox;
	}
	public int getStartrow() {
		return startrow;
	}
	public void setStartrow(int startorw) {
		this.startrow = startorw;
	}
	public int getEndrow() {
		return endrow;
	}
	public void setEndrow(int endrow) {
		this.endrow = endrow;
	}
	
}
