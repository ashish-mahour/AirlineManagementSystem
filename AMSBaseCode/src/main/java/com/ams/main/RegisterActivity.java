package com.ams.main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RegisterActivity {
	JFrame frame;
	JButton mSubmit,mCancel;
	public RegisterActivity() {
		// TODO Auto-generated constructor stub
		frame = new JFrame("Registration ");
		mSubmit = new JButton("Submit");
		mCancel = new JButton("Cancel");
		
		mSubmit.setLocation(20, 500);
		mSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mSubmit.setSize(100, 30);
		
		mCancel.setLocation(200, 500);
		mCancel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mCancel.setSize(100, 30);
		
		frame.add(mCancel);
		frame.add(mSubmit);
		
		frame.setLayout(null);
		frame.setSize(340, 600);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void show() {
		mSubmit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(frame, "Click on submit !!", "Status!!", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		mCancel.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					new MainActivity().show();
					frame.dispose();
				}
		});
		
	}

}
