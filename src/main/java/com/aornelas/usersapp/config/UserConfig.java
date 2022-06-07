package com.aornelas.usersapp.config;

import com.aornelas.usersapp.domain.User;
import com.aornelas.usersapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User mario = new User(
                "Mario",
                "Lopez",
                "mario.lopez@gmail.com",
                LocalDate.of(1997, Month.JANUARY, 5),
                "6623568910",
                "hola123456"
            );

            User patricia = new User(
                "Paty",
                "Ung",
                "paty.ung@gmail.com",
                LocalDate.of(1997, Month.JANUARY, 5),
                "6623569874",
                "hola123456"
            );

            List<User> usersToAdd = new ArrayList<>();
            usersToAdd.add(mario);
            usersToAdd.add(patricia);

            userRepository.saveAll(usersToAdd);
        };
    }
}
