package com.naver.sdu0920.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBpoolConnectTestMain {

	public static void main(String[] args) throws Exception {
		DBConnectionManager db = DBConnectionManager.getInstance();
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		System.out.println("DB Start!");
		String sql = "select count(*) from member";
		try {
			cn = db.getConnection();
			ps = (PreparedStatement) cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1));	
			}
		} catch (SQLException e) {
			System.out.println("db error"+e.getMessage());
		}
	}
}
