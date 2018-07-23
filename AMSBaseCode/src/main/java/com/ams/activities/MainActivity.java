package com.ams.activities;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
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

import com.ams.dao.impl.UserDAOImplements;
import com.ams.entities.UserData;
import javax.swing.border.LineBorder;

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

	public MainActivity() {
		// TODO Auto-generated constructor stub
		try {
			bufferedImage = ImageIO.read(new File("src\\main\\java\\images\\airlineLogo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		image = new JLabel(new ImageIcon(bufferedImage));
		image.setBorder(new LineBorder(new Color(51, 153, 255), 2, true));
		image.setLocation(10, 10);
		image.setSize(300, 200);

		mlabelUsername = new JLabel("Username");
		mlabelUsername.setForeground(new Color(204, 255, 204));
		mLabelPassword = new JLabel("Password");
		mLabelPassword.setForeground(new Color(204, 255, 204));
		username = new JTextField();
		username.setToolTipText("Enter your username");
		password = new JPasswordField();
		password.setToolTipText("Enter your password");
		submit = new JButton("Submit");
		submit.setBorder(new LineBorder(new Color(204, 255, 255), 2, true));
		submit.setBackground(new Color(102, 255, 102));
		username.setBorder(new LineBorder(new Color(204, 255, 255), 2, true));
		username.setBackground(new Color(153, 255, 255));
		password.setBorder(new LineBorder(new Color(204, 255, 255), 2, true));
		password.setBackground(new Color(153, 255, 255));
		cancel = new JButton("Cancel");
		cancel.setBorder(new LineBorder(new Color(204, 255, 255), 2, true));
		cancel.setBackground(new Color(102, 255, 102));
		mRegLabel = new JLabel("New User ? Create new account ");
		mRegLabel.setForeground(new Color(255, 255, 255));
		
		

		mlabelUsername.setFont(new Font("Segoe Print", Font.BOLD, 20));
		mlabelUsername.setLocation(10, 220);
		mlabelUsername.setSize(119, 30);

		username.setLocation(10, 250);
		username.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		username.setSize(300, 30);

		mLabelPassword.setLocation(10, 290);
		mLabelPassword.setFont(new Font("Segoe Print", Font.BOLD, 20));
		mLabelPassword.setSize(300, 30);

		password.setLocation(10, 320);
		password.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		password.setSize(300, 30);

		submit.setLocation(10, 380);
		submit.setFont(new Font("Monospaced", Font.PLAIN, 20));
		submit.setSize(119, 30);

		cancel.setLocation(200, 380);
		cancel.setFont(new Font("Monospaced", Font.PLAIN, 20));
		cancel.setSize(110, 30);

		mRegLabel.setLocation(80, 450);
		mRegLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mRegLabel.setSize(300, 30);

		mRegLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		userDatas = new ArrayList<UserData>();

		userDAOImplements = new UserDAOImplements();
		userDatas = userDAOImplements.getAll();
	}

	public void show() {
		mRegLabel.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mRegLabel.setForeground(new Color(255, 255, 255));

			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mRegLabel.setForeground(Color.GREEN);

			}

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				new RegisterActivity().show();
				jFrame.dispose();

			}
		});

		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				for (UserData userData : userDatas) {
					if (userData.getUserName().equalsIgnoreCase(username.getText()) && userData.getPassword().equalsIgnoreCase(password.getPassword().toString()) && userData.getUserType().equalsIgnoreCase("admin")) {
						new AdminPanelActivity(userData).show();
						jFrame.dispose();
						isLoggedin = true;
						break;
					} else if (userData.getUserName().equalsIgnoreCase(username.getText()) && userData.getPassword().equalsIgnoreCase(password.getPassword().toString()) && userData.getUserType().equalsIgnoreCase("user")) {
						new UserPanelActivity(userData).show();
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
		jFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainActivity.class.getResource("/images/planeIcon.png")));
		jFrame.setBackground(new Color(0, 100, 0));
		jFrame.getRootPane().setDefaultButton(submit);
		jFrame.getContentPane().setBackground(new Color(32, 178, 170));
		jFrame.getContentPane().add(mlabelUsername);
		jFrame.getContentPane().add(username);
		jFrame.getContentPane().add(mLabelPassword);
		jFrame.getContentPane().add(password);
		jFrame.getContentPane().add(submit);
		jFrame.getContentPane().add(cancel);
		jFrame.getContentPane().add(mRegLabel);
		jFrame.getContentPane().add(image);
		jFrame.getContentPane().setLayout(null);
		jFrame.setSize(340, 600);
		jFrame.setVisible(true);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MainActivity().show();
	}
}