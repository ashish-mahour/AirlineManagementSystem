package com.ams.activities;

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

import com.ams.dao.impl.LocationDAOImpl;
import com.ams.dao.impl.UserDAOImplements;
import com.ams.entities.LocationData;
import com.ams.entities.UserData;
import com.ams.panels.AddUpdateLocation;
import com.ams.panels.EditDetails;
import com.ams.panels.ViewDetails;

import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

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
	private final JPopupMenu popupMenu = new JPopupMenu();
	private final JMenuItem mntmAddFlights = new JMenuItem("Add Flights");
	private final JMenuItem mntmUpdateDetails = new JMenuItem("Update Details");
	private JMenuItem mntmDeleteFlight;
	private JMenuItem mntmShowAllFlights;
	private static boolean menuShow = false;
	private final JPopupMenu popupMenu_1 = new JPopupMenu();
	private final JMenuItem mntmAddLocation = new JMenuItem("Add Location");
	private final JMenuItem mntmModifyLocation = new JMenuItem("Modify Location");
	private final JMenuItem mntmDeleteLocation = new JMenuItem("Delete Location");
	private JMenuItem mntmViewAll;
	private String locationCode = "";
	private LocationData locationData;
	private LocationDAOImpl locationDAOImpl;

	public AdminPanelActivity(UserData userData) {
		// TODO Auto-generated constructor stub
		this.userData = userData;
		frame = new JFrame("Admin Panel - AMS");
		locationDAOImpl = new LocationDAOImpl();
		frame.setResizable(false);
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(AdminPanelActivity.class.getResource("/images/planeIcon.png")));

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
		username.setForeground(new Color(255, 255, 255));
		username.setBackground(new Color(204, 204, 204));
		usertype = new JLabel(userData.getUserType());
		usertype.setForeground(new Color(255, 255, 255));

		detailsMenu = new JPopupMenu();
		detailsMenu.setBackground(Color.BLUE);

		editDetails = new JMenuItem("Edit Details");
		editDetails.setForeground(Color.WHITE);
		editDetails.setBackground(Color.BLUE);
		viewDetails = new JMenuItem("View Details");
		viewDetails.setForeground(Color.WHITE);
		viewDetails.setBackground(Color.BLUE);
		deleteAcc = new JMenuItem("Delete Account");
		deleteAcc.setBackground(Color.BLUE);
		deleteAcc.setForeground(Color.WHITE);

		detailsButton = new JButton("Details");
		detailsButton.setAlignmentY(0.0f);
		detailsButton.setBackground(new Color(0, 204, 255));
		detailsButton.setBorder(new LineBorder(new Color(204, 255, 255), 1, true));

		detailsMenu.add(editDetails);
		detailsMenu.add(viewDetails);
		detailsMenu.add(deleteAcc);

		username.setLocation(10, 130);
		username.setSize(127, 20);
		username.setToolTipText(userData.getFullName());
		username.setFont(new Font("Segoe Print", Font.BOLD, 14));

		usertype.setLocation(10, 150);
		usertype.setSize(68, 20);
		usertype.setFont(new Font("Segoe Print", Font.PLAIN, 8));

		detailsButton.setLocation(10, 182);
		detailsButton.setSize(87, 32);
		detailsButton.setFont(new Font("Monospaced", Font.PLAIN, 18));

		container = new JPanel();
		container.setAutoscrolls(true);
		container.setBorder(new LineBorder(new Color(102, 102, 102), 3, true));
		container.setLayout(new CardLayout());
		container.setBackground(new Color(204, 204, 204));
		container.setLocation(136, 20);
		container.setSize(431, 494);

		viewDetailsActivity = new ViewDetails(userData);
		editDetailsActivity = new EditDetails(userData);
		userDAOImplements = new UserDAOImplements();

		frame.getContentPane().add(icon);
		frame.getContentPane().add(username);
		frame.getContentPane().add(usertype);
		frame.getContentPane().add(detailsButton);
		frame.getContentPane().add(container);

		frame.getContentPane().setLayout(null);
		frame.setSize(595, 565);
		frame.getContentPane().setBackground(new Color(102, 102, 102));

		btnExit = new JButton("Logout");
		btnExit.setBorder(new LineBorder(new Color(255, 204, 204), 1, true));
		btnExit.setBackground(new Color(255, 153, 153));
		btnExit.setFont(new Font("Monospaced", Font.PLAIN, 18));
		btnExit.setBounds(10, 309, 68, 31);
		frame.getContentPane().add(btnExit);

		btnManageFlights = new JButton("Flights");
		btnManageFlights.setBorder(new LineBorder(new Color(255, 204, 153), 1, true));
		btnManageFlights.setBackground(new Color(255, 160, 122));
		btnManageFlights.setFont(new Font("Monospaced", Font.PLAIN, 18));
		btnManageFlights.setBounds(10, 225, 100, 31);
		frame.getContentPane().add(btnManageFlights);
		popupMenu.setForeground(Color.ORANGE);
		popupMenu.setBackground(new Color(255, 165, 0));

		addPopup(btnManageFlights, popupMenu);
		addPopup(detailsButton, detailsMenu);
		mntmAddFlights.setBackground(Color.ORANGE);
		mntmAddFlights.setForeground(Color.BLACK);

		popupMenu.add(mntmAddFlights);
		mntmUpdateDetails.setForeground(Color.BLACK);
		mntmUpdateDetails.setBackground(Color.ORANGE);

		popupMenu.add(mntmUpdateDetails);

		mntmDeleteFlight = new JMenuItem("Delete Flight");
		mntmDeleteFlight.setForeground(Color.BLACK);
		mntmDeleteFlight.setBackground(Color.ORANGE);
		popupMenu.add(mntmDeleteFlight);

		mntmShowAllFlights = new JMenuItem("Show all Flights");
		mntmShowAllFlights.setBackground(Color.ORANGE);
		mntmShowAllFlights.setForeground(Color.BLACK);
		popupMenu.add(mntmShowAllFlights);

		btnManageLoactions = new JButton("Loactions");
		btnManageLoactions.setBorder(new LineBorder(new Color(51, 255, 153), 1, true));
		btnManageLoactions.setBackground(new Color(72, 209, 204));
		btnManageLoactions.setFont(new Font("Monospaced", Font.PLAIN, 18));
		btnManageLoactions.setBounds(10, 269, 116, 31);

		frame.getContentPane().add(btnManageLoactions);

		addPopup(btnManageLoactions, popupMenu_1);
		mntmAddLocation.setBackground(new Color(32, 178, 170));

		popupMenu_1.add(mntmAddLocation);
		mntmModifyLocation.setBackground(new Color(32, 178, 170));

		popupMenu_1.add(mntmModifyLocation);
		mntmDeleteLocation.setBackground(new Color(32, 178, 170));

		popupMenu_1.add(mntmDeleteLocation);

		mntmViewAll = new JMenuItem("View all");
		mntmViewAll.setBackground(new Color(32, 178, 170));
		popupMenu_1.add(mntmViewAll);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getRootPane().setDefaultButton(null);

	}

	public void show() {

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
				frame.getRootPane().setDefaultButton(editDetailsActivity.btnUpdate);
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

		mntmAddLocation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AddUpdateLocation addLocation = new AddUpdateLocation();
				container.removeAll();
				container.repaint();
				container.revalidate();
				container.add(addLocation);
				container.repaint();
				container.revalidate();

			}
		});
		mntmModifyLocation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// AskingforUpdate askingforUpdate = new AskingforUpdate();
				locationCode = JOptionPane.showInputDialog(frame, "Location Code :", "Alert - AMS",
						JOptionPane.INFORMATION_MESSAGE);
				// locationCode = askingforUpdate.getLocationCode();
				locationData = locationDAOImpl.getLocationByCode(locationCode);
				AddUpdateLocation addUpdateLocation;
				if (locationData != null) {
					addUpdateLocation = new AddUpdateLocation(locationData, true);
					container.removeAll();
					container.repaint();
					container.revalidate();
					container.add(addUpdateLocation);
					container.repaint();
					container.revalidate();
				} else {
					JOptionPane.showMessageDialog(frame, "No data found!", "Alert - AMS", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		mntmDeleteLocation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				locationCode = JOptionPane.showInputDialog(frame, "Location Code :", "Alert - AMS",
						JOptionPane.INFORMATION_MESSAGE);
				// locationCode = askingforUpdate.getLocationCode();
				locationData = locationDAOImpl.getLocationByCode(locationCode);
				if (locationData != null) {
					int selectionBtn = JOptionPane.showConfirmDialog(frame,
							"Do you want to delete " + locationData.getLocationName(), "Alert - AMS",
							JOptionPane.INFORMATION_MESSAGE);
					if (selectionBtn == JOptionPane.YES_OPTION) {
						locationDAOImpl.deleteLocation(locationData.getLocationCode());
					}
				} else {
					JOptionPane.showMessageDialog(frame, "No data found!", "Alert - AMS", JOptionPane.ERROR_MESSAGE);
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

	private static void addPopup(Component component, final JPopupMenu popup) {

		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (!menuShow) {
					showMenu(e);
					menuShow = true;
				} else {
					popup.setVisible(false);
					menuShow = false;
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				if (!menuShow) {
					showMenu(e);
					menuShow = true;
				} else {
					popup.setVisible(false);
					menuShow = false;
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
