package by.bsuir.semenchik.logic.mail;

import by.bsuir.semenchik.logic.entity.Book;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailSender {

    private String from = "semenchik.polina@mail.ru";       // receiver email
    private String host = "127.0.0.1";            // mail server host

    public void sendMessage(String receiver, Book book) {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(properties); // default session

        try {
            MimeMessage message = new MimeMessage(session); // email message

            message.setFrom(new InternetAddress(from)); // setting header fields
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));

            message.setSubject("New book added!"); // subject line
            message.setText("Book " + book.toString() + "added to the catalog");

            Transport.send(message);

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}