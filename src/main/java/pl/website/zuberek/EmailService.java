package pl.website.zuberek;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Properties; //"hasło do aplikacji zjrlsymuhxwtqdzq

@Service
public class EmailService {
    JavaMailSender jms;

    public EmailService() {
        JavaMailSenderImpl jmsw = new JavaMailSenderImpl();
        jmsw.setHost("smtp.gmail.com");
        jmsw.setPort(587);
        jmsw.setUsername("zuberekpl2115@gmail.com"); //tu nowy mail
        jmsw.setPassword("zjrlsymuhxwtqdzq");

        Properties properties = jmsw.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true");
        jms = jmsw;
    }

    void sendEmail(String to, String subject, String mail) {
        MimeMessage message = jms.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, "utf-8");

        try {
            messageHelper.setTo(to);
            messageHelper.setText(mail);
            messageHelper.setSubject(subject);
            messageHelper.setFrom("zuberekpl2115@gmail.com"); //mój email
            jms.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}