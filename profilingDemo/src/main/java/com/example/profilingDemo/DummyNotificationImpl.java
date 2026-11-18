package com.example.profilingDemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile(value = {"stagging","default","dev","local"})
public class DummyNotificationImpl implements NotificationService{
    @Override
    public String send() {
        return "Dummy notification sent";
    }
}
