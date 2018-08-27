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
import com.ams.dao.impl.UserDAOImplements;
import com.ams.entities.UserData;
import com.ams.panels.CheckFlights;
import com.ams.panels.EditDetails;
import com.ams.panels.ViewDetails;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import java.awt.Component;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class UserPanelActivity {
	JFrame frame;

	BufferedImage iconImage;
	File imageFile;

	JLabel icon, username, usertype;

	JPanel container;

	JButton detailsButton;

	UserData userData;

	JLabel textUsername, textPassword, textEmail, textFullName, textAge, textDob, textAddress, textContactNo,
			textGender, textUType;

	ViewDetails viewDetailsActivity;

	EditDetails editDetailsActivity;

	UserDAOImplements userDAOImplements;
	private JButton btnExit;
	private JPopupMenu popupMenu;
	private JMenuItem mntmViewDetails;
	private JMenuItem mntmEditDetails;
	private JMenuItem mntmDeleteMyAccount;

	protected static boolean menuShow = false;
	private final JButton btnFlights = new JButton("Flights");
	private final JPopupMenu popupMenuFlights = new JPopupMenu();
	private final JMenuItem mntmCheckFlight = new JMenuItem("Check Flight");
	private final JMenuItem mntmBookFlight = new JMenuItem("Book Flight");
	private final JMenuItem mntmCancelFlights = new JMenuItem("Cancel Flights");
	private WaitingDialog waitingDialog = new WaitingDialog("Processing..");
	private JPanel panel;
	private JLabel lblUserPanel;
	private JButton btnClose;

	public UserPanelActivity(final UserData userData) {
		// TODO Auto-generated constructor stub
		this.userData = userData;
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
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				frame = new JFrame("User panel - AMS");
				frame.setUndecorated(true);
				frame.setIconImage(Toolkit.getDefaultToolkit()
						.getImage(UserPanelActivity.class.getResource("/images/planeIcon.png")));

				try {
					imageFile = new File("src\\main\\java\\images\\m.png");
					iconImage = ImageIO.read(imageFile);
				} catch (Exception e) {
					e.printStackTrace();
				}

				icon = new JLabel(new ImageIcon(iconImage));
				icon.setSize(100, 100);
				icon.setLocation(10, 72);

				username = new JLabel(userData.getFullName());
				username.setForeground(new Color(255, 255, 255));
				usertype = new JLabel(userData.getUserType());
				usertype.setForeground(new Color(255, 255, 255));

				detailsButton = new JButton("Details");
				detailsButton.setBorder(new EmptyBorder(1, 1, 1, 1));
				detailsButton.setBackground(new Color(192, 192, 192));

				username.setLocation(10, 184);
				username.setSize(124, 20);
				username.setToolTipText(userData.getFullName());
				username.setFont(new Font("Segoe Script", Font.PLAIN, 14));

				usertype.setLocation(10, 205);
				usertype.setSize(100, 20);
				usertype.setFont(new Font("Segoe Print", Font.PLAIN, 8));

				detailsButton.setLocation(10, 233);
				detailsButton.setSize(124, 31);
				detailsButton.setFont(new Font("Monospaced", Font.PLAIN, 18));

				container = new JPanel();
				container.setBorder(new LineBorder(new Color(153, 153, 153), 2, true));
				container.setLayout(new CardLayout());
				container.setBackground(new Color(204, 204, 204));
				container.setLocation(152, 44);
				container.setSize(435, 513);

				viewDetailsActivity = new ViewDetails(userData);
				editDetailsActivity = new EditDetails(userData);
				userDAOImplements = new UserDAOImplements();

				frame.getContentPane().add(icon);
				frame.getContentPane().add(username);
				frame.getContentPane().add(usertype);
				frame.getContentPane().add(detailsButton);

				popupMenu = new JPopupMenu();
				popupMenu.setBorder(new EmptyBorder(1, 1, 1, 1));
				popupMenu.setBackground(new Color(0, 0, 0));
				popupMenu.setForeground(new Color(0, 0, 0));
				addPopup(detailsButton, popupMenu);

				mntmViewDetails = new JMenuItem("View Details");
				mntmViewDetails.setForeground(new Color(0, 0, 0));
				mntmViewDetails.setBorder(new LineBorder(new Color(105, 105, 105), 1, true));
				mntmViewDetails.setBackground(new Color(105, 105, 105));
				popupMenu.add(mntmViewDetails);

				mntmEditDetails = new JMenuItem("Edit Details");
				mntmEditDetails.setForeground(new Color(0, 0, 0));
				mntmEditDetails.setBorder(new LineBorder(new Color(105, 105, 105), 1, true));
				mntmEditDetails.setBackground(new Color(105, 105, 105));
				popupMenu.add(mntmEditDetails);

				mntmDeleteMyAccount = new JMenuItem("Delete my account");
				mntmDeleteMyAccount.setForeground(new Color(0, 0, 0));
				mntmDeleteMyAccount.setBorder(new LineBorder(new Color(105, 105, 105), 1, true));
				mntmDeleteMyAccount.setBackground(new Color(105, 105, 105));
				popupMenu.add(mntmDeleteMyAccount);
				frame.getContentPane().add(container);

				frame.getContentPane().setLayout(null);
				frame.setSize(599, 569);
				frame.getContentPane().setBackground(new Color(0, 0, 0));

				btnExit = new JButton("Logout");
				btnExit.setBorder(new EmptyBorder(1, 1, 1, 1));
				btnExit.setBackground(new Color(192, 192, 192));
				btnExit.setFont(new Font("Monospaced", Font.PLAIN, 18));
				btnExit.setBounds(10, 319, 124, 31);
				frame.getContentPane().add(btnExit);
				btnFlights.setFont(new Font("Monospaced", Font.PLAIN, 18));
				btnFlights.setBorder(new EmptyBorder(1, 1, 1, 1));
				btnFlights.setBackground(new Color(192, 192, 192));
				btnFlights.setBounds(10, 276, 124, 31);

				frame.getContentPane().add(btnFlights);
				popupMenuFlights.setBackground(new Color(105, 105, 105));
				popupMenuFlights.setBorder(new EmptyBorder(1, 1, 1, 1));

				addPopup(btnFlights, popupMenuFlights);
				mntmCheckFlight.setBorder(new EmptyBorder(1, 1, 1, 1));
				mntmCheckFlight.setForeground(new Color(0, 0, 0));
				mntmCheckFlight.setBackground(new Color(105, 105, 105));

				popupMenuFlights.add(mntmCheckFlight);
				mntmBookFlight.setBorder(new EmptyBorder(1, 1, 1, 1));
				mntmBookFlight.setForeground(new Color(0, 0, 0));
				mntmBookFlight.setBackground(new Color(105, 105, 105));

				popupMenuFlights.add(mntmBookFlight);
				mntmCancelFlights.setBorder(new EmptyBorder(1, 1, 1, 1));
				mntmCancelFlights.setForeground(new Color(0, 0, 0));
				mntmCancelFlights.setBackground(new Color(105, 105, 105));

				popupMenuFlights.add(mntmCancelFlights);
				
				panel = new JPanel();
				panel.setLayout(null);
				panel.setBorder(new EmptyBorder(1, 1, 1, 1));
				panel.setBackground(new Color(50, 205, 50));
				panel.setBounds(0, 0, 599, 32);
				frame.getContentPane().add(panel);
				
				lblUserPanel = new JLabel("User Panel - AMS");
				lblUserPanel.setHorizontalAlignment(SwingConstants.LEFT);
				lblUserPanel.setForeground(Color.WHITE);
				lblUserPanel.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 16));
				lblUserPanel.setBounds(12, 0, 233, 30);
				panel.add(lblUserPanel);
				
				btnClose = new JButton("X");
				btnClose.setForeground(Color.WHITE);
				btnClose.setFont(new Font("Dialog", Font.BOLD, 16));
				btnClose.setBorder(new EmptyBorder(1, 1, 1, 1));
				btnClose.setBackground(new Color(50, 205, 50));
				btnClose.setBounds(551, -1, 44, 33);
				panel.add(btnClose);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				show();
				waitingDialog.dispose();
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
		mntmViewDetails.addActionListener(new ActionListener() {
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
		mntmEditDetails.addActionListener(new ActionListener() {

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
		mntmDeleteMyAccount.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int dialogAction = JOptionPane.showConfirmDialog(frame, "Are you sure for deleting your account ?",
						"Alert - AMS", JOptionPane.QUESTION_MESSAGE);
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
		mntmCheckFlight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CheckFlights checkFlights = new CheckFlights();
				container.removeAll();
				container.repaint();
				container.revalidate();
				container.add(checkFlights);
				container.repaint();
				container.revalidate();
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
