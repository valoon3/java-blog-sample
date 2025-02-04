package com.sharedevvoyage.javablogsample.api.board.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequestDto {
    private String title;
    private String content;
}
