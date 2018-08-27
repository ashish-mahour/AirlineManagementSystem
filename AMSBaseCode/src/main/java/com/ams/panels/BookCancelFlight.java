package com.ams.panels;

import javax.swing.JPanel;

import com.ams.activities.UserPanelActivity;
import com.ams.dao.impl.FlightDAOImpl;
import com.ams.entities.FlightsData;
import com.ams.entities.UserData;
import com.ams.model.DBConnect;

import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class BookCancelFlight extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FlightsData flightsData;
	private final JPanel panel = new JPanel();
	private final JLabel lblTitle = new JLabel("Book Flights");
	private final JLabel label = new JLabel("Flight Name");
	private final JLabel lblTextFlightName = new JLabel("Text Flight Name");
	private final JLabel lblFlightArrival = new JLabel("Flight Arrival");
	private final JLabel lblTextFlightArrival = new JLabel("Text Flight Arrival");
	private final JLabel lblFlightDestination = new JLabel("Flight Destination");
	private final JLabel lblTextFlightDestination = new JLabel("Text Flight Destination");
	private final JLabel lblTimeArrival = new JLabel("Time Arrival");
	private final JLabel lblTextTimeArrival = new JLabel("Text Time Arrival");
	private final JLabel lblTimeDestination = new JLabel("Time Destination");
	private final JLabel lblTextTimeDestination = new JLabel("Text Time Destination");
	private final JPanel seatsAvailablePanel = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane(seatsAvailablePanel);
	private final JButton btnBook = new JButton("Book Flights");
	private int seatsAvailable = 0;
	private boolean cancelFlightFlag = false;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private UserData userData;
	private ArrayList<String> seatsBooked = new ArrayList<String>();
	private ResultSet resultSet;
	private FlightDAOImpl flightDAOImpl = new FlightDAOImpl();

	/**
	 * Create the panel.
	 */
	public BookCancelFlight(FlightsData flightsData, UserData userData, String title, boolean cancelFlightFlag) {
		statement = DBConnect.getStatement();
		try {
			statement.execute(
					"CREATE TABLE IF NOT EXISTS BOOKED_FLIGHT_DATA(BOOK_NO INT PRIMARY KEY AUTO_INCREMENT, UID INT, UNAME VARCHAR(200), FLIGHT_ID INT, FLIGHT_NAME VARCHAR(200), SEAT_NO VARCHAR(20))");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		seatsAvailablePanel.setBorder(new EmptyBorder(1, 1, 1, 1));
		seatsAvailablePanel.setBackground(new Color(64, 224, 208));

		this.flightsData = flightsData;
		this.cancelFlightFlag = cancelFlightFlag;
		this.userData = userData;

		preparedStatement = DBConnect.getPreparedStatement("SELECT SEAT_NO FROM BOOKED_FLIGHT_DATA WHERE UID = ? AND FLIGHT_NAME = ?");
		try {
			preparedStatement.setInt(1, userData.getId());
			preparedStatement.setString(2, flightsData.getFlightName());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				seatsBooked.add(resultSet.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (cancelFlightFlag) {
			btnBook.setText("Cancel Flights");
			seatsAvailable = seatsBooked.size();
			seatsAvailablePanel.setLayout(new GridLayout((seatsAvailable / 4), 4));
		} else {
			seatsAvailable = flightsData.getSeatsAvailable();
			seatsAvailablePanel.setLayout(new GridLayout((seatsAvailable / 4), 4));
		}
		initGUI();
		lblTitle.setText(title);

	}

	private void initGUI() {
		setBorder(new EmptyBorder(1, 1, 1, 1));
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		panel.setBorder(new EmptyBorder(1, 1, 1, 1));
		panel.setBackground(new Color(102, 204, 204));
		panel.setBounds(10, 11, 400, 432);

		add(panel);
		panel.setLayout(null);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.DARK_GRAY);
		lblTitle.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 18));
		lblTitle.setBounds(12, 12, 376, 27);

		panel.add(lblTitle);
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		label.setBounds(22, 45, 138, 27);

		panel.add(label);
		lblTextFlightName.setForeground(Color.DARK_GRAY);
		lblTextFlightName.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblTextFlightName.setBounds(182, 45, 192, 27);

		panel.add(lblTextFlightName);
		lblFlightArrival.setForeground(Color.DARK_GRAY);
		lblFlightArrival.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblFlightArrival.setBounds(22, 75, 138, 27);

		panel.add(lblFlightArrival);
		lblTextFlightArrival.setForeground(Color.DARK_GRAY);
		lblTextFlightArrival.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblTextFlightArrival.setBounds(182, 75, 192, 27);

		panel.add(lblTextFlightArrival);
		lblFlightDestination.setForeground(Color.DARK_GRAY);
		lblFlightDestination.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblFlightDestination.setBounds(22, 106, 153, 27);

		panel.add(lblFlightDestination);
		lblTextFlightDestination.setForeground(Color.DARK_GRAY);
		lblTextFlightDestination.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblTextFlightDestination.setBounds(182, 106, 192, 27);

		panel.add(lblTextFlightDestination);
		lblTimeArrival.setForeground(Color.DARK_GRAY);
		lblTimeArrival.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblTimeArrival.setBounds(22, 138, 153, 27);

		panel.add(lblTimeArrival);
		lblTextTimeArrival.setForeground(Color.DARK_GRAY);
		lblTextTimeArrival.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblTextTimeArrival.setBounds(182, 138, 192, 27);

		panel.add(lblTextTimeArrival);
		lblTimeDestination.setForeground(Color.DARK_GRAY);
		lblTimeDestination.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblTimeDestination.setBounds(22, 172, 153, 27);

		panel.add(lblTimeDestination);
		lblTextTimeDestination.setForeground(Color.DARK_GRAY);
		lblTextTimeDestination.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblTextTimeDestination.setBounds(182, 172, 192, 27);

		panel.add(lblTextTimeDestination);
		scrollPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		scrollPane.setBounds(22, 211, 366, 154);

		panel.add(scrollPane);
		btnBook.setForeground(new Color(0, 0, 0));
		btnBook.setFont(new Font("Monospaced", Font.PLAIN, 18));
		btnBook.setBorder(new LineBorder(new Color(152, 251, 152), 1, true));
		btnBook.setBackground(new Color(30, 144, 255));
		btnBook.setBounds(114, 377, 188, 33);

		panel.add(btnBook);
		lblTextFlightName.setText(flightsData.getFlightName());
		lblTextFlightArrival.setText(flightsData.getFlightArrival());
		lblTextFlightDestination.setText(flightsData.getFlightDestination());
		lblTextTimeArrival.setText(flightsData.getArrivalTime());
		lblTextTimeDestination.setText(flightsData.getDestinationTime());
		if (!cancelFlightFlag) {
				for (int i = 0; i < seatsAvailable; i++) {
					if (seatsBooked.size() == 0) {
						seatsAvailablePanel.add(new JCheckBox("Seat " + (i + 1)));
					} else {
							if(!seatsBooked.contains("Seat " + (i + 1))) {
								seatsAvailablePanel.add(new JCheckBox("Seat " + (i + 1)));
							}
						
					}
				}
			} else {
			for (int i = 0; i < seatsBooked.size(); i++) {
				seatsAvailablePanel.add(new JCheckBox(seatsBooked.get(i)));
			}
		}

		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!cancelFlightFlag) {
					for (int i = 0; i < seatsAvailablePanel.getComponentCount(); i++) {
						if (seatsAvailablePanel.getComponent(i) instanceof JCheckBox) {
							JCheckBox jCheckBox = (JCheckBox) seatsAvailablePanel.getComponent(i);
							if (jCheckBox.isSelected()) {
								seatsAvailable--;
								preparedStatement = DBConnect.getPreparedStatement(
										"INSERT INTO BOOKED_FLIGHT_DATA(UID, UNAME, FLIGHT_ID, FLIGHT_NAME, SEAT_NO) VALUES(?,?,?,?,?)");
								try {
									preparedStatement.setInt(1, userData.getId());
									preparedStatement.setString(2, userData.getFullName());
									preparedStatement.setInt(3, flightsData.getId());
									preparedStatement.setString(4, flightsData.getFlightName());
									preparedStatement.setString(5, jCheckBox.getText());
									preparedStatement.execute();
								} catch (SQLException e1) {
									e1.printStackTrace();
								}

							}
						}
					}
					JOptionPane.showMessageDialog(BookCancelFlight.this, "Flights booked!", "Alert - AMS",
							JOptionPane.INFORMATION_MESSAGE);
					flightsData.setSeatsAvailable(seatsAvailable);
					flightDAOImpl.modifyFlight(flightsData.getFlightName(), flightsData);
					UserPanelActivity.container.removeAll();
					UserPanelActivity.container.repaint();
					UserPanelActivity.container.revalidate();
					UserPanelActivity.container.add(new BookFlights(userData));
					UserPanelActivity.container.repaint();
					UserPanelActivity.container.revalidate();
				} else {

				}
			}
		});

	}
}
