package com.sharedevvoyage.javablogsample.api.board.dto;

import com.sharedevvoyage.javablogsample.api.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SelectBoardPageResponseDto {
    private Long boardId;
    private String title;
    private String content;

    public SelectBoardPageResponseDto(Board board) {
        this.boardId = board.getBoardId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
