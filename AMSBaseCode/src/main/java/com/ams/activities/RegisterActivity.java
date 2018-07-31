package com.ams.activities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import com.ams.customdialogs.VerifingOTP;
import com.ams.customdialogs.WaitingDialog;
import com.ams.entities.UserData;
import com.ams.model.EncryptString;
import com.ams.model.GlobalClass;
import com.ams.model.SendMail;
import com.ams.model.Validations;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;

public class RegisterActivity {
	JFrame frame;
	JButton mSubmit, mCancel;

	JLabel textUsername, textPassword, textEmail, textFullName, textAge, textDob, textAddress, textContactNo,
			textGender, textUType;

	JTextField editUsername, editEmail, editFullName, editAge, editAdress, editContactNo;
	
	JPasswordField editPassword;

	JRadioButton radioMale, radioFMale, radioOther, radioUser;

	ButtonGroup genderGroup, utypeGroup;

	JXDatePicker editDob;
	Date minDate;

	ArrayList<JTextField> list;

	SimpleDateFormat simpleDateFormat;

	private static WaitingDialog waitingDialog = new WaitingDialog("Processing..");
	private final JPanel panel = new JPanel();
	private final JLabel lblTitle = new JLabel("User Registration - AMS ");
	private final JButton btnClose = new JButton("X");

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

