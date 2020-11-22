package com.java1234.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.java1234.dao.WorkDao;
import com.java1234.model.WorkType;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WorkMangerFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private WorkDao workDao=new WorkDao();
	private DbUtil dbUtil= new DbUtil();
	private JTextField workname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkMangerFrame frame = new WorkMangerFrame();
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
	public WorkMangerFrame() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u516C\u53F8\u540D\u79F0\uFF1A");
		
		workname = new JTextField();
		workname.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				workTypeSearchAactionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u67E5\u627E.png"));
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				workTypeDeleteActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u5220 \u9664 .png"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPane, Alignment.LEADING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(workname, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addComponent(button)
							.addGap(18)
							.addComponent(button_1)))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(43)
									.addComponent(label))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(41)
									.addComponent(workname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(button)
								.addComponent(button_1))))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u516C\u53F8\u540D\u79F0", "\u516C\u53F8\u5730\u5740", "\u516C\u53F8\u804C\u4F4D"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(167);
		table.getColumnModel().getColumn(1).setPreferredWidth(182);
		table.getColumnModel().getColumn(2).setPreferredWidth(173);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		setTitle("\u5DE5\u4F5C\u7BA1\u7406");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 740, 448);
		
		this.fillTable(new WorkType());

	}
	/*
	 * 
	 * 删除工作
	 * 
	 */
	private void workTypeDeleteActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String wname=workname.getText();
		if(StringUtil.isEmpty(wname)) {
			JOptionPane.showMessageDialog(null, "错误！请选择要删除的记录！");
			return ;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0) {
			Connection con=null;
			try {
 				con=dbUtil.getCon();
				int deleteNum=workDao.delete(con, wname);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					this.fillTable(new WorkType());
				}else {
					JOptionPane.showMessageDialog(null, "删除失败！");
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

	

	/*
	 * 
	 * 工作查询
	 * 
	 */
	private void workTypeSearchAactionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String s_workname=this.workname.getText();
		//输入的工作名称
		WorkType worktype =new WorkType();
		worktype.setWname(s_workname);
		//传给worktype对象
		this.fillTable(worktype);
		
	}

	/*
	 * 
	 * 查询所有已投递的公司
	 * 
	 */
	private void  fillTable(WorkType work) {
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=workDao.list(con,work);
			while(rs.next()) {
				Vector<String> v=new Vector<String> ();
				v.add(rs.getString(1));
				v.add(rs.getString(2));
				v.add(rs.getString(3));
				dtm.addRow(v);
			}
		}catch(Exception e){
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
