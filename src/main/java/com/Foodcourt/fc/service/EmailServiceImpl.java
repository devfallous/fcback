package com.Foodcourt.fc.service;

import com.Foodcourt.fc.dto.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailServiceImpl implements  EmailService
{
    @Autowired
    JavaMailSender mail;
    @Override
    public boolean send(EmailDTO emailDTO)
    {
        SimpleMailMessage message =new SimpleMailMessage();
        message.setTo(emailDTO.getTo());
        message.setSubject(emailDTO.getSubject());
        message.setText(emailDTO.getBody());
        boolean isSent=false;
        try
        {
            mail.send(message);
            isSent=true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return isSent;
    }
}
