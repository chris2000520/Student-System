package com.java1234.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.java1234.dao.WorkDao;
import com.java1234.model.WorkType;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class WorkFrame extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	private WorkDao workDao=new WorkDao();
	private DbUtil dbUtil= new DbUtil();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkFrame frame = new WorkFrame();
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
	public WorkFrame() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		
		JLabel lblNewLabel = new JLabel("\u516C\u53F8\u540D\u79F0\uFF1A");
		
		JLabel label = new JLabel("\u516C\u53F8\u5730\u5740\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u516C\u53F8\u804C\u4F4D\uFF1A");
		
		JLabel label_1 = new JLabel("");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JButton button = new JButton("\u6295\u9012");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				workAddActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u5DF2\u6295\u9012.png"));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
				/*
				 * 
				 * 按钮事件
				 */
			}
		});
		button_1.setIcon(new ImageIcon("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u91CD\u7F6E (1).png"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(461)
							.addComponent(label_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(175)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(label)
								.addComponent(lblNewLabel_1)
								.addComponent(button))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(9)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(textField_1, Alignment.LEADING, 222, 222, Short.MAX_VALUE)
										.addComponent(button_1)
										.addComponent(textField, Alignment.LEADING)))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_2, 220, 220, 220)))))
					.addContainerGap(560, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(288)
					.addComponent(label_1)
					.addContainerGap(376, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setIconifiable(true);
		setClosable(true);
		setTitle("\u804C\u4F4D\u6295\u9012");
		setBounds(100, 100, 722, 402);
		/*
		 * 
		 * 重置表单
		 */
        }
	   
		
 		private void workAddActionPerformed(ActionEvent evt) {
 			String wname=this.textField.getText();
 			String waddress=this.textField_1.getText();
 			String wpost=this.textField_2.getText();
 			if(StringUtil.isEmpty(wname)||StringUtil.isEmpty(waddress)||StringUtil.isEmpty(wpost)) {
 				JOptionPane.showMessageDialog(null, "这三个选项为必填选项！");
 			}else {
	 			WorkType workType=new WorkType(wname, waddress, wpost);
	 			Connection con=null;
	 			try {
	 				con=dbUtil.getCon();
	 				int n=workDao.add(con, workType);
	 				if(n==1) {
	 					JOptionPane.showMessageDialog(null, "成功添加一条记录！");
	 					this.resetValue();
	 				}else {
	 					JOptionPane.showMessageDialog(null, "添加记录失败！");
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
		// TODO Auto-generated method stub
		private void resetValue() {
			this.textField.setText(null);
			this.textField_1.setText(null);
			this.textField_2.setText(null);
		}
		private void resetValueActionPerformed(ActionEvent evt) {
        	this.resetValue();	
	}
}
