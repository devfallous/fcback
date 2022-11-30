package com.Foodcourt.fc.service;

import com.Foodcourt.fc.dto.EmailDTO;

public interface EmailService
{
    public boolean send(EmailDTO emailDTO);
}
