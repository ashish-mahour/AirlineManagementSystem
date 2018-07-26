package com.ams.activities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
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

import com.ams.customdialogs.WaitingDialog;
import com.ams.dao.impl.UserDAOImplements;
import com.ams.entities.UserData;
import com.ams.model.GlobalClass;
import com.ams.model.SendMail;
import com.ams.model.Validations;
import javax.swing.border.LineBorder;

public class RegisterActivity {
	JFrame frame;
	JButton mSubmit, mCancel;

	JLabel textUsername, textPassword, textEmail, textFullName, textAge, textDob, textAddress, textContactNo,
			textGender, textUType;

	JTextField editUsername, editPassword, editEmail, editFullName, editAge, editAdress, editContactNo;

	JRadioButton radioMale, radioFMale, radioOther, radioUser;

	ButtonGroup genderGroup, utypeGroup;

	JXDatePicker editDob;
	Date minDate;

	ArrayList<JTextField> list;

	UserDAOImplements userDAOImplements;

	SimpleDateFormat simpleDateFormat;

	private static WaitingDialog waitingDialog = new WaitingDialog("Processing..");

	public RegisterActivity() {
		// TODO Auto-generated constructor stub
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				waitingDialog.setVisible(true);
			}
		});
		t.setPriority(Thread.MAX_PRIORITY);
		t.start();
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				initGUI();
			}
		});
		t2.start();
	}

	private void initGUI() {
		frame = new JFrame("User Registration - AMS ");

		mSubmit = new JButton("Submit");
		mSubmit.setBorder(new LineBorder(new Color(153, 255, 255), 2, true));
		mSubmit.setBackground(new Color(0, 204, 204));

		mCancel = new JButton("Cancel");
		mCancel.setBorder(new LineBorder(new Color(153, 255, 255), 2, true));
		mCancel.setBackground(new Color(0, 204, 204));

		textUsername = new JLabel("Username : ");
		textUsername.setForeground(new Color(255, 255, 255));
		textPassword = new JLabel("Password : ");
		textPassword.setForeground(new Color(255, 255, 255));
		textEmail = new JLabel("Email : ");
		textEmail.setForeground(new Color(255, 255, 255));
		textFullName = new JLabel("Full Name : ");
		textFullName.setForeground(new Color(255, 255, 255));
		textAge = new JLabel("Age : ");
		textAge.setForeground(new Color(255, 255, 255));
		textDob = new JLabel("Date of birth : ");
		textDob.setForeground(new Color(255, 255, 255));
		textAddress = new JLabel("Address : ");
		textAddress.setForeground(new Color(255, 255, 255));
		textContactNo = new JLabel("Contact No : ");
		textContactNo.setForeground(new Color(255, 255, 255));
		textGender = new JLabel("Gender : ");
		textGender.setForeground(new Color(255, 255, 255));
		textUType = new JLabel("User Type :");
		textUType.setForeground(new Color(255, 255, 255));

		editUsername = new JTextField();
		editUsername.setBackground(new Color(153, 255, 153));
		editUsername.setBorder(new LineBorder(new Color(204, 255, 204), 2, true));

		editPassword = new JTextField();
		editPassword.setBackground(new Color(153, 255, 153));
		editPassword.setBorder(new LineBorder(new Color(204, 255, 204), 2, true));

		editEmail = new JTextField();
		editEmail.setBackground(new Color(153, 255, 153));
		editEmail.setBorder(new LineBorder(new Color(204, 255, 204), 2, true));

		editFullName = new JTextField();
		editFullName.setBackground(new Color(153, 255, 153));
		editFullName.setBorder(new LineBorder(new Color(204, 255, 204), 2, true));

		editAge = new JTextField();
		editAge.setBackground(new Color(153, 255, 153));
		editAge.setBorder(new LineBorder(new Color(204, 255, 204), 2, true));

		editAdress = new JTextField();
		editAdress.setBackground(new Color(153, 255, 153));
		editAdress.setBorder(new LineBorder(new Color(204, 255, 204), 2, true));

		editContactNo = new JTextField();
		editContactNo.setBackground(new Color(153, 255, 153));
		editContactNo.setBorder(new LineBorder(new Color(204, 255, 204), 2, true));

		genderGroup = new ButtonGroup();

		radioMale = new JRadioButton("Male");
		radioMale.setBackground(new Color(153, 255, 153));
		radioMale.setBorder(new LineBorder(new Color(204, 255, 204), 2, true));

		radioFMale = new JRadioButton("Female");
		radioFMale.setBackground(new Color(153, 255, 153));
		radioFMale.setBorder(new LineBorder(new Color(204, 255, 204), 2, true));

		radioOther = new JRadioButton("Other");
		radioOther.setBackground(new Color(153, 255, 153));
		radioOther.setBorder(new LineBorder(new Color(204, 255, 204), 2, true));

		utypeGroup = new ButtonGroup();

		radioUser = new JRadioButton("User");
		radioUser.setToolTipText("You can only be a user!");
		radioUser.setSelected(true);
		radioUser.setBackground(new Color(153, 255, 153));
		radioUser.setBorder(new LineBorder(new Color(204, 255, 204), 2, true));

		list = new ArrayList<JTextField>();

		userDAOImplements = new UserDAOImplements();

		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			minDate = new SimpleDateFormat("dd-MM-yyyy").parse("08-07-2000");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		textUsername.setLocation(20, 10);
		textUsername.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		textUsername.setSize(100, 30);

		editUsername.setLocation(120, 10);
		editUsername.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		editUsername.setSize(180, 30);

		textPassword.setLocation(20, 50);
		textPassword.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		textPassword.setSize(100, 30);

		editPassword.setLocation(120, 50);
		editPassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		editPassword.setSize(180, 30);

		textEmail.setLocation(20, 90);
		textEmail.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		textEmail.setSize(100, 30);

		editEmail.setLocation(120, 90);
		editEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		editEmail.setSize(180, 30);

		textDob.setLocation(20, 130);
		textDob.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		textDob.setSize(130, 30);

		editDob = new JXDatePicker();
		editDob.setFormats("dd-MM-yyyy");
		editDob.setDate(minDate);
		editDob.setLocation(150, 130);
		editDob.setSize(150, 30);
		editDob.getEditor().setBackground(new Color(153, 255, 153));
		editDob.getEditor().setBorder(new LineBorder(new Color(204, 255, 204), 2, true));

		textFullName.setLocation(20, 170);
		textFullName.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		textFullName.setSize(100, 30);

		editFullName.setLocation(120, 170);
		editFullName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		editFullName.setSize(180, 30);

		textAge.setLocation(20, 210);
		textAge.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		textAge.setSize(100, 30);

		editAge.setLocation(120, 210);
		editAge.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		editAge.setSize(180, 30);

		textAddress.setLocation(20, 250);
		textAddress.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		textAddress.setSize(100, 30);

		editAdress.setLocation(120, 250);
		editAdress.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		editAdress.setSize(180, 30);

		textContactNo.setLocation(20, 290);
		textContactNo.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		textContactNo.setSize(120, 30);

		editContactNo.setLocation(150, 290);
		editContactNo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		editContactNo.setSize(150, 30);

		textGender.setLocation(20, 330);
		textGender.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
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
		textUType.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		textUType.setSize(100, 30);

		radioUser.setLocation(120, 430);
		radioUser.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		radioUser.setSize(180, 30);
		utypeGroup.add(radioUser);

		mSubmit.setLocation(20, 500);
		mSubmit.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 18));
		mSubmit.setSize(130, 30);

		mCancel.setLocation(162, 500);
		mCancel.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 18));
		mCancel.setSize(138, 30);

		frame.getContentPane().add(textUsername);
		frame.getContentPane().add(editUsername);

		frame.getContentPane().add(textPassword);
		frame.getContentPane().add(editPassword);

		frame.getContentPane().add(textEmail);
		frame.getContentPane().add(editEmail);

		frame.getContentPane().add(textFullName);
		frame.getContentPane().add(editFullName);

		frame.getContentPane().add(textAge);
		frame.getContentPane().add(editAge);

		frame.getContentPane().add(textDob);
		frame.getContentPane().add(editDob);

		frame.getContentPane().add(textAddress);
		frame.getContentPane().add(editAdress);

		frame.getContentPane().add(textContactNo);
		frame.getContentPane().add(editContactNo);

		frame.getContentPane().add(textGender);
		frame.getContentPane().add(radioMale);
		frame.getContentPane().add(radioFMale);
		frame.getContentPane().add(radioOther);

		frame.getContentPane().add(textUType);
		frame.getContentPane().add(radioUser);

		frame.getContentPane().add(mCancel);
		frame.getContentPane().add(mSubmit);

		for (Component x : frame.getContentPane().getComponents()) {
			if (x instanceof JTextField) {
				list.add((JTextField) x);
			}

		}

		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(RegisterActivity.class.getResource("/images/planeIcon.png")));
		frame.getContentPane().setLayout(null);
		frame.setSize(340, 600);
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.getRootPane().setDefaultButton(mSubmit);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		show();
	}

	private void show() {
		mSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (!Validations.validateTextField(list)) {
					JOptionPane.showMessageDialog(frame, "Please fill all the fields!!", "Alert",
							JOptionPane.ERROR_MESSAGE);
				} else if (!radioMale.isSelected() && !radioFMale.isSelected() && !radioOther.isSelected()) {
					JOptionPane.showMessageDialog(frame, "Please check any one gender!", "Alert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					final UserData userData = new UserData();
					userData.setId(1);
					userData.setUserName(editUsername.getText());
					userData.setPassword(editPassword.getText());
					userData.setEmail(editEmail.getText());
					userData.setFullName(editFullName.getText());
					try {
						userData.setAge(Integer.parseInt(editAge.getText()));
						userData.setContactNo(Long.parseLong(editContactNo.getText()));
					} catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(frame, e.getMessage(), "Alert", JOptionPane.ERROR_MESSAGE);
					}
					userData.setDob(simpleDateFormat.format(editDob.getDate()));
					userData.setAddress(editAdress.getText());
					if (radioMale.isSelected()) {
						userData.setGender("M");
					} else if (radioFMale.isSelected()) {
						userData.setGender("F");
					} else if (radioOther.isSelected()) {
						userData.setGender("O");
					}
					userData.setUserType("User");

					final String genratedOTP = GlobalClass.getOTP();
					boolean sent = new SendMail("Sending OTP...").send(userData.getEmail(), "One Step Verification - AMS", "Hello "
							+ userData.getFullName() + ",\nYour OTP : " + genratedOTP
							+ "\nIt will be expire in 10 minutes. Please do verify before 10 minutes otherwise you will be terminated!");
					System.out.println(sent);
					if (sent) {
						String userEnteredOTP = "";
						JOptionPane.showMessageDialog(frame, "OTP Sent to " + userData.getEmail(), "Alert - AMS",
								JOptionPane.INFORMATION_MESSAGE);
						userEnteredOTP = JOptionPane.showInputDialog(frame, "Enter OTP :", "Alert - AMS",
								JOptionPane.INFORMATION_MESSAGE);
						if (userEnteredOTP == null) {
							JOptionPane.showMessageDialog(frame, "User not Registered!", "Success",
									JOptionPane.ERROR_MESSAGE);
							frame.dispose();
							new MainActivity().show();
						} else if (userEnteredOTP.trim().equalsIgnoreCase(genratedOTP)) {
							userData.setUserStatus(true);
							userDAOImplements.saveUser(userData);
							JOptionPane.showMessageDialog(frame, "User Registered!", "Success",
									JOptionPane.INFORMATION_MESSAGE);
							frame.dispose();
							new MainActivity().show();
						}
					}

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
		waitingDialog.setVisible(false);
	}

}
