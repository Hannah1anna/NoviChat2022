package com.example.novichat2022.appuser;

import com.example.novichat2022.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class AppUserConfig {
    private final PasswordEncoder encoder;

    @Bean
    CommandLineRunner userCommandLineRunner(AppUserRepository appUserRepository) {
        return args -> {
            AppUser mod = new AppUser("AppMod", encoder.bCryptPasswordEncoder().encode("pass"), AppUserRole.MOD, false, true);
            AppUser appUser = new AppUser("AppUser", encoder.bCryptPasswordEncoder().encode("pass2"), AppUserRole.USER, false, true);
            appUserRepository.save(mod);
            appUserRepository.save(appUser);
        };
    }
}
