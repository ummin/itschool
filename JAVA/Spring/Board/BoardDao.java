package com.naver.sdu0920.service;

import java.util.ArrayList;

import com.naver.sdu0920.entities.Board;
import com.naver.sdu0920.entities.BoardPaging;

public interface BoardDao {
	public Board selectOne( int b_seq );
	public Board selectRow( String id );
	public ArrayList <Board> selectAll();
	public ArrayList <Board> selectPageList(BoardPaging boardpaging);
	public int insertRow( Board board );
	public int insertReply( Board board );
	public int updateRow( Board board );
	public int updateHit( int   b_seq );
	public int deleteRow( int b_seq );
	public int selectCount( BoardPaging boardpaging );
	public int selectCountAll( );
	
}
