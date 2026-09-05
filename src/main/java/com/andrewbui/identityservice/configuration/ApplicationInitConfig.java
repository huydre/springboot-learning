package com.andrewbui.identityservice.configuration;

import com.andrewbui.identityservice.entity.User;
import com.andrewbui.identityservice.enums.Role;
import com.andrewbui.identityservice.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Configuration
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(
            UserRepository userRepository,
            @Value("${ADMIN_PASSWORD}") String adminPassword) {
        return args -> {
           var roles = new HashSet<String>();
           roles.add(Role.ADMIN.name());

           if (userRepository.findByUsername("admin").isEmpty()) {
               User user = User.builder()
                       .username("admin")
                       .roles(roles)
                       .password(passwordEncoder.encode(adminPassword))
                       .build();

               userRepository.save(user);
               log.warn("admin user has been created with default password");
            }
        };
    }
}
