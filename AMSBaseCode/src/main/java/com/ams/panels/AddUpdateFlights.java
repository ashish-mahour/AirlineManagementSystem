package com.ams.panels;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.ams.dao.impl.FlightDAOImpl;
import com.ams.dao.impl.LocationDAOImpl;
import com.ams.entities.FlightsData;
import com.ams.entities.LocationData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.util.Date;

public class AddUpdateFlights extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private final JLabel lblFlightName = new JLabel("Flight Name");
	private final JTextField textFieldFlightName = new JTextField();
	private final JLabel lblArrival = new JLabel("Arrival");
	public final JButton btnSublmit = new JButton("SUBMIT");
	private FlightDAOImpl flightDAOImp;
	private FlightsData flightData;
	private boolean updateFlag = false;
	private final JLabel lblTitle = new JLabel("Title");
	private final JComboBox<String> arrivalComboBox = new JComboBox<String>();
	private final JLabel lblDestination = new JLabel("Destination");
	private final JComboBox<String> destinationComboBox = new JComboBox<String>();
	private final JLabel lblTimeArrival = new JLabel("Time Arrival");
	private final JLabel lblTimeDestination = new JLabel("Time Destination");
	private final JLabel lblNoOf = new JLabel("Number of Seats");
	private LocationDAOImpl locationDAOImpl = new LocationDAOImpl();
	private ArrayList<LocationData> locationDatas = new ArrayList<LocationData>();
	private final JSpinner noOfSeats = new JSpinner();
	private final JSpinner spinnerTimeArr = new JSpinner();
	private final JSpinner spinnerTimeDest = new JSpinner();
	private final SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel();
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:ss a");
	private Date defaultDate = null;

	/**
	 * Creating the panel.
	 */
	public AddUpdateFlights(FlightsData flightData, boolean update) {
		this.flightData = flightData;
		this.updateFlag = update;
		lblTitle.setText("Update Flight Details");
		locationDatas = locationDAOImpl.getAllLocation();
		textFieldFlightName.setEditable(false);
		showData();
	}

	public AddUpdateFlights() {
		lblTitle.setText("Add Flight Details");
		locationDatas = locationDAOImpl.getAllLocation();
		showData();
	}

	public void showData() {
		try {
			defaultDate = simpleDateFormat.parse("00:00 AM");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		initGUI();
		flightDAOImp = new FlightDAOImpl();
		if (updateFlag) {
			textFieldFlightName.setText(flightData.getFlightName());
			destinationComboBox.setSelectedItem(flightData.getFlightDestination());
			arrivalComboBox.setSelectedItem(flightData.getFlightArrival());
			try {
				spinnerTimeArr.setValue(simpleDateFormat.parse(flightData.getArrivalTime()));
				spinnerTimeDest.setValue(simpleDateFormat.parse(flightData.getDestinationTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			noOfSeats.setValue(flightData.getSeatsAvailable());
		}
		btnSublmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (textFieldFlightName.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(AddUpdateFlights.this, "Flight name can't be empty!", "Alert - AMS",
							JOptionPane.ERROR_MESSAGE);
				} else if (arrivalComboBox.getSelectedItem().toString()
						.equalsIgnoreCase((destinationComboBox.getSelectedItem().toString()))) {
					JOptionPane.showMessageDialog(AddUpdateFlights.this, "Destination and Arrival can't be same!",
							"Alert - AMS", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						flightData = new FlightsData(0, textFieldFlightName.getText(),
								arrivalComboBox.getSelectedItem().toString(),
								destinationComboBox.getSelectedItem().toString(), simpleDateFormat.format(spinnerTimeArr.getValue()),
								simpleDateFormat.format(spinnerTimeDest.getValue()),
								Integer.valueOf(noOfSeats.getValue().toString()));
						if (!updateFlag) {
							flightDAOImp.addFlight(flightData);
							JOptionPane.showMessageDialog(AddUpdateFlights.this, "Flight created!", "Alert - AMS",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							flightDAOImp.modifyFlight(flightData.getFlightName(), flightData);
							JOptionPane.showMessageDialog(AddUpdateFlights.this, "Flight Updated!", "Alert - AMS",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(AddUpdateFlights.this, e.getMessage(), "Alert - AMS",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	}

	private void initGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setBackground(new Color(128, 128, 128));
		setLayout(null);
		panel.setBackground(new Color(0, 128, 128));
		panel.setBorder(new LineBorder(new Color(245, 245, 245), 1, true));
		panel.setBounds(10, 11, 403, 374);

		add(panel);
		panel.setLayout(null);
		lblFlightName.setForeground(new Color(230, 230, 250));
		lblFlightName.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblFlightName.setBounds(31, 58, 138, 27);

		panel.add(lblFlightName);

		textFieldFlightName.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldFlightName.setBorder(new LineBorder(new Color(102, 204, 255), 1, true));
		textFieldFlightName.setBackground(new Color(211, 211, 211));
		textFieldFlightName.setBounds(179, 58, 188, 27);
		textFieldFlightName.setColumns(10);

		panel.add(textFieldFlightName);
		lblArrival.setForeground(new Color(230, 230, 250));
		lblArrival.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblArrival.setBounds(31, 97, 138, 27);

		panel.add(lblArrival);
		btnSublmit.setForeground(new Color(255, 255, 255));
		btnSublmit.setBorder(new LineBorder(new Color(152, 251, 152), 1, true));
		btnSublmit.setBackground(new Color(50, 205, 50));
		btnSublmit.setFont(new Font("Monospaced", Font.PLAIN, 18));
		btnSublmit.setBounds(115, 329, 176, 33);

		panel.add(btnSublmit);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 18));
		lblTitle.setBounds(12, 12, 379, 27);

		panel.add(lblTitle);

		arrivalComboBox.setBounds(179, 97, 188, 27);
		arrivalComboBox.setFont(new Font("Dialog", Font.PLAIN, 14));
		arrivalComboBox.setBorder(new LineBorder(new Color(135, 206, 250), 1, true));
		panel.add(arrivalComboBox);

		lblDestination.setForeground(new Color(230, 230, 250));
		lblDestination.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblDestination.setBounds(31, 136, 138, 27);

		panel.add(lblDestination);
		destinationComboBox.setFont(new Font("Dialog", Font.PLAIN, 14));
		destinationComboBox.setBorder(new LineBorder(new Color(135, 206, 250), 1, true));
		destinationComboBox.setBounds(179, 136, 188, 27);

		panel.add(destinationComboBox);
		lblTimeArrival.setForeground(new Color(230, 230, 250));
		lblTimeArrival.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblTimeArrival.setBounds(31, 179, 138, 27);

		panel.add(lblTimeArrival);
		lblTimeDestination.setForeground(new Color(230, 230, 250));
		lblTimeDestination.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblTimeDestination.setBounds(31, 218, 180, 27);

		panel.add(lblTimeDestination);
		lblNoOf.setForeground(new Color(230, 230, 250));
		lblNoOf.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblNoOf.setBounds(31, 258, 207, 27);

		panel.add(lblNoOf);
		spinnerTimeArr.setBounds(179, 183, 188, 23);

		spinnerTimeArr.setModel(new SpinnerDateModel(defaultDate, null, null, Calendar.HOUR_OF_DAY));
		spinnerTimeArr.setEditor(new JSpinner.DateEditor(spinnerTimeArr, "hh:mm a"));

		panel.add(spinnerTimeArr);
		spinnerTimeDest.setBounds(229, 222, 138, 23);
		spinnerTimeDest.setModel(new SpinnerDateModel(defaultDate, null, null, Calendar.HOUR_OF_DAY));
		spinnerTimeDest.setEditor(new JSpinner.DateEditor(spinnerTimeDest, "hh:mm a"));
		spinnerTimeDest.getEditor().getComponent(0).setBackground(new Color(211, 211, 211));
		spinnerTimeDest.setBorder(new LineBorder(new Color(135, 206, 250), 1, true));

		panel.add(spinnerTimeDest);
		noOfSeats.setToolTipText("Max (50 Seats)");
		noOfSeats.setBounds(297, 261, 70, 23);
		spinnerNumberModel.setValue(1);
		spinnerNumberModel.setMinimum(1);
		spinnerNumberModel.setMaximum(50);
		noOfSeats.setModel(spinnerNumberModel);
		noOfSeats.setEditor(new JSpinner.NumberEditor(noOfSeats, "00"));
		noOfSeats.getEditor().getComponent(0).setBackground(new Color(211, 211, 211));
		noOfSeats.setBorder(new LineBorder(new Color(135, 206, 250), 1, true));

		spinnerTimeArr.getEditor().getComponent(0).setBackground(new Color(211, 211, 211));
		spinnerTimeArr.setBorder(new LineBorder(new Color(135, 206, 250), 1, true));
		panel.add(noOfSeats);

		for (LocationData l : locationDatas) {
			arrivalComboBox.addItem(l.getLocationName());
			destinationComboBox.addItem(l.getLocationName());
		}

	}
}
