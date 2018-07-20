package com.ams.custom_dialog;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class AskingforUpdate extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private String locationCode;
	private final JTextField textFieldCode = new JTextField();
	private final JLabel lblLocationCode = new JLabel("Location Code");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AskingforUpdate dialog = new AskingforUpdate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AskingforUpdate() {
		textFieldCode.setBorder(new LineBorder(new Color(255, 235, 205), 1, true));
		textFieldCode.setBackground(new Color(240, 128, 128));
		textFieldCode.setBounds(12, 38, 252, 32);
		textFieldCode.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setType(Type.POPUP);
		setBackground(new Color(0, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage(AskingforUpdate.class.getResource("/images/planeIcon.png")));
		setTitle("Modify Location - AMS");
		setBounds(100, 100, 292, 159);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(128, 0, 0));
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 192, 203), new Color(255, 192, 203)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(12, 82, 51, 26);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
			okButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					setLocationCode(textFieldCode.getText());
					dispose();
				}
			});
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			cancelButton.setBounds(75, 82, 73, 26);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		
		contentPanel.add(textFieldCode);
		lblLocationCode.setForeground(new Color(255, 255, 255));
		lblLocationCode.setFont(new Font("Segoe Print", Font.BOLD, 14));
		lblLocationCode.setBounds(12, 10, 149, 26);
		
		contentPanel.add(lblLocationCode);
		setLocationRelativeTo(null);
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
}
