package com.example.mm;

import com.example.mm.entities.User;
import com.example.mm.repositores.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if (userRepository.findByLogin("admin") == null) {
            var newUser = new User();
            newUser.setEmail("admin@admin.com");
            newUser.setLogin("admin");
            newUser.setFullName("Administrator");
            newUser.setRole("ADMIN");
            newUser.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin"));

            userRepository.save(newUser);
        }
    }
}