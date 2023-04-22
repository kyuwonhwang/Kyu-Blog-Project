package com.kyucoding.kyublog;

import com.kyucoding.kyublog.model.user.User;
import com.kyucoding.kyublog.model.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class KyublogApplication {

    @Bean @Profile("dev")
    CommandLineRunner init(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        return args -> { //더미 데이터
            User ssar = User.builder()
                    .username("ssar")
                    .password(passwordEncoder.encode("1234"))
                    .email("ssar@nate.com")
					.role("USER")
                    .profile("person.png")
                    .status(true)
                    .build();
            userRepository.save(ssar);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(KyublogApplication.class, args);
    }

}
