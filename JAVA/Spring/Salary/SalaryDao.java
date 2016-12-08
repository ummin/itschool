package com.naver.sdu0920.service;

import java.util.ArrayList;
import java.util.List;

import com.naver.sdu0920.entities.Salary;
import com.naver.sdu0920.entities.SalaryRoll;
import com.naver.sdu0920.entities.SalaryRollup;

public interface SalaryDao {
	public Salary selectOne( int no );
	public ArrayList <Salary> selectAll();
	public ArrayList <SalaryRollup> salaryRollup( String yyyymm );
	public int selectCount( String id );
	public int insertRow( Salary Salary );
	public int insertRollRow( List <SalaryRoll> list );
	public int updateRow( Salary salary );
	public int deleteRow( String no );
	public int deleteRollRow( String yyyymm );
}
