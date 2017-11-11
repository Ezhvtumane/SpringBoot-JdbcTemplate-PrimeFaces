package ogs.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component("ogsMailSender")
public class MailSender {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    public void sendMail(String from, String to, String subject, String body) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);

        try {
            System.out.println("Start testing of the connection...");
            javaMailSender.testConnection();
            System.out.println("Finish testing of the connection!");

            System.out.println("Start send...");
            javaMailSender.send(simpleMailMessage);
            System.out.println("Done!");
        }
        catch (MessagingException exp){
            System.out.println("Can't connect to server: " + exp);
        }
        finally {
            System.out.println("Finished send mail. Anyway.");
        }

    }
}
