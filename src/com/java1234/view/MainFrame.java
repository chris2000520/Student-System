package com.java1234.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import java.awt.Frame;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane table = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u7535\u8111 (1).png"));
		setTitle("\u6821\u56ED\u62DB\u8058\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u57FA\u672C\u6570\u636E");
		menu.setIcon(new ImageIcon("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u8BA2\u5355.png"));
		menuBar.add(menu);
		
		JMenu menu_2 = new JMenu("\u4E2A\u4EBA\u4FE1\u606F");
		menu_2.setIcon(new ImageIcon("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u4E2A\u4EBA.png"));
		menu.add(menu_2);
		
		JMenuItem menuItem_1 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 
				 * 修改密码
				 * 
				 */
				PasswordFrame passwordframe=new PasswordFrame();
				passwordframe.setVisible(true);
				table.add(passwordframe);
			}
		});
		menu_2.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F");
		menuItem_2.addActionListener(new ActionListener() {
			/*
			 * 修改用户信息
			 */
			public void actionPerformed(ActionEvent e) {
				UserManagerFrame usermanagerframe=new UserManagerFrame();
				usermanagerframe.setVisible(true);
				table.add(usermanagerframe);
				
			}
		});
		menu_2.add(menuItem_2);
		
		JMenu menu_3 = new JMenu("\u804C\u4F4D\u67E5\u770B");
		menu_3.setIcon(new ImageIcon("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u516C\u53F8.png"));
		menu.add(menu_3);
		/*
		 * 
		 * 添加职位表
		 */
		JMenuItem menuItem_3 = new JMenuItem("\u6295\u9012\u804C\u4F4D");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkFrame workframe=new WorkFrame();
				workframe.setVisible(true);
				table.add(workframe);
			}
		});
		menu_3.add(menuItem_3);
		/*
		 * 
		 * 显示职位表
		 */
		JMenuItem menuItem_4 = new JMenuItem("\u67E5\u770B\u804C\u4F4D");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkMangerFrame workmanagerframe=new WorkMangerFrame();
				workmanagerframe.setVisible(true);
				table.add(workmanagerframe);
			}
		});
		menu_3.add(menuItem_4);
		
		
		//退出系统
		JMenuItem menuItem = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res= JOptionPane.showConfirmDialog(null, "是否退出系统？");
				if(res==0) {
					dispose();
				}
				//System.out.println(res);
				//是0，否1，取消2
			}
		});
		menuItem.setIcon(new ImageIcon("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u9000\u51FA (1).png"));
		menu.add(menuItem);
		
		JMenu menu_1 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		menu_1.setIcon(new ImageIcon("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u5173\u4E8E.png"));
		menuBar.add(menu_1);
		
		// 关于我们
		JMenuItem mntmchris = new JMenuItem("\u5173\u4E8EChris");
		mntmchris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AboutFrame about=new AboutFrame();
					about.setVisible(true);
					table.add(about);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		mntmchris.setIcon(new ImageIcon("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u8D5E.png"));
		menu_1.add(mntmchris);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0,0));
		
		table =new JDesktopPane();
		contentPane.add(table, BorderLayout.CENTER);
		//设置窗口最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	}
}
