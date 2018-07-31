package com.ams.model;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.ams.activities.MainActivity;
import com.ams.customdialogs.VerifingOTP;
import com.ams.customdialogs.WaitingDialog;

public class SendMail {
	private static String username = "demoacc61195@gmail.com";
	private static String password = "ashish_mahour";
	private static WaitingDialog sendingDialog;
	private JFrame targetFrame,currentFrame;

	public SendMail(final String title, JFrame currentFrame, JFrame targetFrame) {
		this.currentFrame = currentFrame;
		this.targetFrame = targetFrame;
		// TODO Auto-generated constructor stub
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				sendingDialog = new WaitingDialog(title);
				sendingDialog.setVisible(true);

			}
		});
		t.setPriority(Thread.MAX_PRIORITY);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public boolean send(final String reciversMail,final String mailSubject,final String mailBody) {
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				Properties properties = new Properties();
				properties.put("mail.smtp.starttls.enable", "true");
				properties.put("mail.smtp.auth", "true");
				properties.put("mail.smtp.host", "smtp.gmail.com");
				properties.put("mail.smtp.port", "587");

				Session session = Session.getInstance(properties, new Authenticator() {

					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						// TODO Auto-generated method stub
						return new PasswordAuthentication(username, password);
					}

				});

				final Message message = new MimeMessage(session);
				try {
					message.setFrom(new InternetAddress(username));
					message.setRecipient(RecipientType.TO, new InternetAddress(reciversMail));
					message.setSubject(mailSubject);
					message.setText(mailBody);
					Transport.send(message);
					sendingDialog.dispose();
					JOptionPane.showMessageDialog(currentFrame, "OTP Sent to " +reciversMail, "Alert - AMS",
							JOptionPane.INFORMATION_MESSAGE);
					currentFrame.dispose();
					targetFrame.setVisible(true);
					if(targetFrame instanceof VerifingOTP) {
						((VerifingOTP) targetFrame).doProgress();
						targetFrame.dispose();
						new MainActivity().show();
					}
				} catch (AddressException e) {
					sendingDialog.dispose();
					JOptionPane.showMessageDialog(currentFrame, e.getMessage(), "Alert - AMS",
							JOptionPane.INFORMATION_MESSAGE);
					currentFrame.dispose();
				} catch (MessagingException e) {
					sendingDialog.dispose();
					JOptionPane.showMessageDialog(currentFrame, e.getMessage(), "Alert - AMS",
							JOptionPane.INFORMATION_MESSAGE);
					currentFrame.dispose();
				}

			}
		});
		t2.setPriority(Thread.MIN_PRIORITY);
		t2.start();
		return true;
	}
}
