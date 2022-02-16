package com.example.demo.config;

import com.example.demo.models.user.User;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return  args -> {
            User mariam = new User(
                    "Mariam",
                    25,
                    "maria@gmail.com"
            );

            User alex = new User(
                    "Alex",
                    28,
                    "alex@gmail.com"
            );

            userRepository.saveAll(List.of(mariam,alex));
        };
    }
}