	/**
	 * @wbp.parser.entryPoint
	 */
	private void initGUI() {
		frame = new JFrame("User Registration - AMS ");
		frame.setUndecorated(true);

		mSubmit = new JButton("Submit");
		mSubmit.setForeground(new Color(255, 255, 255));
		mSubmit.setBorder(new LineBorder(new Color(0, 250, 154), 1, true));
		mSubmit.setBackground(new Color(60, 179, 113));

		mCancel = new JButton("Cancel");
		mCancel.setForeground(new Color(255, 255, 255));
		mCancel.setBorder(new LineBorder(new Color(255, 153, 0), 1, true));
		mCancel.setBackground(new Color(255, 51, 51));

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
		editUsername.setForeground(Color.WHITE);
		editUsername.setBackground(Color.GRAY);
		editUsername.setBorder(new EmptyBorder(1, 1, 1, 1));

		editPassword = new JPasswordField();
		editPassword.setForeground(Color.WHITE);
		editPassword.setBackground(Color.GRAY);
		editPassword.setBorder(new EmptyBorder(1, 1, 1, 1));

		editEmail = new JTextField();
		editEmail.setForeground(Color.WHITE);
		editEmail.setBackground(Color.GRAY);
		editEmail.setBorder(new EmptyBorder(1, 1, 1, 1));

		editFullName = new JTextField();
		editFullName.setForeground(Color.WHITE);
		editFullName.setBackground(Color.GRAY);
		editFullName.setBorder(new EmptyBorder(1, 1, 1, 1));

		editAge = new JTextField();
		editAge.setForeground(Color.WHITE);
		editAge.setBackground(Color.GRAY);
		editAge.setBorder(new EmptyBorder(1, 1, 1, 1));

		editAdress = new JTextField();
		editAdress.setForeground(Color.WHITE);
		editAdress.setBackground(Color.GRAY);
		editAdress.setBorder(new EmptyBorder(1, 1, 1, 1));

		editContactNo = new JTextField();
		editContactNo.setForeground(Color.WHITE);
		editContactNo.setBackground(Color.GRAY);
		editContactNo.setBorder(new EmptyBorder(1, 1, 1, 1));

		genderGroup = new ButtonGroup();

		radioMale = new JRadioButton("Male");
		radioMale.setForeground(Color.WHITE);
		radioMale.setBackground(Color.GRAY);
		radioMale.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
		radioMale.setSelected(true);

		radioFMale = new JRadioButton("Female");
		radioFMale.setForeground(Color.WHITE);
		radioFMale.setBackground(Color.GRAY);
		radioFMale.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));

		radioOther = new JRadioButton("Other");
		radioOther.setForeground(Color.WHITE);
		radioOther.setBackground(Color.GRAY);
		radioOther.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));

		utypeGroup = new ButtonGroup();

		radioUser = new JRadioButton("User");
		radioUser.setVerticalAlignment(SwingConstants.TOP);
		radioUser.setForeground(Color.WHITE);
		radioUser.setToolTipText("You can only be a user!");
		radioUser.setSelected(true);
		radioUser.setBackground(Color.GRAY);
		radioUser.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));

		list = new ArrayList<JTextField>();


		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			minDate = new SimpleDateFormat("dd-MM-yyyy").parse("08-07-2000");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		textUsername.setLocation(20, 51);
		textUsername.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		textUsername.setSize(100, 30);

		editUsername.setLocation(120, 51);
		editUsername.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		editUsername.setSize(180, 30);

		textPassword.setLocation(20, 93);
		textPassword.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		textPassword.setSize(100, 30);

		editPassword.setLocation(120, 93);
		editPassword.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		editPassword.setSize(180, 30);

		textEmail.setLocation(20, 135);
		textEmail.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		textEmail.setSize(100, 30);

		editEmail.setLocation(120, 135);
		editEmail.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		editEmail.setSize(180, 30);

		textDob.setLocation(20, 177);
		textDob.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		textDob.setSize(130, 30);

		editDob = new JXDatePicker();
		editDob.getEditor().setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		editDob.getEditor().setForeground(Color.WHITE);
		editDob.setFormats("dd-MM-yyyy");
		editDob.setDate(minDate);
		editDob.setLocation(150, 177);
		editDob.setSize(150, 30);
		editDob.getMonthView().setVisible(true);
		editDob.getMonthView().setZoomable(true);
		editDob.getEditor().setBackground(Color.gray);
	

		textFullName.setLocation(20, 219);
		textFullName.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		textFullName.setSize(100, 30);

		editFullName.setLocation(120, 219);
		editFullName.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		editFullName.setSize(180, 30);

		textAge.setLocation(20, 261);
		textAge.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		textAge.setSize(100, 30);

		editAge.setLocation(120, 261);
		editAge.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		editAge.setSize(180, 30);

		textAddress.setLocation(20, 303);
		textAddress.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		textAddress.setSize(100, 30);

		editAdress.setLocation(120, 303);
		editAdress.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 16));
		editAdress.setSize(180, 30);

		textContactNo.setLocation(20, 345);
		textContactNo.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		textContactNo.setSize(120, 30);

		editContactNo.setLocation(150, 345);
		editContactNo.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		editContactNo.setSize(150, 30);

		textGender.setLocation(20, 387);
		textGender.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		textGender.setSize(100, 30);

		radioMale.setLocation(120, 387);
		radioMale.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		radioMale.setSize(180, 30);

		radioFMale.setLocation(120, 415);
		radioFMale.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		radioFMale.setSize(180, 30);

		radioOther.setLocation(120, 444);
		radioOther.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		radioOther.setSize(180, 30);

		genderGroup.add(radioMale);
		genderGroup.add(radioFMale);
		genderGroup.add(radioOther);

		textUType.setLocation(20, 482);
		textUType.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		textUType.setSize(100, 30);

		radioUser.setLocation(120, 486);
		radioUser.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		radioUser.setSize(180, 30);
		utypeGroup.add(radioUser);

		mSubmit.setLocation(170, 558);
		mSubmit.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		mSubmit.setSize(130, 30);

		mCancel.setLocation(20, 558);
		mCancel.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
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
		frame.setSize(322, 600);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getRootPane().setDefaultButton(mSubmit);
		panel.setBackground(new Color(50, 205, 50));
		panel.setBorder(new EmptyBorder(1, 1, 1, 1));
		panel.setBounds(0, 0, 322, 39);
		
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		lblTitle.setBounds(12, 0, 264, 39);
		
		panel.add(lblTitle);
		btnClose.setFont(new Font("Dialog", Font.BOLD, 16));
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setBorder(new EmptyBorder(1, 1, 1, 1));
		btnClose.setBackground(new Color(50, 205, 50));
		btnClose.setBounds(278, 0, 44, 39);
		
		panel.add(btnClose);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		show();
	}

	private void show() {
		btnClose.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnClose.setBackground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnClose.setBackground(new Color(50, 205, 50));
			}
			
		});
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
					userData.setPassword(EncryptString.getEncryptString(String.valueOf(editPassword.getPassword())));
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
					VerifingOTP verifingOTP = new VerifingOTP(userData,genratedOTP);
					new SendMail("Sending OTP...", frame, verifingOTP).send(userData.getEmail(), "One Step Verification - AMS", "Hello "
							+ userData.getFullName() + ",\nYour OTP : " + genratedOTP
							+ "\nIt will be expire in 2 minutes. Please do verify before 2 minutes otherwise you will be terminated!");

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
