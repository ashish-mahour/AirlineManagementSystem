package com.ams.activities;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.ams.customdialogs.WaitingDialog;
import com.ams.dao.impl.UserDAOImplements;
import com.ams.entities.UserData;
import com.ams.model.EncryptString;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;

public class MainActivity {

	final JFrame jFrame = new JFrame("Airline Management System - Home");

	BufferedImage bufferedImage = null;

	JLabel image;
	JLabel mlabelUsername, mLabelPassword;
	final JLabel mRegLabel;
	final JTextField username;
	final JPasswordField password;
	JButton submit, cancel;

	ArrayList<UserData> userDatas;
	UserDAOImplements userDAOImplements;
	boolean isLoggedin = false;
	private final JPanel panel = new JPanel();
	private final JLabel lblTitle = new JLabel("Airline Management System - LOGIN");
	private final JButton btnClose = new JButton("X");
	private static WaitingDialog frame = new WaitingDialog("Processing..");

	public MainActivity() {
		// TODO Auto-generated constructor stub
		frame.setVisible(true);
		jFrame.setUndecorated(true);
		Image img = null;
		try {
			bufferedImage = ImageIO.read(MainActivity.class.getResource("/images/loginimage.png"));
			img = bufferedImage.getScaledInstance(344, 242, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		image = new JLabel(new ImageIcon(img));
		image.setBorder(new EmptyBorder(1, 1, 1, 1));
		image.setLocation(12, 67);
		image.setSize(344, 244);

		mlabelUsername = new JLabel("Username");
		mlabelUsername.setForeground(new Color(255, 255, 255));
		mLabelPassword = new JLabel("Password");
		mLabelPassword.setForeground(new Color(255, 255, 255));
		username = new JTextField();
		username.setForeground(new Color(255, 255, 255));
		username.setToolTipText("Enter your username");
		password = new JPasswordField();
		password.setForeground(new Color(255, 255, 255));
		password.setToolTipText("Enter your password");
		submit = new JButton("Submit");
		submit.setForeground(new Color(255, 255, 255));
		submit.setBorder(new LineBorder(new Color(50, 205, 50), 1, true));
		submit.setBackground(new Color(34, 139, 34));
		username.setBorder(new EmptyBorder(1, 1, 1, 1));
		username.setBackground(new Color(169, 169, 169));
		password.setBorder(new EmptyBorder(1, 1, 1, 1));
		password.setBackground(new Color(169, 169, 169));
		cancel = new JButton("Cancel");
		cancel.setForeground(new Color(255, 255, 255));
		cancel.setBorder(new LineBorder(new Color(255, 160, 122), 1, true));
		cancel.setBackground(new Color(255, 0, 51));
		mRegLabel = new JLabel("New User ? Create new account ");
		mRegLabel.setBorder(new EmptyBorder(2, 2, 2, 2));
		mRegLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		mRegLabel.setOpaque(true);
		mRegLabel.setBackground(new Color(128, 128, 128));
		mRegLabel.setForeground(new Color(245, 245, 245));
		
		

		mlabelUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		mlabelUsername.setLocation(12, 310);
		mlabelUsername.setSize(119, 30);

		username.setLocation(12, 341);
		username.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		username.setSize(344, 30);

		mLabelPassword.setLocation(12, 383);
		mLabelPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		mLabelPassword.setSize(119, 30);

		password.setLocation(12, 415);
		password.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		password.setSize(344, 30);

		submit.setLocation(185, 470);
		submit.setFont(new Font("SimSun", Font.PLAIN, 20));
		submit.setSize(171, 30);

		cancel.setLocation(12, 470);
		cancel.setFont(new Font("SimSun", Font.PLAIN, 20));
		cancel.setSize(161, 30);

		mRegLabel.setLocation(0, 512);
		mRegLabel.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		mRegLabel.setSize(368, 30);

		mRegLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		userDatas = new ArrayList<UserData>();

		userDAOImplements = new UserDAOImplements();
		userDatas = userDAOImplements.getAll();
		
		panel.setBackground(new Color(50, 205, 50));
		panel.setBorder(new EmptyBorder(1, 1, 1, 1));
		panel.setBounds(0, 0, 368, 39);
		panel.setLayout(null);
		
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 16));
		lblTitle.setBounds(12, 0, 294, 39);
		
		panel.add(lblTitle);
		btnClose.setFont(new Font("Dialog", Font.BOLD, 16));
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setBorder(new EmptyBorder(1, 1, 1, 1));
		btnClose.setBackground(new Color(50, 205, 50));
		btnClose.setBounds(324, 0, 44, 39);
		
		panel.add(btnClose);
	}

	public void show() {
		mRegLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mRegLabel.setForeground(Color.WHITE);

			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mRegLabel.setForeground(new Color(0, 0, 0));

			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				new RegisterActivity();
				jFrame.dispose();

			}
		});
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userEnteredPass = EncryptString.getEncryptString(String.valueOf(password.getPassword()));
				for (UserData userData : userDatas) {
					if (userData.getUserName().equalsIgnoreCase(username.getText()) 
							&& userData.getPassword().equalsIgnoreCase(userEnteredPass)
							&& userData.getUserType().equalsIgnoreCase("admin")) {
						new AdminPanelActivity(userData);
						jFrame.dispose();
						isLoggedin = true;
						break;
					} else if (userData.getUserName()
							.equalsIgnoreCase(username.getText()) 
							&& userData.getPassword().equalsIgnoreCase(userEnteredPass) 
							&& userData.getUserType().equalsIgnoreCase("user")) {
						new UserPanelActivity(userData);
						jFrame.dispose();
						isLoggedin = true;
						break;
					} else {
						isLoggedin = false;
						
					}
				}
				if(!isLoggedin) {
					JOptionPane.showMessageDialog(jFrame, "Wrong login cresidendials!!", "Alert",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
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
		jFrame.setType(Type.POPUP);
		jFrame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		jFrame.setResizable(false);
		jFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainActivity.class.getResource("/images/planeIcon.png")));
		jFrame.setBackground(new Color(0, 100, 0));
		jFrame.getRootPane().setDefaultButton(submit);
		jFrame.getContentPane().setBackground(new Color(105, 105, 105));
		jFrame.getContentPane().add(panel);
		jFrame.getContentPane().add(mlabelUsername);
		jFrame.getContentPane().add(username);
		jFrame.getContentPane().add(mLabelPassword);
		jFrame.getContentPane().add(password);
		jFrame.getContentPane().add(submit);
		jFrame.getContentPane().add(cancel);
		jFrame.getContentPane().add(mRegLabel);
		jFrame.getContentPane().add(image);
		jFrame.getContentPane().setLayout(null);
		jFrame.setSize(368, 542);
		jFrame.setVisible(true);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.dispose();
	}

	public static void main(String[] args) {
		new MainActivity().show();
		
	}
}