package com.sharedevvoyage.javablogsample.api.board.dto;

import com.sharedevvoyage.javablogsample.api.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SelectBoardResponseDto {
    private Long boardId;
    private String title;
    private String content;

    public SelectBoardResponseDto(Board board) {
        this.boardId = board.getBoardId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
