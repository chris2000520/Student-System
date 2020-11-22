package com.java1234.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.SystemColor;
import java.beans.PropertyVetoException;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class AboutFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = (long) 1.0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutFrame frame = new AboutFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public AboutFrame() throws PropertyVetoException {
		setClosable(true);
		setIconifiable(true);
		setClosed(true);
		getContentPane().setBackground(SystemColor.inactiveCaption);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Java\\Eclipse-workspace\\StudentManager\\src\\images\\\u6307\u5357\u9488.png"));
		label.setBounds(57, 48, 133, 103);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u8F6F\u4EF6\u540D\u79F0\uFF1A");
		label_1.setBounds(225, 69, 106, 21);
		getContentPane().add(label_1);
		
		JLabel lblNewLabel = new JLabel("\u7248\u672C\u53F7\uFF1A");
		lblNewLabel.setBounds(228, 126, 81, 21);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5F00\u53D1\u4EBA\u5458\uFF1A");
		lblNewLabel_1.setBounds(227, 181, 109, 21);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblCopyrightSina = new JLabel("Copyright \u00A92019-2020 \u5B66\u6D77\u65E0\u6DAF, All Rights Reserved");
		lblCopyrightSina.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		lblCopyrightSina.setBounds(320, 365, 437, 31);
		getContentPane().add(lblCopyrightSina);
		
		JLabel label_2 = new JLabel("\u6821\u56ED\u62DB\u8058\u7CFB\u7EDF");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		label_2.setBounds(321, 69, 128, 21);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("1.1.0");
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		label_3.setBounds(319, 126, 81, 21);
		getContentPane().add(label_3);
		
		JLabel lblChris = new JLabel("Chris");
		lblChris.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		lblChris.setBounds(322, 180, 81, 21);
		getContentPane().add(lblChris);
		setTitle("\u5173\u4E8E\u6211\u4EEC");
		setBounds(100, 100, 776, 448);

	}
}
