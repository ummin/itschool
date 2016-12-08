package kr.ac.itschool.dao.join0801;

import java.util.ArrayList;

import kr.ac.itschool.entities.join0801.DeptBean;

public interface DeptDao {
	public boolean insertRow( DeptBean data );
	public boolean findId(String code);
	public DeptBean selectRowone( String code );
	public ArrayList<DeptBean> selectAll( );
	public ArrayList<DeptBean> selectFind( String text  );
	public boolean deleteRow(String code);
	public boolean updateRow( DeptBean data);
	public ArrayList<String> selectDept( );
}
