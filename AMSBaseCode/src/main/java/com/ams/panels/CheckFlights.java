package com.ams.panels;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.ams.dao.impl.FlightDAOImpl;
import com.ams.dao.impl.LocationDAOImpl;
import com.ams.entities.FlightsData;
import com.ams.entities.LocationData;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckFlights extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private final JTable table = new JTable();
	private final JScrollPane tableScroll = new JScrollPane(table);
	private DefaultTableModel tableModel;
	private final JLabel lblArrivalplace = new JLabel("Arrival");
	private final JComboBox<String> comboArrival = new JComboBox<String>();
	private final JComboBox<String> comboBoxDest = new JComboBox<String>();
	private final JLabel lblDestination = new JLabel("Destination");
	private final JLabel lblTimeArr = new JLabel("Time ");
	private final JSpinner spinnerTimeArr = new JSpinner();
	private final JButton button = new JButton("SUBMIT");
	private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");
	private Date defaultDate = null;
	private LocationDAOImpl locationDAOImpl = new LocationDAOImpl();
	private ArrayList<LocationData> locationDatas = new ArrayList<LocationData>();
	private FlightDAOImpl flightDAOImpl = new FlightDAOImpl();
	private ArrayList<FlightsData> flightsDatas = new ArrayList<FlightsData>();
	private final JLabel lblAvailableFlights = new JLabel("Available Flights");

	/**
	 * Create the panel.
	 */
	public CheckFlights() {
		try {
			defaultDate = simpleDateFormat.parse("00:00 AM");
		} catch (Exception e) {
			e.printStackTrace();
		}
		initGUI();
	}

	private void initGUI() {
		setBackground(Color.GRAY);
		setBorder(new EmptyBorder(1, 1, 1, 1));
		setLayout(null);
		panel.setBackground(new Color(0, 100, 0));
		panel.setBorder(new EmptyBorder(1, 1, 1, 1));
		panel.setBounds(10, 11, 396, 471);

		add(panel);
		panel.setLayout(null);
		tableScroll.setBorder(new EmptyBorder(1, 1, 1, 1));
		tableScroll.setBounds(10, 227, 372, 233);

		tableModel = new DefaultTableModel(new Object[][] {

		}, new String[] { "Name", "Arrival", "Destination", "Arrival Time", "Destination Time", "No of Seats" });
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		table.setModel(tableModel);
		panel.add(tableScroll);
		lblArrivalplace.setForeground(new Color(230, 230, 250));
		lblArrivalplace.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblArrivalplace.setBounds(10, 34, 138, 27);

		panel.add(lblArrivalplace);
		comboArrival.setFont(new Font("Dialog", Font.PLAIN, 14));
		comboArrival.setBorder(new LineBorder(new Color(135, 206, 250), 1, true));
		comboArrival.setBounds(187, 35, 188, 27);

		panel.add(comboArrival);
		comboBoxDest.setFont(new Font("Dialog", Font.PLAIN, 14));
		comboBoxDest.setBorder(new LineBorder(new Color(135, 206, 250), 1, true));
		comboBoxDest.setBounds(187, 74, 188, 27);

		panel.add(comboBoxDest);
		lblDestination.setForeground(new Color(230, 230, 250));
		lblDestination.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblDestination.setBounds(10, 73, 138, 27);

		panel.add(lblDestination);
		lblTimeArr.setForeground(new Color(230, 230, 250));
		lblTimeArr.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblTimeArr.setBounds(10, 116, 138, 27);

		panel.add(lblTimeArr);
		spinnerTimeArr.setBorder(new LineBorder(new Color(135, 206, 250), 1, true));
		spinnerTimeArr.setBounds(187, 121, 188, 23);
		spinnerTimeArr.setModel(new SpinnerDateModel(defaultDate, null, null, Calendar.HOUR_OF_DAY));
		spinnerTimeArr.setEditor(new JSpinner.DateEditor(spinnerTimeArr, "hh:mm a"));
		
		panel.add(spinnerTimeArr);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (tableModel.getRowCount() > 0) {
					for(int i = 0; i < tableModel.getRowCount(); i++ ) {
						tableModel.removeRow(i);
					}
				}
				
				if (comboArrival.getSelectedItem().toString()
						.equalsIgnoreCase((comboBoxDest.getSelectedItem().toString()))) {
					JOptionPane.showMessageDialog(CheckFlights.this, "Destination and Arrival can't be same!",
							"Alert - AMS", JOptionPane.ERROR_MESSAGE);
				} else {
					flightsDatas = flightDAOImpl.getByTimeAndPlace(String.valueOf(comboArrival.getSelectedItem()),
							String.valueOf(comboBoxDest.getSelectedItem()),
							simpleDateFormat.format(spinnerTimeArr.getValue()));
					for (FlightsData f : flightsDatas) {
						tableModel.addRow(new Object[] { f.getFlightName(), f.getFlightArrival(),
								f.getFlightDestination(), f.getArrivalTime(), f.getDestinationTime(),
								String.valueOf(f.getSeatsAvailable()) });
					}

				}
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Monospaced", Font.PLAIN, 18));
		button.setBorder(new LineBorder(new Color(152, 251, 152), 1, true));
		button.setBackground(new Color(50, 205, 50));
		button.setBounds(104, 155, 176, 33);

		panel.add(button);
		lblAvailableFlights.setForeground(new Color(230, 230, 250));
		lblAvailableFlights.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblAvailableFlights.setBounds(12, 198, 196, 27);

		panel.add(lblAvailableFlights);

		locationDatas = locationDAOImpl.getAllLocation();
		for (LocationData l : locationDatas) {
			comboArrival.addItem(l.getLocationName());
			comboBoxDest.addItem(l.getLocationName());
		}
	}
}
