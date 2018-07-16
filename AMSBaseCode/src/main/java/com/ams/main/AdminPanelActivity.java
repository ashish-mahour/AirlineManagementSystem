package com.ams.main;

import java.awt.CardLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import com.ams.dao.impl.UserDAOImplements;
import com.ams.entities.UserData;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

public class AdminPanelActivity {

	JFrame frame;

	BufferedImage iconImage;
	File imageFile;

	JLabel icon, username, usertype;

	JPopupMenu detailsMenu;
	JMenuItem editDetails, viewDetails, deleteAcc;

	JPanel container;

	JButton detailsButton;

	UserData userData;

	JLabel textUsername, textPassword, textEmail, textFullName, textAge, textDob, textAddress, textContactNo,
			textGender, textUType;

	ViewDetails viewDetailsActivity;

	EditDetails editDetailsActivity;

	UserDAOImplements userDAOImplements;
	private JButton btnExit;
	private JButton btnManageFlights;
	private JButton btnManageLoactions;

	public AdminPanelActivity(UserData userData) {
		// TODO Auto-generated constructor stub
		this.userData = userData;
		frame = new JFrame("Admin Panel - AMS");

		try {
			imageFile = new File("src\\main\\java\\images\\m.png");
			iconImage = ImageIO.read(imageFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		icon = new JLabel(new ImageIcon(iconImage));
		icon.setSize(100, 100);
		icon.setLocation(10, 20);

		username = new JLabel(userData.getFullName());
		usertype = new JLabel(userData.getUserType());

		detailsMenu = new JPopupMenu();

		editDetails = new JMenuItem("Edit Details");
		viewDetails = new JMenuItem("View Details");
		deleteAcc = new JMenuItem("Delete Account");

		detailsButton = new JButton("Details");
		detailsButton.setVerticalAlignment(SwingConstants.TOP);
		detailsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		detailsMenu.add(editDetails);
		detailsMenu.add(viewDetails);
		detailsMenu.add(deleteAcc);

		username.setLocation(10, 130);
		username.setSize(200, 20);
		username.setToolTipText(userData.getFullName());
		username.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		usertype.setLocation(10, 150);
		usertype.setSize(100, 20);
		usertype.setFont(new Font("Times New Roman", Font.PLAIN, 10));

		detailsButton.setLocation(10, 183);
		detailsButton.setSize(87, 31);
		detailsButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		container = new JPanel();
		container.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 204, 51), new Color(0, 204, 102)));
		container.setLayout(new CardLayout());
		container.setBackground(new Color(102, 204, 153));
		container.setLocation(136, 20);
		container.setSize(427, 518);

		viewDetailsActivity = new ViewDetails(userData);
		editDetailsActivity = new EditDetails(userData);
		userDAOImplements = new UserDAOImplements();

		frame.getContentPane().add(icon);
		frame.getContentPane().add(username);
		frame.getContentPane().add(usertype);
		frame.getContentPane().add(detailsButton);
		frame.getContentPane().add(container);

		frame.getContentPane().setLayout(null);
		frame.setSize(600, 600);
		frame.getContentPane().setBackground(new Color(102, 204, 153));
		
		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnExit.setBounds(10, 309, 68, 31);
		frame.getContentPane().add(btnExit);
		
		btnManageFlights = new JButton("Flights");
		btnManageFlights.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnManageFlights.setBounds(10, 225, 100, 31);
		frame.getContentPane().add(btnManageFlights);
		
		btnManageLoactions = new JButton("Loactions");
		btnManageLoactions.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnManageLoactions.setBounds(10, 267, 116, 31);
		
		frame.getContentPane().add(btnManageLoactions);
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
				container.removeAll();
				container.repaint();
				container.revalidate();
				container.add(viewDetailsActivity);
				container.repaint();
				container.revalidate();

			}
		});
		editDetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				container.removeAll();
				container.repaint();
				container.revalidate();
				container.add(editDetailsActivity);
				container.repaint();
				container.revalidate();

			}
		});
		deleteAcc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int dialogAction = JOptionPane.showConfirmDialog(frame, "Are you sure for deleting your account ?",
						"Delete Account", JOptionPane.INFORMATION_MESSAGE);
				if (dialogAction == JOptionPane.YES_OPTION) {
					userDAOImplements.deleteUser(userData.getUserName());
					frame.dispose();
					new MainActivity().show();
				}

			}
		});
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
				new MainActivity().show();
				
			}
		});
	}

}
