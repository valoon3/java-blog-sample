package com.sharedevvoyage.javablogsample.api.board.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(
        name = "board",
        indexes = {

        }
)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    public static Board create(String title, String content) {
        Board board = new Board();
        board.title = title;
        board.content = content;
        return board;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
