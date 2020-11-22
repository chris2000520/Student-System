package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java1234.model.WorkType;
import com.java1234.util.StringUtil;

public class WorkDao {
	/*
	 * ������ѡ������λ
	 */
	public int add(Connection con,WorkType work)throws Exception{
		String sql="insert into work values(?,?,?)";
		//���������ƣ���ַ����λ
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, work.getWname());
		pstmt.setString(2, work.getWaddress());
		pstmt.setString(3, work.getWpost());
		return pstmt.executeUpdate();
	}
	/*
	 * ��ѯ��Ͷ�ݵĹ�˾
	 */
	public ResultSet list(Connection con,WorkType work)throws Exception{
		StringBuffer sb=new StringBuffer("select * from work");
		if(StringUtil.isNotEmpty(work.getWname())) {
			sb.append(" and wname like '%"+work.getWname()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	public int delete (Connection con, String name)throws Exception{
		String sql="delete from work where wname=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, name);
		return pstmt.executeUpdate();
	}
	
	
 
}
