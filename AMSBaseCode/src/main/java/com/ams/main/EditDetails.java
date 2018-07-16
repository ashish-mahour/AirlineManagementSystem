package com.ams.main;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXDatePicker;

import com.ams.entities.UserData;

import java.awt.Font;
import java.sql.Date;

import javax.swing.JButton;

public class EditDetails extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6384119036923666743L;
	private UserData userData;
	private final JPanel panel = new JPanel();
	private final JLabel label = new JLabel("ID");
	private final JTextField textID = new JTextField("userID");
	private final JLabel label_2 = new JLabel("Username");
	private final JTextField textUsername = new JTextField("textUsername");
	private final JLabel label_4 = new JLabel("Password");
	private final JTextField textPassword = new JTextField("textPassword");
	private final JLabel label_6 = new JLabel("Email");
	private final JTextField textEmail = new JTextField("textEmail");
	private final JLabel lblFullName = new JLabel("Full Name");
	private final JTextField lblTextfullname = new JTextField("textFullName");
	private final JLabel lblAge = new JLabel("Age");
	private final JTextField lblTextage = new JTextField("textAge");
	private final JLabel lblAddress = new JLabel("Address");
	private final JTextField lblTextaddress = new JTextField("textAddress");
	private final JLabel lblContactNo = new JLabel("Contact No.");
	private final JTextField lblTextcontact = new JTextField("textContact");
	private final JLabel lblGender = new JLabel("Gender");
	private final JTextField lblTextgender = new JTextField("textGender");
	private final JLabel lblUserType = new JLabel("User Type");
	private final JTextField lblTextutype = new JTextField("textUType");
	private final JLabel lblDateOfBirth = new JLabel("Date of Birth");
	private final JXDatePicker txtTextdateofbirth = new JXDatePicker();
	private final JButton btnUpdate = new JButton("Update");
	private final JButton btnCancel = new JButton("Cancel");

	/**
	 * Create the panel.
	 * @param userData 
	 */
	public EditDetails(UserData userData) {
		this.userData = userData;
		initGUI();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(10, 11, 402, 465);
		
		add(panel);
		panel.setLayout(null);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(21, 29, 87, 30);
		
		panel.add(label);
		textID.setEnabled(false);
		textID.setEditable(false);
		textID.setForeground(new Color(0, 0, 0));
		textID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textID.setBounds(184, 29, 192, 22);
		
		panel.add(textID);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_2.setBounds(21, 70, 121, 22);
		
		panel.add(label_2);
		textUsername.setForeground(new Color(0, 0, 0));
		textUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textUsername.setBounds(184, 70, 192, 22);
		
		panel.add(textUsername);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_4.setBounds(21, 103, 121, 22);
		
		panel.add(label_4);
		textPassword.setForeground(new Color(0, 0, 0));
		textPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textPassword.setBounds(184, 103, 192, 22);
		
		panel.add(textPassword);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_6.setBounds(21, 136, 121, 22);
		
		panel.add(label_6);
		textEmail.setForeground(new Color(0, 0, 0));
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textEmail.setBounds(184, 136, 192, 22);
		
		panel.add(textEmail);
		lblFullName.setForeground(Color.WHITE);
		lblFullName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFullName.setBounds(21, 169, 121, 22);
		
		panel.add(lblFullName);
		lblTextfullname.setForeground(new Color(0, 0, 0));
		lblTextfullname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTextfullname.setBounds(184, 169, 192, 22);
		
		panel.add(lblTextfullname);
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAge.setBounds(21, 202, 121, 22);
		
		panel.add(lblAge);
		lblTextage.setForeground(new Color(0, 0, 0));
		lblTextage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTextage.setBounds(184, 202, 192, 22);
		
		panel.add(lblTextage);
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddress.setBounds(21, 235, 121, 22);
		
		panel.add(lblAddress);
		lblTextaddress.setForeground(new Color(0, 0, 0));
		lblTextaddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTextaddress.setBounds(184, 235, 192, 22);
		
		panel.add(lblTextaddress);
		lblContactNo.setForeground(Color.WHITE);
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblContactNo.setBounds(21, 268, 121, 22);
		
		panel.add(lblContactNo);
		lblTextcontact.setForeground(new Color(0, 0, 0));
		lblTextcontact.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTextcontact.setBounds(184, 268, 192, 22);
		
		panel.add(lblTextcontact);
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGender.setBounds(21, 301, 121, 22);
		
		panel.add(lblGender);
		lblTextgender.setForeground(new Color(0, 0, 0));
		lblTextgender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTextgender.setBounds(184, 301, 192, 22);
		
		panel.add(lblTextgender);
		lblUserType.setForeground(Color.WHITE);
		lblUserType.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUserType.setBounds(21, 334, 121, 22);
		
		panel.add(lblUserType);
		lblTextutype.setForeground(new Color(0, 0, 0));
		lblTextutype.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTextutype.setBounds(184, 334, 192, 22);
		
		panel.add(lblTextutype);
		lblDateOfBirth.setForeground(Color.WHITE);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDateOfBirth.setBounds(21, 369, 121, 22);
		
		panel.add(lblDateOfBirth);
		txtTextdateofbirth.setForeground(Color.BLACK);
		txtTextdateofbirth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTextdateofbirth.setBounds(184, 373, 192, 22);
		
		panel.add(txtTextdateofbirth);
		btnUpdate.setForeground(new Color(0, 51, 0));
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnUpdate.setBackground(new Color(0, 204, 204));
		btnUpdate.setBounds(21, 421, 143, 33);
		
		panel.add(btnUpdate);
		btnCancel.setForeground(new Color(0, 51, 0));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCancel.setBackground(new Color(0, 204, 204));
		btnCancel.setBounds(218, 421, 158, 33);
		
		panel.add(btnCancel);
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
		txtTextdateofbirth.setDate(Date.valueOf(userData.getDob()));
		
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBackground(new Color(51, 204, 153));
		setLayout(null);
	}
}
