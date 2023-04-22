package com.kyucoding.kyublog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {

    //RestAPI 주소 설계 규칙에서 자원은 원래 복수로 씀. boards가 정석. but 팀의 컨벤션을 따르기.
    @GetMapping({"/", "/board"})
    public  String main(){
        return "board/main";
    }
}
