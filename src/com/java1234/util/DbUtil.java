package com.java1234.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbUtil {
		private String driver="com.mysql.cj.jdbc.Driver";//��������
        private String url="jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
        private String user="root";//���ݿ��û�
        private String psd="mysql1970s";//���ݿ�����
        
        
        public Connection getCon() throws Exception{
        	Class.forName(driver);
        	Connection con=DriverManager.getConnection(url,user,psd);
        	return con;
        }
        
        
        /*
                �ر����ݿ�
        */
        public void closeCon(Connection con)throws Exception {
        	if(con!=null) {
        		con.close();
        	}
        }
        //Alt + / ���Զ���ʾ
        //main syso
        public static void main(String[] args) {
        	DbUtil dbUtil=new DbUtil();
        	try {
        		dbUtil.getCon();
        		System.out.println("���ݿ����ӳɹ���");
        	}catch (Exception e) {
        		e.printStackTrace();
        		System.out.println("���ݿ�����ʧ�ܣ�");
        	}
			
		}
	
}
