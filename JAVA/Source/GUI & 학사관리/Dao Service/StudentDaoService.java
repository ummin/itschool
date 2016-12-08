package kr.ac.itschool.service.join0801;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JTable;

import kr.ac.itschool.custom.DBConnectionManager;
import kr.ac.itschool.entities.join0801.StudentBean;

public class StudentDaoService {
	DBConnectionManager db = new DBConnectionManager();
	Connection cn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public boolean insertRow(StudentBean data) {
		StringBuilder sb = new StringBuilder();
		sb.append("insert into student (code,name,idcard,postno,addr1,addr2,professor,dept) values ( ");
		sb.append(" '"+data.getCode()+"', '"+data.getName()+"','"+data.getIdcard()+"','"+data.getPostno()+"', ");
		sb.append(" '"+data.getAddr1()+"', '"+data.getAddr2()+"', '"+data.getProfessor()+"', '"+data.getDept()+"' )");
		String sql = sb.toString();
		System.out.println(sql);
		boolean success = false;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			ps.execute();
			success = true;
			cn.close();
			ps.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			success = false;
		}
		return success;
	}
	public boolean findCode(String code) {
		String sql = "select *from student where code like '"+code+"' ";
		System.out.println(sql);
		boolean findcode = false;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()){
				findcode = true;
			}
		} catch (Exception e) {
		System.out.println(e.getMessage());
		findcode = false;
		}
		return findcode;
	}
	
	public StudentBean selectRowone(String code, JTable table) {
		String sql = "select * from student where code = '"+code+"' ";
		System.out.println(sql);
		
		Object after = table.getValueAt(table.getSelectedRow(), 1);
		String dept = after.toString();
		System.out.println(dept);
//		
		Object after1 = table.getValueAt(table.getSelectedRow(), 3);
		String professor = after1.toString();
		System.out.println(professor);
		
		StudentBean data = null;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()){
				data = new StudentBean();
				data.setCode(rs.getString("code"));
				data.setName(rs.getString("name"));
				data.setIdcard(rs.getString("idcard"));
				data.setPostno(rs.getString("postno"));
				data.setAddr1(rs.getString("addr1"));
				data.setAddr2(rs.getString("addr2"));
				data.setProfessor(rs.getString("professor"));
				System.out.println("professor-->"+rs.getString("professor"));
				data.setDept((rs.getString(8))+dept);
				data.setAge(rs.getString("age"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}

	public ArrayList<StudentBean> selectAll() {
		ArrayList<StudentBean> list = new ArrayList<StudentBean>();
		String sql = "select A.code,A.name,A.idcard,A.postno, "
				+ "A.addr1,A.addr2,B.name,C.name,A.age from student A, professor B, dept C"
				+ " where A.professor = B.code and A.dept = C.code";
		System.out.println(sql);
		StudentBean data = null;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				data = new StudentBean();
				data.setCode(rs.getString("code"));
				data.setName(rs.getString("name"));
				data.setIdcard(rs.getString("idcard"));
				data.setPostno(rs.getString("postno"));
				data.setAddr1(rs.getString("addr1"));
				data.setAddr2(rs.getString("addr2"));
				data.setProfessor(rs.getString(7));
				data.setDept(rs.getString(8));
				data.setAge(rs.getString("age"));
				list.add(data);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public ArrayList<StudentBean> selectFind(String text) {
		ArrayList<StudentBean> list = new ArrayList<StudentBean>();
		String sql = "select * from student where code like '%"+text+"%' or name like '%"+text+"%' ";
		System.out.println(sql);
		StudentBean data = null;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				data = new StudentBean();
				data.setCode(rs.getString("code"));
				data.setName(rs.getString("name"));
				data.setIdcard(rs.getString("idcard"));
				data.setPostno(rs.getString("postno"));
				data.setAddr1(rs.getString("addr1"));
				data.setAddr2(rs.getString("addr2"));
				data.setProfessor(rs.getString("professor"));
				data.setDept(rs.getString("dept"));
				data.setAge(rs.getString("age"));
				list.add(data);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public boolean deleteRow(String code) {
		String sql= "delete from student where code = '"+code+"' ";
		System.out.println(sql);
		boolean success = false;
		try {
			cn = db.getConnection();
			ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.execute();
			success =true;
			cn.close();
			ps.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return success;
	}
	
	public boolean updateRow(StudentBean data) {
		StringBuilder sb = new StringBuilder();
		sb.append("update student set dept = '"+data.getDept()+"', name ='"+data.getName()+"',idcard = '"+data.getIdcard()+"', ");
		sb.append(" postno = '"+data.getPostno()+"', addr1='"+data.getAddr1()+"', addr2='"+data.getAddr2()+"', professor='"+data.getProfessor()+"' ");
		sb.append(" where code ='"+data.getCode()+"' ");
		String sql = sb.toString();
		System.out.println(sql);
		boolean success = false;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			ps.execute();
			success = true;
			cn.close();
			ps.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			success = false;
		}
		return success;
	}
	
//	public StudentBean deptName(String code){
//		ArrayList<String> list = new ArrayList<String>();
//		String sql = "select A.dept,B.name from student A, dept B where A.dept = B.code";
//		System.out.println(sql);
//		StudentBean data = null;
//		try {
//			cn = db.getConnection();
//			ps = cn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while(rs.next()){
//			data.setDept(rs.getString("name"));
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		return data;
//	}
}
