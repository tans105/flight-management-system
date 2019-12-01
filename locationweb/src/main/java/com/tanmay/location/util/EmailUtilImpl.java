package com.tanmay.location.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author Tanmay
 * @date 01/12/19
 **/

@Component
public class EmailUtilImpl implements EmailUtil {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String toAddress, String subject, String body) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(toAddress);
            helper.setText(body);
            helper.setSubject(subject);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(message);
    }
}
