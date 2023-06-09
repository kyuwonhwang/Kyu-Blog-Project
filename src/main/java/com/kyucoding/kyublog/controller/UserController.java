package com.kyucoding.kyublog.controller;

import com.kyucoding.kyublog.dto.user.UserRequest;
import com.kyucoding.kyublog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private  final UserService userService;

    //인증이 되지 않은 상태에서 인증과 관련된 주소는 앞에 엔티티 적지 않기.
    // write (post) : /리소스/식별자(pk, uk)/save or delete or update
    // read (get) : /리소스/식별자(pk, uk)
    @PostMapping("/join")
    public String join(UserRequest.JoinInDTO joinInDTO){ // x-www-from-urlencoded
        userService.회원가입(joinInDTO);
        return "redirect:/loginForm"; //302
    }
    @GetMapping("/joinForm")
    public String joinForm(){
        return "user/joinForm";
    }
    @GetMapping("/loginForm")
    public String loginForm(){
        return "user/loginForm";
    }
}
