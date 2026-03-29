package demo.mail;

import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class EmailSender {

	public static void main(String[] args) {

		String senderEmail = "your_email@gmail.com"; // Replace with your Sender email
		String appPassword = "your_app_password"; // Replace with app password
		String recipientEmail = "your_email@gmail.com"; // Replace with your recipient email

		// SMTP server properties
		Properties prop = new Properties();

		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.port", "587");

		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, appPassword);

			}
		});
		session.setDebug(true);

		try {
			// Create the email message object
			Message message = new MimeMessage(session);

			// Set sender, recipient, and subject
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
			message.setSubject("Test Email from QA Automation");

			// Create email body (text content)
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText("Hi Team,\nThis is an auto-generated test email from Java. \n\nThanks,\nQA Team");

			// Prepare attachment file
			String filepath = System.getProperty("user.dir") + "/ExtentReport/ExtentReport.html";
			// Example: Change folder/file name if your report is stored elsewhere
			System.out.println("Attachment path: " + filepath);

			// Validate file existence
			File file = new File(filepath);

			if (!file.exists()) {
				System.out.println("File not found: " + filepath);
				return;
			}

			// Attach the file
			MimeBodyPart attachmentPart = new MimeBodyPart();

			attachmentPart.attachFile(file);

			// Combine text and attachment into a multipart email
			MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(textPart);
			multipart.addBodyPart(attachmentPart);

			// Set email content
			message.setContent(multipart);

			// send Email
			Transport.send(message);
			System.out.println("Email sent successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
