package com.ams.customdialogs;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JProgressBar;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class WaitingDialog extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JProgressBar progressBar = new JProgressBar();
	private final JLabel lblProcessText = new JLabel("");

	
	/**
	 * Create the frame.
	 */
	public WaitingDialog(String title) {
		setUndecorated(true);
		setTitle(title);
		lblProcessText.setText(title);
		initGUI();
	}
	private void initGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(WaitingDialog.class.getResource("/images/planeIcon.png")));
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		getContentPane().setBackground(new Color(105, 105, 105));
		setType(Type.POPUP);
		setResizable(false);
		setBounds(100, 100, 278, 73);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		progressBar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		progressBar.setBackground(new Color(105, 105, 105));
		progressBar.setForeground(new Color(169, 169, 169));
		progressBar.setIndeterminate(true);
		progressBar.setBounds(12, 34, 254, 27);
		
		getContentPane().add(progressBar);
		setLocationRelativeTo(null);
		lblProcessText.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
		lblProcessText.setHorizontalAlignment(SwingConstants.LEFT);
		lblProcessText.setForeground(new Color(255, 255, 255));
		lblProcessText.setBounds(12, 10, 254, 21);
		
		getContentPane().add(lblProcessText);
	}
}
