package com.naver.sdu0920.service;

import com.naver.sdu0920.entities.Member;

public interface MemberDao {
	public Member selectOne( String id );
	public int selectCount( String id );
	public int insertRow( Member member );
}
