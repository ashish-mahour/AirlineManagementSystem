package com.ams.panels;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.ams.dao.impl.LocationDAOImpl;
import com.ams.entities.LocationData;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;

public class ViewAllLocations extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JTable table = new JTable();
	private JScrollPane jScrollPane = new JScrollPane(table);
	private DefaultTableModel defaultTableModel;
	private ArrayList<LocationData> locationDatas = new ArrayList<LocationData>();
	private LocationDAOImpl locationDAOImpl = new LocationDAOImpl();
	

	/**
	 * Create the panel.
	 */
	public ViewAllLocations() {
		defaultTableModel = new DefaultTableModel(new Object[][] {
			
		}, new String[] {
				"Location ID","Location Name","Location code"
		});
		initGUI();
		locationDatas = locationDAOImpl.getAllLocation();
		for(LocationData l : locationDatas) {
			defaultTableModel.addRow(new String[] {
					String.valueOf(l.getId()),l.getLocationName(),l.getLocationCode()
			});
		}
	}
	private void initGUI() {
		setForeground(new Color(0, 0, 0));
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setBackground(new Color(105, 105, 105));
		setLayout(null);
		table.setSelectionBackground(Color.ORANGE);
		table.setGridColor(Color.WHITE);
		table.setBorder(new EmptyBorder(1, 1, 1, 1));
		table.setForeground(new Color(0, 0, 0));
		table.setFillsViewportHeight(true);
		table.setBackground(new Color(169, 169, 169));
		table.setBounds(12, 12, 239, 276);
		table.getColumnModel().setColumnMargin(10);
		
		table.setModel(defaultTableModel);
		
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(20);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		jScrollPane.setViewportBorder(new EmptyBorder(1, 1, 1, 1));
		
		jScrollPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		jScrollPane.setBounds(12, 12, 396, 427);
		
		add(jScrollPane);
	}
}
