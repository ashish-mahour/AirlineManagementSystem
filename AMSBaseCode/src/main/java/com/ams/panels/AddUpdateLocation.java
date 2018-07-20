package com.ams.panels;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.ams.dao.impl.LocationDAOImpl;
import com.ams.entities.LocationData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class AddUpdateLocation extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private final JLabel lblLocationName = new JLabel("Location Name");
	private final JTextField textFieldLocationName = new JTextField();
	private final JLabel lblLocationCode = new JLabel("Location Code");
	private final JTextField textFieldCode = new JTextField();
	private final JButton btnSublmit = new JButton("SUBMIT");
	private LocationDAOImpl locationDAOImpl;
	private LocationData locationData;
	private boolean updateFlag = false;
	private final JLabel lblTitle = new JLabel("Title");

	/**
	 * Creating the panel.
	 */
	public AddUpdateLocation(LocationData locationData,boolean update) {
		this.locationData = locationData;
		this.updateFlag = update;
		lblTitle.setText("Update Details");
		showData();
	}
	
	public AddUpdateLocation() {
		showData();
		lblTitle.setText("Add Details");
	}
	public void showData() {
		textFieldLocationName.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldLocationName.setBorder(new LineBorder(new Color(255, 222, 173), 1, true));
		textFieldLocationName.setBackground(new Color(255, 160, 122));
		textFieldLocationName.setBounds(179, 58, 188, 27);
		textFieldLocationName.setColumns(10);

		initGUI();
		locationDAOImpl = new LocationDAOImpl();
		if(updateFlag) {
			textFieldLocationName.setText(locationData.getLocationName());
			textFieldCode.setText(locationData.getLocationCode());
		}
		btnSublmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				LocationData locationData = new LocationData();
				locationData.setId(1);
				locationData.setLocationName(textFieldLocationName.getText());
				locationData.setLocationCode(textFieldCode.getText());
				if (!updateFlag ) {
					locationDAOImpl.saveLocation(locationData);
					JOptionPane.showMessageDialog(AddUpdateLocation.this, "Location created!", "Alert - AMS",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					locationDAOImpl.updateLocation(locationData, locationData.getLocationCode());
					JOptionPane.showMessageDialog(AddUpdateLocation.this, "Location Updated!", "Alert - AMS",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}

	private void initGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setBackground(new Color(128, 128, 128));
		setLayout(null);
		panel.setBackground(new Color(205, 92, 92));
		panel.setBorder(new LineBorder(new Color(245, 245, 245), 2, true));
		panel.setBounds(10, 11, 403, 181);

		add(panel);
		panel.setLayout(null);
		lblLocationName.setForeground(new Color(255, 255, 255));
		lblLocationName.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lblLocationName.setBounds(31, 58, 138, 27);

		panel.add(lblLocationName);

		panel.add(textFieldLocationName);
		lblLocationCode.setForeground(Color.WHITE);
		lblLocationCode.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lblLocationCode.setBounds(31, 97, 138, 27);

		panel.add(lblLocationCode);
		textFieldCode.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldCode.setColumns(10);
		textFieldCode.setBorder(new LineBorder(new Color(255, 222, 173), 1, true));
		textFieldCode.setBackground(new Color(255, 160, 122));
		textFieldCode.setBounds(179, 97, 188, 27);

		panel.add(textFieldCode);
		btnSublmit.setForeground(new Color(255, 255, 255));
		btnSublmit.setBorder(new LineBorder(new Color(152, 251, 152), 1, true));
		btnSublmit.setBackground(new Color(50, 205, 50));
		btnSublmit.setFont(new Font("Monospaced", Font.PLAIN, 18));
		btnSublmit.setBounds(114, 136, 176, 33);

		panel.add(btnSublmit);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 18));
		lblTitle.setBounds(102, 12, 221, 27);
		
		panel.add(lblTitle);
	}
}
