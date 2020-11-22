package com.java1234.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.java1234.dao.UserTableDao;
import com.java1234.model.UserTable;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class UserManagerFrame extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	private UserTableDao userDao=new UserTableDao();
	private DbUtil dbUtil= new DbUtil();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManagerFrame frame = new UserManagerFrame();
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
	public UserManagerFrame() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 617, 448);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setBounds(98, 42, 81, 21);
		getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel.setBounds(98, 97, 81, 21);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u51FA\u751F\u5E74\u6708\uFF1A");
		lblNewLabel_1.setBounds(98, 157, 105, 21);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u4E13\u4E1A\uFF1A");
		lblNewLabel_2.setBounds(98, 215, 81, 21);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(180, 39, 160, 27);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 102, 160, 27);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(180, 154, 160, 27);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(180, 212, 160, 27);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton button = new JButton("\u4FDD\u5B58");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateActionPerformmed(e);
			}
		});
		button.setIcon(new ImageIcon("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u5DF2\u6295\u9012.png"));
		button.setBounds(101, 300, 123, 29);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
			
		});
		button_1.setIcon(new ImageIcon("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u91CD\u7F6E (1).png"));
		button_1.setBounds(270, 300, 123, 29);
		getContentPane().add(button_1);

	}

	protected void updateActionPerformmed(ActionEvent e) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String cname=textField.getText();
				String csex=textField_1.getText();
				String cdate=textField_2.getText();
				String cmajor=textField_3.getText();
				//获取输入的文本
				if(StringUtil.isEmpty(cname)||StringUtil.isEmpty(csex)||StringUtil.isEmpty(cdate)||StringUtil.isEmpty(cmajor)) {
					JOptionPane.showMessageDialog(null, "错误！请填写完整的信息！");
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
		 				UserTable user=new UserTable(cname,csex,cdate,cmajor);
		 				int updateNum=userDao.update(con, user);
		 				if(updateNum==1) {
		 					JOptionPane.showMessageDialog(null, "修改成功！");
		 					this.resetValueActionPerformed(e);
		 				}else {
		 					JOptionPane.showMessageDialog(null, "错误！修改失败！");
		 				}
		 				
		 			}catch(Exception e1) {
		 				e1.printStackTrace();
		 			}finally {
		 					try {
								dbUtil.closeCon(con);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					}
				

		
	}

	protected void resetValueActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.textField.setText(null);
		this.textField_1.setText(null);
		this.textField_2.setText(null);
		this.textField_3.setText(null);
		
	}

}
