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
import com.ams.panels.EditDetails;
import com.ams.panels.ViewDetails;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import java.awt.Component;
import javax.swing.border.EmptyBorder;

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
				icon.setLocation(10, 20);

				username = new JLabel(userData.getFullName());
				username.setForeground(new Color(255, 255, 255));
				usertype = new JLabel(userData.getUserType());
				usertype.setForeground(new Color(255, 255, 255));

				detailsButton = new JButton("Details");
				detailsButton.setBorder(new EmptyBorder(1, 1, 1, 1));
				detailsButton.setBackground(new Color(192, 192, 192));

				username.setLocation(10, 130);
				username.setSize(124, 20);
				username.setToolTipText(userData.getFullName());
				username.setFont(new Font("Segoe Script", Font.PLAIN, 14));

				usertype.setLocation(10, 150);
				usertype.setSize(100, 20);
				usertype.setFont(new Font("Segoe Print", Font.PLAIN, 8));

				detailsButton.setLocation(10, 181);
				detailsButton.setSize(124, 31);
				detailsButton.setFont(new Font("Monospaced", Font.PLAIN, 18));

				container = new JPanel();
				container.setBorder(new LineBorder(new Color(153, 153, 153), 2, true));
				container.setLayout(new CardLayout());
				container.setBackground(new Color(204, 204, 204));
				container.setLocation(144, 20);
				container.setSize(424, 500);

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
				btnExit.setBounds(10, 267, 124, 31);
				frame.getContentPane().add(btnExit);
				btnFlights.setFont(new Font("Monospaced", Font.PLAIN, 18));
				btnFlights.setBorder(new EmptyBorder(1, 1, 1, 1));
				btnFlights.setBackground(new Color(192, 192, 192));
				btnFlights.setBounds(10, 224, 124, 31);

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
