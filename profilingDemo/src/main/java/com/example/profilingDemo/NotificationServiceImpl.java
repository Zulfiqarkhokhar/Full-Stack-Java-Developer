package com.example.profilingDemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile(value = "prod")
public class NotificationServiceImpl implements NotificationService{
    @Override
    public String send() {
        return "Notification sent";
    }
}
