package com.kyucoding.kyublog.dto.board;

import com.kyucoding.kyublog.model.board.Board;
import com.kyucoding.kyublog.model.user.User;
import lombok.Getter;
import lombok.Setter;

public class BoardRequest {
    @Getter @Setter
    public static class SaveInDTO{
        private String title;
        private String content;


        public Board toEntity(User user){
            return Board.builder()
                    .user(user)
                    .title(title)
                    .content(content)
                    .thumbnail(null)
                    .build();
        }
    }
}
