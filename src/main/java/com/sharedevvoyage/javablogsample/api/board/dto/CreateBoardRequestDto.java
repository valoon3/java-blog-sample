package com.sharedevvoyage.javablogsample.api.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CreateBoardRequestDto {
    private String title;
    private String content;
}
