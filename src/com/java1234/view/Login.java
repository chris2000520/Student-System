package com.java1234.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java1234.dao.UserDao;
import com.java1234.model.User;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	private DbUtil dbUtil=new DbUtil();
	private UserDao userdao=new UserDao();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setBackground(SystemColor.activeCaption);
		setTitle("\u767B\u9646\u9875\u9762");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u7535\u8111 (1).png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 461);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6821\u56ED\u62DB\u8058\u7CFB\u7EDF");
		label.setIcon(new ImageIcon("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u5B66\u751F.png"));
		label.setFont(new Font("幼圆", Font.BOLD, 30));
		label.setBounds(129, 15, 360, 173);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label_1.setIcon(new ImageIcon("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u7528\u6237\u540D.png"));
		label_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_1.setBounds(139, 203, 108, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u5BC6\u7801.png"));
		label_2.setFont(new Font("幼圆", Font.PLAIN, 18));
		label_2.setBounds(139, 257, 81, 26);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setFont(new Font("幼圆", Font.PLAIN, 18));
		textField.setBounds(265, 199, 224, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(265, 256, 224, 26);
		contentPane.add(passwordField);
		
		JButton button = new JButton("\u767B\u9646");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerfromed(e);
			}
		});
		button.setIcon(new ImageIcon("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u53D1\u9001-\u63D0\u4EA4.png"));
		button.setFont(new Font("幼圆", Font.PLAIN, 18));
		button.setBounds(137, 350, 123, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u91CD\u7F6E (1).png"));
		button_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		button_1.setBounds(364, 350, 123, 29);
		contentPane.add(button_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\u8BB0\u4F4F\u5BC6\u7801");
		chckbxNewCheckBox.setBackground(SystemColor.inactiveCaption);
		chckbxNewCheckBox.setFont(new Font("幼圆", Font.PLAIN, 18));
		chckbxNewCheckBox.setBounds(136, 304, 114, 29);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("\u81EA\u52A8\u767B\u9646");
		chckbxNewCheckBox_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		chckbxNewCheckBox_1.setBackground(SystemColor.inactiveCaption);
		chckbxNewCheckBox_1.setBounds(378, 304, 111, 29);
		contentPane.add(chckbxNewCheckBox_1);
		
		//设置居中
		this.setLocationRelativeTo(null);
	}
	

	// 重置内容
	private void resetValueActionPerformed(ActionEvent evt) {
		this.textField.setText(null);
		this.passwordField.setText(null);
		
	}
	
	//登陆事件
	private void loginActionPerfromed(ActionEvent evt) {
		String username=this.textField.getText();
		String password=new String(this.passwordField.getPassword());
		/*
		  判空事件
		 */
		if(StringUtil.isEmpty(username)) {
			JOptionPane.showMessageDialog(null,"用户名不能为空！");
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
		}
		/*
		   登陆验证
		 */
		User user=new User(username,password);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			User currentUser=userdao.login(con, user);
			if(currentUser!=null) {
				JOptionPane.showMessageDialog(null, "登陆成功！");
				
				dispose();//销毁窗口
				
				new MainFrame().setVisible(true);//诱导新窗口
				
			}else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误！");
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
