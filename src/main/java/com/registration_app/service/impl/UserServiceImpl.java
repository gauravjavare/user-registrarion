package com.registration_app.service.impl;

import com.registration_app.entity.User;
import com.registration_app.repository.UserRepository;
import com.registration_app.service.UserService;
import com.registration_app.utils.EmailService;
import com.registration_app.utils.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private EmailService emailService;
    @Autowired
    private OtpService otpService;

    private Map<String, String> otpStorage = new HashMap<>();

    @Override
    public User registerUser(User user) {
        String randomId = UUID.randomUUID().toString();
        user.setUserId(randomId);
        String otp = otpService.generateOTP();
        emailService.sendVerificationEmail(user.getEmail(), otp);
        otpStorage.put(user.getEmail(), otp);

        if (verifyOtp(user.getEmail(),otp) && user.getPassword().equals(user.getReEnterPassword())) {
            userRepo.save(user);
        }

        return user;
    }

    public boolean verifyOtp(String toEmail, String otp) {
        String storedOtp = otpStorage.get(toEmail);
        return storedOtp != null && storedOtp.equals(otp);
    }
}
