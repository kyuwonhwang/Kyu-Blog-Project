package com.kyucoding.kyublog;

import com.kyucoding.kyublog.model.user.User;
import com.kyucoding.kyublog.model.user.UserRepository;
import com.kyucoding.kyublog.model.board.BoardRepository;
import com.kyucoding.kyublog.model.board.Board;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.*;

@SpringBootApplication
public class KyublogApplication {

    @Bean
    CommandLineRunner init(BCryptPasswordEncoder passwordEncoder, UserRepository userRepository, BoardRepository boardRepository) {
        return args -> {
            User ssar = User.builder()
                    .username("ssar")
                    .password(passwordEncoder.encode("1234"))
                            .email("ssar@nate.com")
                    .role("USER")
                    .profile("person.png")
                    .build();
            User cos = User.builder()
                    .username("cos")
                    .password(passwordEncoder.encode("1234"))
                    .email("cos.nate.com")
                    .role("USER")
                    .profile("person.png")
                    .build();
            userRepository.saveAll(Arrays.asList(ssar, cos));
            Board b1 = Board.builder()
                    .title("제목1")
                    .content("내용1")
                            .user(ssar)
                            .thumbnail("/upload/person.png")
                    .build();
            Board b2 = Board.builder()
                    .title("제목2")
                            .content("내용2")
                            .user(cos)
                            .thumbnail("/upload/person.png")
                    .build();
            boardRepository.saveAll(Arrays.asList(b1, b2));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(KyublogApplication.class, args);
    }

}
