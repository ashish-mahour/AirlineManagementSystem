package com.ams.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import com.ams.entities.UserData;

public class AdminPanelActivity {
	JFrame frame;
	
	BufferedImage iconImage;
	File imageFile;
	
	JLabel icon, username, usertype;
	
	JPopupMenu detailsMenu;
	JMenuItem editDetails,viewDetails;
	
	JPanel container;
	
	JButton detailsButton;
	
	UserData userData;
	
	JLabel textUsername, textPassword, textEmail, textFullName, textAge, textDob, textAddress, textContactNo,
	textGender, textUType;
	
	public AdminPanelActivity(UserData userData) {
		// TODO Auto-generated constructor stub
		this.userData = userData;
		frame = new JFrame("Admin Panel - AMS");
		
		try {
			imageFile = new File("E:\\Wallpapers and Icons\\backgrounds_2.jpg");
			iconImage = ImageIO.read(imageFile);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		icon = new JLabel(new ImageIcon(iconImage));
		icon.setSize(100,100);
		icon.setLocation(10,20);
		
		username = new JLabel(userData.getFullName());
		usertype = new JLabel(userData.getUserType());
		
		
		detailsMenu = new JPopupMenu();
		
		editDetails = new JMenuItem("Edit Details");
		viewDetails = new JMenuItem("View Details");
		
		detailsButton = new JButton("Details");
		
		detailsMenu.add(editDetails);
		detailsMenu.add(viewDetails);
		
		username.setLocation(10, 130);
		username.setSize(200, 20);
		username.setToolTipText(userData.getFullName());
		username.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		usertype.setLocation(10, 150);
		usertype.setSize(100, 20);
		usertype.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		
		detailsButton.setLocation(10, 170);
		detailsButton.setSize(100, 40);
		detailsButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		container = new JPanel();
		container.setLayout(new GridLayout(11, 2));
		container.setBackground(Color.GRAY);
		container.setLocation(150, 20);
		container.setSize(400,500);
		
		frame.add(icon);
		frame.add(username);
		frame.add(usertype);
		frame.add(detailsButton);
		frame.add(container);
		
		frame.setLayout(null);
		frame.setSize(600, 600);
		frame.getContentPane().setBackground(Color.decode("#99c2ff"));
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public void show() {
		detailsButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				detailsMenu.show(frame, 20, 240);
			}	
		});
		viewDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
	}
	

}
