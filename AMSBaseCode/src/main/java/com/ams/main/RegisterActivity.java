package com.ams.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

public class RegisterActivity {
	JFrame frame;
	JButton mSubmit,mCancel;
	
	JLabel textUsername,textPassword,textEmail
			,textFullName,textAge,textDob,textAddress,textContactNo,textGender;
	
	JTextField editUsername,editPassword,editEmail,editFullName
				,editAge,editAdress,editContactNo;
	
	JRadioButton radioMale,radioFMale,radioOther;
	
	JXDatePicker editDob;
	Date minDate;
	
	public RegisterActivity() {
		// TODO Auto-generated constructor stub
		frame = new JFrame("Registration ");
		
		mSubmit = new JButton("Submit");
		mCancel = new JButton("Cancel");
		
		textUsername = new JLabel("Username : ");
		textPassword = new JLabel("Password : ");
		textEmail = new JLabel("Email : ");
		textFullName = new JLabel("Full Name : ");
		textAge = new JLabel("Age : ");
		textDob = new JLabel("Date of birth : ");
		textAddress = new JLabel("Address : ");
		textContactNo = new JLabel("Contact No : ");
		textGender = new JLabel("Gender : ");
		
		editUsername = new JTextField();
		editPassword = new JTextField();
		editEmail = new JTextField();
		editFullName = new JTextField();
		editAge = new JTextField();
		editAdress = new JTextField();
		editContactNo = new JTextField();
		
		radioMale = new JRadioButton("Male");
		radioFMale = new JRadioButton("Female");
		radioOther = new JRadioButton("Other");
		
		try {
			minDate = new SimpleDateFormat("dd-MM-yyyy").parse("08-07-2000");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		textUsername.setLocation(20, 10);
		textUsername.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textUsername.setSize(100, 30);
		
		editUsername.setLocation(120, 10);
		editUsername.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		editUsername.setSize(180, 30);
		
		editDob = new JXDatePicker();
		editDob.setFormats("dd-MM-yyyy");
		editDob.setDate(minDate);
		editDob.setLocation(120,100);
		editDob.setSize(180,30);
		
		mSubmit.setLocation(20, 500);
		mSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mSubmit.setSize(100, 30);
		
		mCancel.setLocation(200, 500);
		mCancel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mCancel.setSize(100, 30);
		
		frame.add(textUsername);
		frame.add(editUsername);
		frame.add(editDob);
		frame.add(mCancel);
		frame.add(mSubmit);
		
		frame.setLayout(null);
		frame.setSize(340, 600);
		frame.getContentPane().setBackground(Color.decode("#99c2ff"));
		frame.getRootPane().setDefaultButton(mSubmit);
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
