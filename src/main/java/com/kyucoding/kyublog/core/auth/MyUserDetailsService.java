package com.kyucoding.kyublog.core.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.kyucoding.kyublog.model.user.User;
import com.kyucoding.kyublog.model.user.UserRepository;
@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userPS = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Bad Credentials") // SecurityConfig에 failureHandler가 처리함
        );
        return new MyUserDetails(userPS);
    }
}