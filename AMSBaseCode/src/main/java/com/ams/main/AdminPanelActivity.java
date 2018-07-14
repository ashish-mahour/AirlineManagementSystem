package com.ams.main;

import java.awt.Color;
import java.awt.Font;
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

public class AdminPanelActivity {
	JFrame frame;
	BufferedImage iconImage;
	File imageFile;
	JLabel icon;
	JPopupMenu menu;
	JMenuItem menuItem1,menuItem2,menuItem3;
	JPanel container;
	JButton menuButton;
	public AdminPanelActivity() {
		// TODO Auto-generated constructor stub
		frame = new JFrame("Logged In");
		
		try {
			imageFile = new File("E:\\Wallpapers and Icons\\backgrounds_2.jpg");
			iconImage = ImageIO.read(imageFile);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		icon = new JLabel(new ImageIcon(iconImage));
		icon.setSize(100,100);
		icon.setLocation(10,20);
		
		menu = new JPopupMenu("Menu");
		
		menuItem1 = new JMenuItem("Home");
		menuItem2 = new JMenuItem("Timeline");
		menuItem3 = new JMenuItem("Exit");
		
		menuButton = new JButton("Menu ");
		
		menu.add(menuItem1);
		menu.add(menuItem2);
		menu.add(menuItem3);
		
		menuButton.setLocation(10, 150);
		menuButton.setSize(100, 20);
		menuButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		container = new JPanel();
		container.setLayout(null);
		container.setBackground(Color.GRAY);
		container.setLocation(120, 20);
		container.setSize(300,500);
		
		frame.add(menuButton);
		frame.add(icon);
		frame.add(container);
		
		frame.setLayout(null);
		frame.setSize(450, 600);
		frame.getContentPane().setBackground(Color.decode("#99c2ff"));
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public void show() {
		menuButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				menu.show(frame, 20, 200);
			}
			
			
		});
		menuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new MainActivity().show();
				frame.dispose();
				
			}
		});
	}

}
