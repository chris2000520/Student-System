package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java1234.model.User;

public class UserDao {

	public User login(Connection con ,User user)throws Exception{
		User resultUser=null;
		String sql="select * from userlog where uname=? and upsd=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			resultUser=new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUsername(rs.getString("uname"));
			resultUser.setPassword(rs.getString("upsd"));
			
		}
		return resultUser;
	}
	
	public int update(Connection con,User user)throws Exception{
		
		String sql="update userlog set upsd=? where uname=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(2,user.getUsername());
		pstmt.setString(1,user.getPassword());
		return pstmt.executeUpdate();
	}
}
