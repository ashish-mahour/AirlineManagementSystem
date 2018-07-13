package com.ams.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import com.ams.model.Validations;

public class RegisterActivity {
	JFrame frame;
	JButton mSubmit, mCancel;

	JLabel textUsername, textPassword, textEmail, textFullName, textAge, textDob, textAddress, textContactNo,
			textGender, textUType;

	JTextField editUsername, editPassword, editEmail, editFullName, editAge, editAdress, editContactNo;

	JRadioButton radioMale, radioFMale, radioOther, radioAdmin, radioUser;

	ButtonGroup genderGroup, utypeGroup;

	JXDatePicker editDob;
	Date minDate;

	ArrayList<JTextField> list;

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
		textUType = new JLabel("User Type :");

		editUsername = new JTextField();
		editPassword = new JTextField();
		editEmail = new JTextField();
		editFullName = new JTextField();
		editAge = new JTextField();
		editAdress = new JTextField();
		editContactNo = new JTextField();

		genderGroup = new ButtonGroup();
		radioMale = new JRadioButton("Male");
		radioFMale = new JRadioButton("Female");
		radioOther = new JRadioButton("Other");

		utypeGroup = new ButtonGroup();
		radioAdmin = new JRadioButton("Admin");
		radioUser = new JRadioButton("User");

		list = new ArrayList<JTextField>();

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

		textPassword.setLocation(20, 50);
		textPassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textPassword.setSize(100, 30);

		editPassword.setLocation(120, 50);
		editPassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		editPassword.setSize(180, 30);

		textEmail.setLocation(20, 90);
		textEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textEmail.setSize(100, 30);

		editEmail.setLocation(120, 90);
		editEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		editEmail.setSize(180, 30);

		textDob.setLocation(20, 130);
		textDob.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textDob.setSize(130, 30);

		editDob = new JXDatePicker();
		editDob.setFormats("dd-MM-yyyy");
		editDob.setDate(minDate);
		editDob.setLocation(150, 130);
		editDob.setSize(150, 30);

		textFullName.setLocation(20, 170);
		textFullName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textFullName.setSize(100, 30);

		editFullName.setLocation(120, 170);
		editFullName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		editFullName.setSize(180, 30);

		textAge.setLocation(20, 210);
		textAge.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textAge.setSize(100, 30);

		editAge.setLocation(120, 210);
		editAge.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		editAge.setSize(180, 30);

		textAddress.setLocation(20, 250);
		textAddress.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textAddress.setSize(100, 30);

		editAdress.setLocation(120, 250);
		editAdress.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		editAdress.setSize(180, 30);

		textContactNo.setLocation(20, 290);
		textContactNo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textContactNo.setSize(100, 30);

		editContactNo.setLocation(120, 290);
		editContactNo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		editContactNo.setSize(180, 30);

		textGender.setLocation(20, 330);
		textGender.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textGender.setSize(100, 30);

		radioMale.setLocation(120, 330);
		radioMale.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		radioMale.setSize(180, 30);

		radioFMale.setLocation(120, 360);
		radioFMale.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		radioFMale.setSize(180, 30);

		radioOther.setLocation(120, 390);
		radioOther.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		radioOther.setSize(180, 30);

		genderGroup.add(radioMale);
		genderGroup.add(radioFMale);
		genderGroup.add(radioOther);

		textUType.setLocation(20, 430);
		textUType.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textUType.setSize(100, 30);

		radioAdmin.setLocation(120, 430);
		radioAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		radioAdmin.setSize(180, 30);

		radioUser.setLocation(120, 460);
		radioUser.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		radioUser.setSize(180, 30);

		utypeGroup.add(radioAdmin);
		utypeGroup.add(radioUser);

		mSubmit.setLocation(20, 500);
		mSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mSubmit.setSize(100, 30);

		mCancel.setLocation(200, 500);
		mCancel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mCancel.setSize(100, 30);

		frame.add(textUsername);
		frame.add(editUsername);

		frame.add(textPassword);
		frame.add(editPassword);

		frame.add(textEmail);
		frame.add(editEmail);

		frame.add(textFullName);
		frame.add(editFullName);

		frame.add(textAge);
		frame.add(editAge);

		frame.add(textDob);
		frame.add(editDob);

		frame.add(textAddress);
		frame.add(editAdress);

		frame.add(textContactNo);
		frame.add(editContactNo);

		frame.add(textGender);
		frame.add(radioMale);
		frame.add(radioFMale);
		frame.add(radioOther);

		frame.add(textUType);
		frame.add(radioAdmin);
		frame.add(radioUser);

		frame.add(mCancel);
		frame.add(mSubmit);

		for (Component x : frame.getContentPane().getComponents()) {
			if (x instanceof JTextField) {
				list.add((JTextField) x);
			}

		}

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
				if (!Validations.validateTextField(list)) {
					JOptionPane.showMessageDialog(frame, "Please fill all the fields!!", "Alert",
							JOptionPane.ERROR_MESSAGE);
				} else if (!radioMale.isSelected() && !radioFMale.isSelected() && !radioOther.isSelected()) {
					JOptionPane.showMessageDialog(frame, "Please check any one gender!", "Alert",
							JOptionPane.ERROR_MESSAGE);
				} else if (!radioAdmin.isSelected() && !radioUser.isSelected()) {
					JOptionPane.showMessageDialog(frame, "Please check any one user type!", "Alert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					
				}

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
