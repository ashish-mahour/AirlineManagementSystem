package com.ams.main;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

import com.ams.entities.UserData;

import java.awt.Font;

public class ViewDetails extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6384119036923666743L;
	private UserData userData;
	private final JPanel panel = new JPanel();
	private final JLabel label = new JLabel("ID");
	private final JLabel textID = new JLabel("userID");
	private final JLabel label_2 = new JLabel("Username");
	private final JLabel textUsername = new JLabel("textUsername");
	private final JLabel label_4 = new JLabel("Password");
	private final JLabel textPassword = new JLabel("textPassword");
	private final JLabel label_6 = new JLabel("Email");
	private final JLabel textEmail = new JLabel("textEmail");
	private final JLabel lblFullName = new JLabel("Full Name");
	private final JLabel lblTextfullname = new JLabel("textFullName");
	private final JLabel lblAge = new JLabel("Age");
	private final JLabel lblTextage = new JLabel("textAge");
	private final JLabel lblAddress = new JLabel("Address");
	private final JLabel lblTextaddress = new JLabel("textAddress");
	private final JLabel lblContactNo = new JLabel("Contact No.");
	private final JLabel lblTextcontact = new JLabel("textContact");
	private final JLabel lblGender = new JLabel("Gender");
	private final JLabel lblTextgender = new JLabel("textGender");
	private final JLabel lblUserType = new JLabel("User Type");
	private final JLabel lblTextutype = new JLabel("textUType");
	private final JLabel lblDateOfBirth = new JLabel("Date of Birth");
	private final JLabel lblTextdateofbirth = new JLabel("textDateOfBirth");

	/**
	 * Create the panel.
	 * @param userData 
	 */
	public ViewDetails(UserData userData) {
		this.userData = userData;
		initGUI();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(10, 11, 386, 430);
		
		add(panel);
		panel.setLayout(null);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(21, 42, 87, 30);
		
		panel.add(label);
		textID.setForeground(Color.WHITE);
		textID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textID.setBounds(185, 46, 179, 22);
		
		panel.add(textID);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_2.setBounds(21, 77, 121, 22);
		
		panel.add(label_2);
		textUsername.setForeground(Color.WHITE);
		textUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textUsername.setBounds(184, 77, 192, 22);
		
		panel.add(textUsername);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_4.setBounds(21, 110, 121, 22);
		
		panel.add(label_4);
		textPassword.setForeground(Color.WHITE);
		textPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textPassword.setBounds(184, 110, 192, 22);
		
		panel.add(textPassword);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_6.setBounds(21, 143, 121, 22);
		
		panel.add(label_6);
		textEmail.setForeground(Color.WHITE);
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textEmail.setBounds(184, 143, 192, 22);
		
		panel.add(textEmail);
		lblFullName.setForeground(Color.WHITE);
		lblFullName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFullName.setBounds(21, 176, 121, 22);
		
		panel.add(lblFullName);
		lblTextfullname.setForeground(Color.WHITE);
		lblTextfullname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTextfullname.setBounds(184, 176, 192, 22);
		
		panel.add(lblTextfullname);
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAge.setBounds(21, 209, 121, 22);
		
		panel.add(lblAge);
		lblTextage.setForeground(Color.WHITE);
		lblTextage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTextage.setBounds(184, 209, 192, 22);
		
		panel.add(lblTextage);
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddress.setBounds(21, 248, 121, 22);
		
		panel.add(lblAddress);
		lblTextaddress.setForeground(Color.WHITE);
		lblTextaddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTextaddress.setBounds(184, 248, 192, 22);
		
		panel.add(lblTextaddress);
		lblContactNo.setForeground(Color.WHITE);
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblContactNo.setBounds(21, 280, 121, 22);
		
		panel.add(lblContactNo);
		lblTextcontact.setForeground(Color.WHITE);
		lblTextcontact.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTextcontact.setBounds(184, 280, 192, 22);
		
		panel.add(lblTextcontact);
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGender.setBounds(21, 313, 121, 22);
		
		panel.add(lblGender);
		lblTextgender.setForeground(Color.WHITE);
		lblTextgender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTextgender.setBounds(184, 313, 192, 22);
		
		panel.add(lblTextgender);
		lblUserType.setForeground(Color.WHITE);
		lblUserType.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUserType.setBounds(21, 351, 121, 22);
		
		panel.add(lblUserType);
		lblTextutype.setForeground(Color.WHITE);
		lblTextutype.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTextutype.setBounds(184, 351, 192, 22);
		
		panel.add(lblTextutype);
		lblDateOfBirth.setForeground(Color.WHITE);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDateOfBirth.setBounds(21, 384, 121, 22);
		
		panel.add(lblDateOfBirth);
		lblTextdateofbirth.setForeground(Color.WHITE);
		lblTextdateofbirth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTextdateofbirth.setBounds(185, 384, 192, 22);
		
		panel.add(lblTextdateofbirth);
	}
	private void initGUI() {
		textID.setText(String.valueOf(userData.getId()));
		textUsername.setText(userData.getUserName());
		textPassword.setText(userData.getPassword());
		textEmail.setText(userData.getEmail());
		lblTextfullname.setText(userData.getFullName());
		lblTextage.setText(String.valueOf(userData.getAge()));
		lblTextaddress.setText(userData.getAddress());
		lblTextcontact.setText(String.valueOf(userData.getContactNo()));
		lblTextgender.setText(userData.getGender());
		lblTextutype.setText(userData.getUserType());
		lblTextdateofbirth.setText(userData.getDob());
		
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBackground(new Color(51, 204, 153));
		setLayout(null);
	}
}
