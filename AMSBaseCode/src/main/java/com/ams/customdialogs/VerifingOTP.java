package com.ams.customdialogs;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ams.activities.MainActivity;
import com.ams.dao.impl.UserDAOImplements;
import com.ams.entities.UserData;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.Toolkit;

public class VerifingOTP extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblEnterOtp = new JLabel("One time password (OTP)");
	private final JPasswordField otpField = new JPasswordField();
	private final JProgressBar progressBar = new JProgressBar();
	private final JButton btnSubmit = new JButton("Submit");
	private SimpleDateFormat format = new SimpleDateFormat("mm:ss");
	private int totalTime = 120;
	private Date timeInMMSS ;
	private UserData userData;
	private UserDAOImplements userDAOImplements = new UserDAOImplements();
	private String genratedOTP = null; 
	/**
	 * Create the frame.
	 * @param userData 
	 * @param genratedOTP 
	 */
	public VerifingOTP(UserData userData, String genratedOTP) {
		this.userData = userData;
		this.genratedOTP = genratedOTP;
		initGUI();
	}
	private void initGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerifingOTP.class.getResource("/images/planeIcon.png")));
		setType(Type.POPUP);
		setTitle("Account Activation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 277, 208);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblEnterOtp.setForeground(new Color(0, 0, 0));
		lblEnterOtp.setBackground(new Color(211, 211, 211));
		lblEnterOtp.setBorder(new EmptyBorder(1, 1, 1, 1));
		lblEnterOtp.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterOtp.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		lblEnterOtp.setOpaque(true);
		lblEnterOtp.setBounds(10, 11, 239, 35);
		
		contentPane.add(lblEnterOtp);
		otpField.setHorizontalAlignment(SwingConstants.CENTER);
		otpField.setBorder(new EmptyBorder(1, 1, 1, 1));
		otpField.setBackground(new Color(192, 192, 192));
		otpField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		otpField.setBounds(10, 48, 239, 35);
		
		contentPane.add(otpField);
		progressBar.setStringPainted(true);
		progressBar.setForeground(new Color(220, 20, 60));
		progressBar.setBounds(10, 142, 239, 21);
		progressBar.setValue(0);
		progressBar.setMaximum(totalTime);
		
		contentPane.add(progressBar);
		btnSubmit.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSubmit.setBorder(new EmptyBorder(1, 1, 1, 1));
		btnSubmit.setForeground(new Color(240, 248, 255));
		btnSubmit.setBackground(new Color(0, 206, 209));
		btnSubmit.setBounds(62, 95, 139, 35);
		
		contentPane.add(btnSubmit);
		setLocationRelativeTo(null);
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String userEnteredOTP = String.valueOf(otpField.getPassword());
				if (userEnteredOTP == null) {
					JOptionPane.showMessageDialog(VerifingOTP.this, "User not Registered!", "Success",
							JOptionPane.ERROR_MESSAGE);
					dispose();
					new MainActivity().show();
				} else if (userEnteredOTP.trim().equalsIgnoreCase(genratedOTP)) {
					userData.setUserStatus(true);
					userDAOImplements.saveUser(userData);
					JOptionPane.showMessageDialog(VerifingOTP.this, "User Registered!", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					dispose();
					new MainActivity().show();
				}
				
			}
		});
	}
	public void doProgress() {
		for(int i = 1;i <= progressBar.getMaximum();i++ ) {
			try { 
				try {
					timeInMMSS = format.parse("00:"+String.valueOf(totalTime));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				progressBar.setString(format.format(timeInMMSS)+" left..");
				Thread.sleep(1000);
				progressBar.setValue(i);
				progressBar.repaint();
				progressBar.revalidate();
				totalTime--;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
