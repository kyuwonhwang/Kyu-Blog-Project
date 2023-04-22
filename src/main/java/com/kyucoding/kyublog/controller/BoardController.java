package com.kyucoding.kyublog.controller;

import com.kyucoding.kyublog.core.auth.MyUserDetails;
import com.kyucoding.kyublog.dto.board.BoardRequest;
import com.kyucoding.kyublog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    //RestAPI 주소 설계 규칙에서 자원은 원래 복수로 씀. boards가 정석. but 팀의 컨벤션을 따르기.
    @GetMapping({"/", "/board"})
    public  String main(){
        return "board/main";
    }

    @GetMapping("/s/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }

    @PostMapping("/s/board/save")
    public String save(BoardRequest.SaveInDTO saveInDTO, @AuthenticationPrincipal MyUserDetails myUserDetails){
        boardService.글쓰기(saveInDTO, myUserDetails.getUser().getId());
        return "redirect:/";
    }
}
