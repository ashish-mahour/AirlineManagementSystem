package com.ams.customdialogs;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JProgressBar;
import java.awt.Cursor;
import java.awt.Toolkit;

public class WaitingDialog extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JProgressBar progressBar = new JProgressBar();

	
	/**
	 * Create the frame.
	 */
	public WaitingDialog(String title) {
		setTitle(title);
		initGUI();
	}
	private void initGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(WaitingDialog.class.getResource("/images/planeIcon.png")));
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		getContentPane().setBackground(new Color(240, 255, 255));
		setType(Type.POPUP);
		setResizable(false);
		setBounds(100, 100, 278, 88);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		progressBar.setForeground(new Color(50, 205, 50));
		progressBar.setIndeterminate(true);
		progressBar.setBounds(10, 11, 242, 27);
		
		getContentPane().add(progressBar);
		setLocationRelativeTo(null);
	}
}
