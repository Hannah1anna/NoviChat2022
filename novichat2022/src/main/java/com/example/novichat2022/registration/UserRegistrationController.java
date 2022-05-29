package com.example.novichat2022.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/registration")
@AllArgsConstructor
public class UserRegistrationController {
    private UserRegistrationService userRegistrationService;
    @PostMapping
    public String register(@RequestBody UserRegistrationRequest request) {
        return UserRegistrationService.register(request);
    }
}
