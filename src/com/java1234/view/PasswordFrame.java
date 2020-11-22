package com.java1234.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.java1234.dao.UserDao;
import com.java1234.model.User;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class PasswordFrame extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JTextField newpassword;
	
	private UserDao userDao=new UserDao();
	private DbUtil dbUtil= new DbUtil();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordFrame frame = new PasswordFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PasswordFrame() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 780, 535);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setBounds(200, 141, 81, 21);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_1.setBounds(200, 199, 81, 21);
		getContentPane().add(label_1);
		
		username = new JTextField();
		username.setBounds(280, 141, 230, 27);
		getContentPane().add(username);
		username.setColumns(10);
		
		newpassword = new JTextField();
		newpassword.setBounds(280, 197, 230, 27);
		getContentPane().add(newpassword);
		newpassword.setColumns(10);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
			/*
			 * 
			 * 修改密码提交按钮
			 * 
			 */
			public void actionPerformed(ActionEvent e) {
				changepwdActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u53D1\u9001-\u63D0\u4EA4.png"));
		button.setBounds(197, 270, 123, 29);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u91CD\u7F6E (1).png"));
		button_1.setBounds(383, 270, 123, 29);
		getContentPane().add(button_1);

	}

	private void resetActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.newpassword.setText(null);
		this.username.setText(null);
		
	}

	private void changepwdActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String cname=username.getText();
		String cpassword=newpassword.getText();
		//获取输入的文本
		if(StringUtil.isEmpty(cname)||StringUtil.isEmpty(cpassword)) {
			JOptionPane.showMessageDialog(null, "错误！请输入用户名和新密码！");
			return ;
		}
		/*
		 * 
		 * 修改密码
		
		 * 
		 */
		
		
			Connection con=null;
			try {
 				con=dbUtil.getCon();
 				User user=new User(cname,cpassword);
 				int updateNum=userDao.update(con, user);
 				if(updateNum==1) {
 					JOptionPane.showMessageDialog(null, "密码修改成功！");
 					this.resetActionPerformed(evt);
 				}else {
 					JOptionPane.showMessageDialog(null, "错误！密码修改失败！");
 				}
 				
 			}catch(Exception e) {
 				e.printStackTrace();
 			}finally {
 					try {
						dbUtil.closeCon(con);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		
	}

}
