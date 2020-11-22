package com.java1234.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbUtil {
		private String driver="com.mysql.cj.jdbc.Driver";//驱动名称
        private String url="jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
        private String user="root";//数据库用户
        private String psd="mysql1970s";//数据库密码
        
        
        public Connection getCon() throws Exception{
        	Class.forName(driver);
        	Connection con=DriverManager.getConnection(url,user,psd);
        	return con;
        }
        
        
        /*
                关闭数据库
        */
        public void closeCon(Connection con)throws Exception {
        	if(con!=null) {
        		con.close();
        	}
        }
        //Alt + / 是自动提示
        //main syso
        public static void main(String[] args) {
        	DbUtil dbUtil=new DbUtil();
        	try {
        		dbUtil.getCon();
        		System.out.println("数据库连接成功！");
        	}catch (Exception e) {
        		e.printStackTrace();
        		System.out.println("数据库连接失败！");
        	}
			
		}
	
}
