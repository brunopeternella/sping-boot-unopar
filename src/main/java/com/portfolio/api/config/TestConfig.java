package com.portfolio.api.config;

import com.portfolio.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.portfolio.api.repositories.IUserRepository;

import java.util.Arrays;

public class TestConfig implements CommandLineRunner {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    IUserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(1, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(2, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
