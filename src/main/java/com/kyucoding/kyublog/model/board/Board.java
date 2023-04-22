package com.kyucoding.kyublog.model.board;

import lombok.*;
import javax.persistence.*;
import com.kyucoding.kyublog.model.user.User;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "board_tb")
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    private String title;
    @Lob //4GB
    private String content;
    @Lob //4GB
    private String thumbnail; // content에 등록된 사진들 중 하나를 임의로 선정해서 자동으로 섬네일 만들기
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
