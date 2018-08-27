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

import com.ams.customdialogs.WaitingDialog;
import com.ams.dao.impl.FlightDAOImpl;
import com.ams.dao.impl.LocationDAOImpl;
import com.ams.dao.impl.UserDAOImplements;
import com.ams.entities.FlightsData;
import com.ams.entities.LocationData;
import com.ams.entities.UserData;
import com.ams.panels.AddUpdateFlights;
import com.ams.panels.AddUpdateLocation;
import com.ams.panels.EditDetails;
import com.ams.panels.ViewAllFlights;
import com.ams.panels.ViewAllLocations;
import com.ams.panels.ViewDetails;

import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class AdminPanelActivity {

	private JFrame frame = new JFrame("Admin Panel - AMS");;
	private BufferedImage iconImage;
	private File imageFile;
	private JLabel icon;
	private JLabel username;
	private JLabel usertype;

	private JPopupMenu detailsMenu;
	private JMenuItem editDetails, viewDetails, deleteAcc;

	private JPanel container;

	private JButton detailsButton;

	private UserData userData;

	JLabel textUsername, textPassword, textEmail, textFullName, textAge, textDob, textAddress, textContactNo,
			textGender, textUType;

	private ViewDetails viewDetailsActivity;

	private EditDetails editDetailsActivity;

	private UserDAOImplements userDAOImplements;
	private JButton btnExit;
	private JButton btnManageFlights;
	private JButton btnManageLoactions;
	private final JPopupMenu popupMenu = new JPopupMenu();
	private final JMenuItem mntmAddFlights = new JMenuItem("Add Flights");
	private final JMenuItem mntmUpdateFlight = new JMenuItem("Update Flight Details");
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
	private WaitingDialog waitingDialog = new WaitingDialog("Processing..");
	private FlightDAOImpl flightDAOImpl = new FlightDAOImpl();
	private FlightsData flightsData;
	private String flightName = null;
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblAdminPanel = new JLabel("Admin Panel - AMS");
	private final JButton btnClose = new JButton("X");

	public AdminPanelActivity(final UserData userData) {

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				waitingDialog.setVisible(true);
			}
		});
		t.setPriority(Thread.MAX_PRIORITY);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.userData = userData;
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				locationDAOImpl = new LocationDAOImpl();
				frame.setUndecorated(true);

				frame.setResizable(false);
				frame.setIconImage(Toolkit.getDefaultToolkit()
						.getImage(AdminPanelActivity.class.getResource("/images/planeIcon.png")));

				try {
					imageFile = new File("src\\main\\java\\images\\m.png");
					iconImage = ImageIO.read(imageFile);
				} catch (Exception e) {
					e.printStackTrace();
				}

				icon = new JLabel(new ImageIcon(iconImage));
				icon.setSize(100, 93);
				icon.setLocation(10, 62);

				username = new JLabel(userData.getFullName());
				username.setForeground(new Color(255, 255, 255));
				username.setBackground(new Color(204, 204, 204));
				usertype = new JLabel(userData.getUserType());
				usertype.setForeground(new Color(255, 255, 255));

				detailsMenu = new JPopupMenu();
				detailsMenu.setBorder(new EmptyBorder(1, 1, 1, 1));
				detailsMenu.setBackground(new Color(0, 0, 0));

				editDetails = new JMenuItem("Edit Details");
				editDetails.setForeground(new Color(0, 0, 0));
				editDetails.setBackground(new Color(105, 105, 105));
				viewDetails = new JMenuItem("View Details");
				viewDetails.setForeground(new Color(0, 0, 0));
				viewDetails.setBackground(new Color(105, 105, 105));
				deleteAcc = new JMenuItem("Delete Account");
				deleteAcc.setBackground(new Color(105, 105, 105));
				deleteAcc.setForeground(new Color(0, 0, 0));

				detailsButton = new JButton("Details");
				detailsButton.setForeground(new Color(0, 0, 0));
				detailsButton.setAlignmentY(0.0f);
				detailsButton.setBackground(new Color(192, 192, 192));
				detailsButton.setBorder(new EmptyBorder(1, 1, 1, 1));

				detailsMenu.add(editDetails);
				detailsMenu.add(viewDetails);
				detailsMenu.add(deleteAcc);

				username.setLocation(10, 156);
				username.setSize(127, 20);
				username.setToolTipText(userData.getFullName());
				username.setFont(new Font("Segoe Print", Font.BOLD, 14));

				usertype.setLocation(10, 174);
				usertype.setSize(68, 20);
				usertype.setFont(new Font("Segoe Print", Font.PLAIN, 8));

				detailsButton.setLocation(10, 206);
				detailsButton.setSize(114, 32);
				detailsButton.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 18));

				container = new JPanel();
				container.setAutoscrolls(true);
				container.setBorder(new LineBorder(new Color(102, 102, 102), 3, true));
				container.setLayout(new CardLayout());
				container.setBackground(new Color(204, 204, 204));
				container.setLocation(128, 36);
				container.setSize(455, 517);

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
				frame.getContentPane().setBackground(new Color(0, 0, 0));

				btnExit = new JButton("Logout");
				btnExit.setForeground(new Color(0, 0, 0));
				btnExit.setBorder(new EmptyBorder(1, 1, 1, 1));
				btnExit.setBackground(new Color(192, 192, 192));
				btnExit.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 18));
				btnExit.setBounds(10, 335, 114, 31);
				frame.getContentPane().add(btnExit);

				btnManageFlights = new JButton("Flights");
				btnManageFlights.setForeground(new Color(0, 0, 0));
				btnManageFlights.setBorder(new EmptyBorder(1, 1, 1, 1));
				btnManageFlights.setBackground(new Color(192, 192, 192));
				btnManageFlights.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 18));
				btnManageFlights.setBounds(10, 250, 116, 31);
				frame.getContentPane().add(btnManageFlights);
				popupMenu.setBorder(new EmptyBorder(1, 1, 1, 1));
				popupMenu.setForeground(Color.ORANGE);
				popupMenu.setBackground(new Color(128, 128, 128));

				addPopup(btnManageFlights, popupMenu);
				addPopup(detailsButton, detailsMenu);
				mntmAddFlights.setBackground(new Color(105, 105, 105));
				mntmAddFlights.setForeground(Color.BLACK);

				popupMenu.add(mntmAddFlights);
				mntmUpdateFlight.setForeground(Color.BLACK);
				mntmUpdateFlight.setBackground(new Color(105, 105, 105));

				popupMenu.add(mntmUpdateFlight);

				mntmDeleteFlight = new JMenuItem("Delete Flight");
				mntmDeleteFlight.setForeground(new Color(0, 0, 0));
				mntmDeleteFlight.setBackground(new Color(105, 105, 105));
				popupMenu.add(mntmDeleteFlight);

				mntmShowAllFlights = new JMenuItem("Show all Flights");
				mntmShowAllFlights.setBackground(new Color(105, 105, 105));
				mntmShowAllFlights.setForeground(Color.BLACK);
				popupMenu.add(mntmShowAllFlights);

				btnManageLoactions = new JButton("Loactions");
				btnManageLoactions.setForeground(new Color(0, 0, 0));
				btnManageLoactions.setBorder(new EmptyBorder(1, 1, 1, 1));
				btnManageLoactions.setBackground(new Color(192, 192, 192));
				btnManageLoactions.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 18));
				btnManageLoactions.setBounds(8, 293, 116, 31);

				frame.getContentPane().add(btnManageLoactions);
				popupMenu_1.setBackground(new Color(0, 0, 0));
				popupMenu_1.setBorder(new EmptyBorder(1, 1, 1, 1));

				addPopup(btnManageLoactions, popupMenu_1);
				mntmAddLocation.setForeground(new Color(0, 0, 0));
				mntmAddLocation.setBackground(new Color(105, 105, 105));

				popupMenu_1.add(mntmAddLocation);
				mntmModifyLocation.setForeground(new Color(0, 0, 0));
				mntmModifyLocation.setBackground(new Color(105, 105, 105));

				popupMenu_1.add(mntmModifyLocation);
				mntmDeleteLocation.setForeground(new Color(0, 0, 0));
				mntmDeleteLocation.setBackground(new Color(105, 105, 105));

				popupMenu_1.add(mntmDeleteLocation);

				mntmViewAll = new JMenuItem("View all");
				mntmViewAll.setForeground(new Color(0, 0, 0));
				mntmViewAll.setBackground(new Color(105, 105, 105));
				popupMenu_1.add(mntmViewAll);
				panel_1.setLayout(null);
				panel_1.setBorder(new EmptyBorder(1, 1, 1, 1));
				panel_1.setBackground(new Color(50, 205, 50));
				panel_1.setBounds(0, 0, 595, 32);

				frame.getContentPane().add(panel_1);
				lblAdminPanel.setHorizontalAlignment(SwingConstants.LEFT);
				lblAdminPanel.setForeground(Color.WHITE);
				lblAdminPanel.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 16));
				lblAdminPanel.setBounds(12, 0, 233, 30);

				panel_1.add(lblAdminPanel);
				btnClose.setForeground(Color.WHITE);
				btnClose.setFont(new Font("Dialog", Font.BOLD, 16));
				btnClose.setBorder(new EmptyBorder(1, 1, 1, 1));
				btnClose.setBackground(new Color(50, 205, 50));
				btnClose.setBounds(551, -1, 44, 33);

				panel_1.add(btnClose);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getRootPane().setDefaultButton(null);
				show();
			}
		});
		t2.start();
	}

	private void show() {
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
				int dialogAction = JOptionPane.showConfirmDialog(frame, "Are you sure for deleting your account ?",
						"Alert - AMS", JOptionPane.YES_NO_CANCEL_OPTION);
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
				AddUpdateLocation addLocation = new AddUpdateLocation();
				container.removeAll();
				container.repaint();
				container.revalidate();
				container.add(addLocation);
				frame.getRootPane().setDefaultButton(addLocation.btnSublmit);
				container.repaint();
				container.revalidate();

			}
		});
		mntmModifyLocation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				locationCode = JOptionPane.showInputDialog(frame, "Location Code :", "Alert - AMS",
						JOptionPane.INFORMATION_MESSAGE);
				locationData = locationDAOImpl.getLocationByCode(locationCode);
				AddUpdateLocation addUpdateLocation;
				if (locationData != null) {
					addUpdateLocation = new AddUpdateLocation(locationData, true);
					container.removeAll();
					container.repaint();
					container.revalidate();
					container.add(addUpdateLocation);
					frame.getRootPane().setDefaultButton(addUpdateLocation.btnSublmit);
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
				locationCode = JOptionPane.showInputDialog(frame, "Location Code :", "Alert - AMS",
						JOptionPane.INFORMATION_MESSAGE);
				locationData = locationDAOImpl.getLocationByCode(locationCode);
				if (locationData != null) {
					int selectionBtn = JOptionPane.showConfirmDialog(frame,
							"Do you want to delete " + locationData.getLocationName(), "Alert - AMS",
							JOptionPane.INFORMATION_MESSAGE);
					if (selectionBtn == JOptionPane.YES_OPTION) {
						locationDAOImpl.deleteLocation(locationData.getLocationCode());
						container.removeAll();
						container.repaint();
						container.revalidate();
					}
				} else {
					JOptionPane.showMessageDialog(frame, "No data found!", "Alert - AMS", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		mntmViewAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewAllLocations viewAllLocations = new ViewAllLocations();
				container.removeAll();
				container.repaint();
				container.revalidate();
				container.add(viewAllLocations);
				container.repaint();
				container.revalidate();

			}
		});

		mntmAddFlights.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddUpdateFlights addUpdateFlights = new AddUpdateFlights();
				container.removeAll();
				container.repaint();
				container.revalidate();
				container.add(addUpdateFlights);
				frame.getRootPane().setDefaultButton(addUpdateFlights.btnSublmit);
				container.repaint();
				container.revalidate();
			}
		});

		mntmUpdateFlight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				flightName = JOptionPane.showInputDialog(frame, "Flight Name : ", "Alert - AMS",
						JOptionPane.QUESTION_MESSAGE);
				flightsData = flightDAOImpl.getOne(flightName);
				if (flightsData != null) {
					AddUpdateFlights addUpdateFlights = new AddUpdateFlights(flightsData, true);
					container.removeAll();
					container.repaint();
					container.revalidate();
					container.add(addUpdateFlights);
					container.repaint();
					container.revalidate();
				} else {
					JOptionPane.showMessageDialog(frame, "No data found!", "Alert - AMS", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mntmDeleteFlight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				flightName = JOptionPane.showInputDialog(frame, "Flight Name :", "Alert - AMS",
						JOptionPane.QUESTION_MESSAGE);
				flightsData = flightDAOImpl.getOne(flightName);
				if (flightsData != null) {
					int selectionBtn = JOptionPane.showConfirmDialog(frame,
							"Do you want to delete " + flightsData.getFlightName(), "Alert - AMS",
							JOptionPane.INFORMATION_MESSAGE);
					if (selectionBtn == JOptionPane.YES_OPTION) {
						flightDAOImpl.deleteFlight(flightName);
						container.removeAll();
						container.repaint();
						container.revalidate();
					}
				} else {
					JOptionPane.showMessageDialog(frame, "No data found!", "Alert - AMS", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		mntmShowAllFlights.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewAllFlights viewAllFlights = new ViewAllFlights();
				container.removeAll();
				container.repaint();
				container.revalidate();
				container.add(viewAllFlights);
				container.repaint();
				container.revalidate();

			}
		});

		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new MainActivity().show();

			}
		});
		waitingDialog.dispose();
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
