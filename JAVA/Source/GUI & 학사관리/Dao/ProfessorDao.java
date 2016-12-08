package kr.ac.itschool.dao.join0801;

import java.util.ArrayList;

import kr.ac.itschool.entities.join0801.ProfessorBean;

public interface ProfessorDao {
	public boolean insertRow( ProfessorBean data );
	public boolean findId(String code);
	public ProfessorBean selectRowone( String code );
	public ArrayList<ProfessorBean> selectAll( );
	public ArrayList<ProfessorBean> selectFind( String text  );
	public boolean deleteRow(String code);
	public boolean updateRow( ProfessorBean data);
	public ArrayList<String> selectPro( );
}
