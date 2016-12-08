package com.naver.sdu0920.service;

import java.util.ArrayList;

import com.naver.sdu0920.entities.Member;

public interface MemberDao {
	public Member selectOne( String id );
	public ArrayList <Member> selectAll();
	public int selectCount( String id );
	public int insertRow( Member member );
	public int updateRow( Member member );
	public int deleteRow( String id );
	
}

