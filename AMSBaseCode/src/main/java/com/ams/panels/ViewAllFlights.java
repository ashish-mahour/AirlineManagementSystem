package com.ams.panels;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.ams.dao.impl.FlightDAOImpl;
import com.ams.entities.FlightsData;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;

public class ViewAllFlights extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JTable table = new JTable();
	private JScrollPane jScrollPane = new JScrollPane();
	private DefaultTableModel defaultTableModel;
	private ArrayList<FlightsData> flightsDatas = new ArrayList<FlightsData>();
	private FlightDAOImpl flightDAOImpl = new FlightDAOImpl();

	/**
	 * Create the panel.
	 */
	public ViewAllFlights() {
		defaultTableModel = new DefaultTableModel(new Object[][] {

		}, new String[] { "ID", "Name", "Arrival", "Destination", "Arrival Time", "Destination Time", "No of Seats" });
		initGUI();
		flightsDatas = flightDAOImpl.getALL();
		for (FlightsData flightsData : flightsDatas) {
			defaultTableModel.addRow(new String[] { String.valueOf(flightsData.getId()), flightsData.getFlightName(),
					flightsData.getFlightArrival(), flightsData.getFlightDestination(), flightsData.getArrivalTime(),
					flightsData.getDestinationTime(), String.valueOf(flightsData.getSeatsAvailable()) });
		}
	}

	private void initGUI() {
		setForeground(new Color(0, 0, 0));
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setBackground(new Color(105, 105, 105));
		setLayout(null);
		jScrollPane.setBackground(new Color(192, 192, 192));
		jScrollPane.setAutoscrolls(true);

		jScrollPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		jScrollPane.setBounds(10, 11, 408, 483);

		add(jScrollPane);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setFillsViewportHeight(true);
		jScrollPane.setViewportView(table);
		table.setSelectionBackground(Color.ORANGE);
		table.setGridColor(new Color(245, 245, 245));
		table.setBorder(new EmptyBorder(1, 1, 1, 1));
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(169, 169, 169));

		table.setModel(defaultTableModel);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setMinWidth(20);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
		table.getColumnModel().getColumn(4).setPreferredWidth(86);
		table.getColumnModel().getColumn(5).setPreferredWidth(95);
	}
}
