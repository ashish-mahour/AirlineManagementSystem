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
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;

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
			bufferedImage = ImageIO.read(MainActivity.class.getResource("/images/airlineLogo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		image = new JLabel(new ImageIcon(bufferedImage));
		image.setBorder(new LineBorder(new Color(51, 153, 255), 2, true));
		image.setLocation(12, 12);
		image.setSize(328, 216);

		mlabelUsername = new JLabel("Username");
		mlabelUsername.setForeground(new Color(204, 255, 204));
		mLabelPassword = new JLabel("Password");
		mLabelPassword.setForeground(new Color(204, 255, 204));
		username = new JTextField();
		username.setToolTipText("Enter your username");
		password = new JPasswordField();
		password.setToolTipText("Enter your password");
		submit = new JButton("Submit");
		submit.setForeground(new Color(0, 0, 0));
		submit.setBorder(new LineBorder(new Color(204, 255, 255), 2, true));
		submit.setBackground(new Color(0, 255, 127));
		username.setBorder(new LineBorder(new Color(204, 255, 255), 2, true));
		username.setBackground(new Color(153, 255, 255));
		password.setBorder(new LineBorder(new Color(204, 255, 255), 2, true));
		password.setBackground(new Color(153, 255, 255));
		cancel = new JButton("Cancel");
		cancel.setForeground(new Color(0, 0, 0));
		cancel.setBorder(new LineBorder(new Color(204, 255, 255), 2, true));
		cancel.setBackground(new Color(0, 255, 127));
		mRegLabel = new JLabel("New User ? Create new account ");
		mRegLabel.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(175, 238, 238)));
		mRegLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		mRegLabel.setOpaque(true);
		mRegLabel.setBackground(new Color(0, 206, 209));
		mRegLabel.setForeground(new Color(0, 0, 0));
		
		

		mlabelUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		mlabelUsername.setLocation(12, 233);
		mlabelUsername.setSize(119, 30);

		username.setLocation(12, 265);
		username.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		username.setSize(330, 30);

		mLabelPassword.setLocation(12, 295);
		mLabelPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		mLabelPassword.setSize(119, 30);

		password.setLocation(12, 325);
		password.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		password.setSize(330, 30);

		submit.setLocation(12, 367);
		submit.setFont(new Font("SimSun", Font.PLAIN, 20));
		submit.setSize(144, 30);

		cancel.setLocation(190, 367);
		cancel.setFont(new Font("SimSun", Font.PLAIN, 20));
		cancel.setSize(150, 30);

		mRegLabel.setLocation(0, 409);
		mRegLabel.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		mRegLabel.setSize(352, 30);

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
				mRegLabel.setForeground(new Color(0, 0, 0));

			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mRegLabel.setForeground(Color.WHITE);

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
					if (userData.getUserName().equalsIgnoreCase(username.getText()) && userData.getPassword().equalsIgnoreCase(String.valueOf(password.getPassword())) && userData.getUserType().equalsIgnoreCase("admin")) {
						new AdminPanelActivity(userData).show();
						jFrame.dispose();
						isLoggedin = true;
						break;
					} else if (userData.getUserName().equalsIgnoreCase(username.getText()) && userData.getPassword().equalsIgnoreCase(String.valueOf(password.getPassword())) && userData.getUserType().equalsIgnoreCase("user")) {
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
		jFrame.setType(Type.POPUP);
		jFrame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		jFrame.setResizable(false);
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
		jFrame.setSize(368, 478);
		jFrame.setVisible(true);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MainActivity().show();
	}
}