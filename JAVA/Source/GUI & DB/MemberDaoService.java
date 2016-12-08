package kr.ac.itschool.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.ac.itschool.custom.CustomDateFormat;
import kr.ac.itschool.custom.DBConnectionManager;
import kr.ac.itschool.dao.MemberDao;
import kr.ac.itschool.entities.Member;

public class MemberDaoService implements MemberDao {
	DBConnectionManager db = new DBConnectionManager();
	Connection cn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public boolean insertRow(Member data) {
		boolean success = false;
		String inputdate = CustomDateFormat.dateFormat();
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT into member (id,name,password,phone1,phone2,");
		sb.append("phone3,post,addr1,addr2,cardno,job,picture,inputdate");
		sb.append(")values(");
		sb.append(" '"+data.getId()+"','"+data.getName()+"','"+data.getPassword()+"', ");
		sb.append(" '"+data.getPhone1()+"','"+data.getPhone2()+"','"+data.getPhone3()+"', ");
		sb.append(" '"+data.getPost()+"','"+data.getAddr1()+"','"+data.getAddr2()+"', ");
		sb.append(" '"+data.getCardno()+"','"+data.getJob()+"','"+data.getPicture()+"', ");
		sb.append(" '"+inputdate+"')");
		String sql = sb.toString();
		System.out.println(sql);
		
		try {
			cn = db.getConnection();
			ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.execute();
			success = true;
			cn.close();
			ps.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return success;
	}

	public boolean findId(String id) {
		String sql = "select id From member where id = '"+id+"' ";
		boolean findid = false;
		try {
			cn = db.getConnection();
			ps = (PreparedStatement) cn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				findid = true;
			}
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("db error"+e.getMessage());
		}
		return findid;
	}

	public ArrayList<Member> selectAll() {
		ArrayList<Member> list = new ArrayList<Member>();
		Member data =null;
		String sql = "select * From member";
		try {
			cn = db.getConnection();
			ps = (PreparedStatement) cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				data = new Member();
				data.setId(rs.getString("id"));
				data.setName(rs.getString("name"));
				data.setPassword(rs.getString("password"));
				data.setPhone1(rs.getString("phone1"));
				data.setPhone2(rs.getString("phone2"));
				data.setPhone3(rs.getString("phone3"));
				data.setPost(rs.getString("post"));
				data.setAddr1(rs.getString("addr1"));
				data.setAddr2(rs.getString("addr2"));
				data.setCardno(rs.getString("cardno"));
				data.setJob(rs.getString("job"));
				data.setPicture(rs.getString("picture"));
				data.setInputdate(rs.getString("inputdate"));
				list.add(data);
			}
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("db error"+e.getMessage());
		}
		return list;
	}

	@Override
	public ArrayList<Member> selectFind(String find) {
		ArrayList<Member> list = new ArrayList<Member>();
		Member data = null;
		String sql = "select * From member where id like '%"+find+"%' or name like '%"+find+"%' ";
		try {
			cn = db.getConnection();
			ps = (PreparedStatement) cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				data = new Member();
				data.setId(rs.getString("id"));
				data.setName(rs.getString("name"));
				data.setPassword(rs.getString("password"));
				data.setPhone1(rs.getString("phone1"));
				data.setPhone2(rs.getString("phone2"));
				data.setPhone3(rs.getString("phone3"));
				data.setPost(rs.getString("post"));
				data.setAddr1(rs.getString("addr1"));
				data.setAddr2(rs.getString("addr2"));
				data.setCardno(rs.getString("cardno"));
				data.setJob(rs.getString("job"));
				data.setPicture(rs.getString("picture"));
				data.setInputdate(rs.getString("inputdate"));
				list.add(data);
			}
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("db error"+e.getMessage());
		}
		return list;		
	}

	@Override
	public Member selectRowone(String id) {
		String sql= "select *from member where id = '"+id+"' ";
		Member data = null;
		try {
			cn = db.getConnection();
			ps = (PreparedStatement) cn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				data = new Member();
				data.setId(rs.getString("id"));
				data.setName(rs.getString("name"));
				data.setPassword(rs.getString("password"));
				data.setPhone1(rs.getString("phone1"));
				data.setPhone2(rs.getString("phone2"));
				data.setPhone3(rs.getString("phone3"));
				data.setPost(rs.getString("post"));
				data.setAddr1(rs.getString("addr1"));
				data.setAddr2(rs.getString("addr2"));
				data.setCardno(rs.getString("cardno"));
				data.setJob(rs.getString("job"));
				data.setPicture(rs.getString("picture"));
				data.setInputdate(rs.getString("inputdate"));
			}
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}

	@Override
	public boolean deleteRow(String id) {
		String sql= "delete from member where id = '"+id+"' ";
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
	public String updateRow(Member data) {
		String result = "";
		StringBuilder sb = new StringBuilder();
		sb.append("update member set password= '"+data.getPassword()+"',name='"+data.getName()+"' ,");
		sb.append(" phone1='"+data.getPhone1()+"',phone2 ='"+data.getPhone2()+"',phone3 = '"+data.getPhone3()+"' ,");
		sb.append(" post = '"+data.getPost()+"', Addr1 = '"+data.getAddr1()+"',Addr2 = '"+data.getAddr2()+"' ,Cardno = '"+data.getCardno()+"', ");
		sb.append(" picture = '"+data.getPicture()+"',job = '"+data.getJob()+"', inputdate = '"+data.getInputdate()+"' ");
		sb.append(" where id ='"+data.getId()+"' ");
		String sql = sb.toString();
		System.out.println(sql);
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			ps.execute();
			cn.close();
			ps.close();
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}
}
