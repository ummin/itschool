package kr.ac.itschool.dao.join0801;

import java.util.ArrayList;

import javax.swing.JTable;

import kr.ac.itschool.entities.join0801.StudentBean;

public interface StudentDao {
	public boolean insertRow( StudentBean data );
	public boolean findId(String code);
	public StudentBean selectRowone( String code, JTable table );
	public ArrayList<StudentBean> selectAll( );
	public ArrayList<StudentBean> selectFind( String text  );
	public boolean deleteRow(String code);
	public boolean updateRow( StudentBean data );
}
