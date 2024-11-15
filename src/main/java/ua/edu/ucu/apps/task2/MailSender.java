package ua.edu.ucu.apps.task2;


import lombok.AllArgsConstructor;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

@AllArgsConstructor
public class MailSender {
  public final String apiKey;
  public final String apiSecret;
  public final String hostEmail;


  public void sendMail(MailInfo mailInfo) {
    Properties props = new Properties();
    props.put("mail.smtp.host", "in-v3.mailjet.com");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    Authenticator auth = new Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(apiKey, apiSecret);
      }
    };
    Session session = Session.getInstance(props, auth);

    try {
      // Create a message with the specified attributes
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress("hostEmail"));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailInfo.getClientEmail()));
      message.setSubject("ТЦК");
      message.setText(mailInfo.generate());

      // Send the message
      Transport.send(message);
      System.out.println("Email sent successfully.");

    } catch (MessagingException e) {
      e.printStackTrace();
      System.out.println("Error sending email: " + e.getMessage());
    }
  }
}