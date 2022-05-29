package com.example.novichat2022.Post;
import com.example.novichat2022.appuser.AppUser;
import com.example.novichat2022.appuser.AppUserRepository;
import com.example.novichat2022.appuser.AppUserRole;
import com.example.novichat2022.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
public class PostConfig {
    @Bean
    CommandLineRunner userCommandLineRunner(AppUserRepository appUserRepository) {
        return args -> {
            Post post= new Post("eerste post");
        };
    }
}
