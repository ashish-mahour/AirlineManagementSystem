package com.ams.main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainActivity {
	
	public void show() {
		final JFrame jFrame = new JFrame("Swings Application");
		BufferedImage bufferedImage = null;
		JLabel image;
		JLabel mlabelUsername, mLabelPassword;
		final JLabel mRegLabel;
		final JTextField username;
		final JTextField password;
		JButton submit,cancel;
		try {
			bufferedImage = ImageIO.read(new File("E:\\Wallpapers and Icons\\backgrounds_2.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		image = new JLabel(new ImageIcon(bufferedImage));
		image.setLocation(10,10);
		image.setSize(300,200);
		
		mlabelUsername = new JLabel("Username");
		mLabelPassword = new JLabel("Password");
		username = new JTextField();
		password = new JTextField();
		submit = new JButton("Submit");
		cancel = new JButton("Cancel");
		mRegLabel = new JLabel("New User ? Create new account ");
		
		
		mlabelUsername.setFont(new Font("Times New Roman", Font.BOLD, 20));
		mlabelUsername.setLocation(10, 220);
		mlabelUsername.setSize(300,30);
		
		username.setLocation(10, 250);
		username.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		username.setSize(300, 30);
		
		mLabelPassword.setLocation(10, 290);
		mLabelPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		mLabelPassword.setSize(300, 30);
		
		password.setLocation(10, 320);
		password.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		password.setSize(300, 30);
		
		submit.setLocation(10, 380);
		submit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		submit.setSize(100, 30);
		
		cancel.setLocation(200, 380);
		cancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cancel.setSize(110, 30);
		
		mRegLabel.setLocation(80, 450);
		mRegLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mRegLabel.setSize(300, 30);
		
		mRegLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		mRegLabel.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				 mRegLabel.setForeground(Color.BLACK);
				
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
				if(username.getText().equalsIgnoreCase("admin") 
						&& password.getText().equalsIgnoreCase("admin")) {
					new LoginActivity().show();
					jFrame.dispose();
				}
				
			}
		});
		
		jFrame.add(mlabelUsername);
		jFrame.add(username);
		jFrame.add(mLabelPassword);
		jFrame.add(password);
		jFrame.add(submit);
		jFrame.add(cancel);
		jFrame.add(mRegLabel);
		jFrame.add(image);
		jFrame.setLayout(null);
		jFrame.setSize(340, 600);
		jFrame.setVisible(true);
		jFrame.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new MainActivity().show();
	}
}
