package com.ams.panels;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.ams.dao.impl.FlightDAOImpl;
import com.ams.entities.FlightsData;
import com.ams.entities.UserData;
import com.ams.model.DBConnect;

import javax.swing.JTable;

public class CancelFlights extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private final JLabel lblBookedFlights = new JLabel("Booked Flights");
	private final JButton btnCancelFlight = new JButton("Cancel Flight");
	private final JTable table = new JTable();
	private final JScrollPane scrollPane = new JScrollPane(table);
	private DefaultTableModel tableModel;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private UserData userData;
	private ArrayList<FlightsData> flightsDatas;
	private FlightDAOImpl flightDAOImpl;

	/**
	 * Create the panel.
	 */
	public CancelFlights(UserData userData) {
		this.userData = userData;
		flightsDatas = new ArrayList<FlightsData>();
		flightDAOImpl = new FlightDAOImpl();
		initGUI();
	}
	private void initGUI() {
		
		preparedStatement = DBConnect.getPreparedStatement("SELECT DISTINCT FLIGHT_ID,FLIGHT_NAME FROM BOOKED_FLIGHT_DATA WHERE UID = ?");
		try {
			preparedStatement.setInt(1, userData.getId());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				flightsDatas.add(flightDAOImpl.getOne(resultSet.getString(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		setBorder(new EmptyBorder(1, 1, 1, 1));
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		panel.setBackground(new Color(51, 153, 51));
		panel.setBorder(new EmptyBorder(1, 1, 1, 1));
		panel.setBounds(10, 11, 405, 278);
		
		add(panel);
		panel.setLayout(null);
		lblBookedFlights.setForeground(new Color(230, 230, 250));
		lblBookedFlights.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblBookedFlights.setBounds(12, 11, 196, 27);
		
		panel.add(lblBookedFlights);
		btnCancelFlight.setForeground(Color.WHITE);
		btnCancelFlight.setFont(new Font("Monospaced", Font.PLAIN, 18));
		btnCancelFlight.setBorder(new LineBorder(new Color(152, 251, 152), 1, true));
		btnCancelFlight.setBackground(new Color(50, 205, 50));
		btnCancelFlight.setBounds(104, 234, 188, 33);
		
		panel.add(btnCancelFlight);
		scrollPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		scrollPane.setBounds(12, 40, 381, 182);
		
		panel.add(scrollPane);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setBounds(0, 0, 525, 1);
		
		tableModel = new DefaultTableModel(new Object[][] {

		}, new String[] { "ID", "Name", "Arrival", "Destination", "Arrival Time", "Destination Time", "No of Seats" });
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		table.setModel(tableModel);
		for(FlightsData flightsData : flightsDatas) {
			tableModel.addRow(new Object[] {
					flightsData.getId(),flightsData.getFlightName(),flightsData.getFlightArrival(),flightsData.getFlightDestination()
					,flightsData.getArrivalTime(),flightsData.getDestinationTime(),flightsData.getSeatsAvailable()
			});
		}
		
	}
}
