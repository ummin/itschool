package kr.ac.itschool.service.join0801;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.ac.itschool.custom.DBConnectionManager;
import kr.ac.itschool.dao.join0801.DeptDao;
import kr.ac.itschool.entities.join0801.DeptBean;

public class DeptDaoService implements DeptDao {
	DBConnectionManager db = new DBConnectionManager();
	Connection cn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public boolean insertRow(DeptBean data) {
		StringBuilder sb = new StringBuilder();
		sb.append("insert into dept (code,name) values ( ");
		sb.append(" '"+data.getCode()+"', '"+data.getName()+"') ");
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

	@Override
	public boolean findId(String code) {
		String sql = "select *from dept where code like '"+code+"' ";
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

	@Override
	public DeptBean selectRowone(String code) {
		String sql = "select * from dept where code = '"+code+"'";
		System.out.println(sql);
		DeptBean data = null;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				data = new DeptBean();
				data.setCode(rs.getString("code"));
				data.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}

	@Override
	public ArrayList<DeptBean> selectAll() {
		ArrayList<DeptBean> list = new ArrayList<DeptBean>();
		String sql = "select * from dept";
		System.out.println(sql);
		DeptBean data = null;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				data = new DeptBean();
				data.setCode(rs.getString("code"));
				data.setName(rs.getString("name"));
				list.add(data);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	@Override
	public ArrayList<DeptBean> selectFind(String text) {
		ArrayList<DeptBean> list = new ArrayList<DeptBean>();
		String sql = "select * from dept where code like '%"+text+"%' ";
		System.out.println(sql);
		DeptBean data = null;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				data = new DeptBean();
				data.setCode(rs.getString("code"));
				data.setName(rs.getString("name"));
				list.add(data);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	@Override
	public boolean deleteRow(String code) {
		String sql= "delete from dept where code = '"+code+"' ";
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

	@Override
	public boolean updateRow(DeptBean data) {
		StringBuilder sb = new StringBuilder();
		sb.append("update dept set name = '"+data.getName()+"' where code ='"+data.getCode()+"'");
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

	@Override
	public ArrayList<String> selectDept() {
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select A.code,A.name from dept A";
		System.out.println(sql);
		DeptBean data = null;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(rs.getString("code")+" "+rs.getString("name"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
		}
	
	public String deptName(String name) {
		String sql = "select code from dept where name = '"+name+"' ";
		System.out.println(sql);
		String code = null;
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				 code = rs.getString("code");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return code;
	}
}

