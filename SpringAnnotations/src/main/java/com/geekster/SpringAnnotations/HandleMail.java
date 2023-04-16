package com.geekster.SpringAnnotations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HandleMail {
    @Autowired
    Student s1;

    public void sendMail() {
        // host : gmail is smtp :
        // String host = "smtp.gmail.com";

        Properties props = System.getProperties();

        System.out.println(props);


        // set properties

        props.put("mail.smtp.host", "smtp.gmail.com");
        // host/ protocol
        props.put("mail.smtp.port", 465);
        // port no. for 465
        props.put("mail.smtp.ssl.enable", "true");
        // enable connection with gmail
        props.put("mail.smtp.auth", "true");
        // for authentication


        // session
        Session mailSession = Session.getInstance(props, new MailAuthenticator());


        // create the message object
        MimeMessage mimeMessage = new MimeMessage(mailSession);
        try {
            // sender
            mimeMessage.setFrom(MailConstants.SENDER);

            // receiver
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(MailConstants.RECEIVERMAILADDRESS));

            // subject
            mimeMessage.setSubject(MailConstants.SUBJECT);

            // message
            mimeMessage.setText(s1.toString());

            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
