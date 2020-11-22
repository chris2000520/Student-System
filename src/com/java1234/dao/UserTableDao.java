package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.java1234.model.UserTable;

public class UserTableDao {
    public int update(Connection con,UserTable user)throws Exception{
    	String sql="update usertable set cname=?,csex=?,cdate=?,cmajor=?";
    	PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,user.getUsername());
		pstmt.setString(2,user.getUsersex());
		pstmt.setString(3,user.getUserdate());
		pstmt.setString(4,user.getUsermajor());
		return pstmt.executeUpdate();
    }
}
