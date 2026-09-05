package com.andrewbui.identityservice.configuration;

import com.andrewbui.identityservice.entity.User;
import com.andrewbui.identityservice.enums.Role;
import com.andrewbui.identityservice.repository.RoleRepository;
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

import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Configuration
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(
            UserRepository userRepository,
            RoleRepository roleRepository,
            @Value("${ADMIN_PASSWORD}") String adminPassword) {
        return args -> {
           var adminRole = roleRepository.findById(Role.ADMIN.name())
                   .orElseGet(() -> roleRepository.save(com.andrewbui.identityservice.entity.Role.builder()
                           .name(Role.ADMIN.name())
                           .build()));

           if (userRepository.findByUsername("admin").isEmpty()) {
               User user = User.builder()
                       .username("admin")
                       .roles(Set.of(adminRole))
                       .password(passwordEncoder.encode(adminPassword))
                       .build();

               userRepository.save(user);
               log.warn("admin user has been created with default password");
            }
        };
    }
}
