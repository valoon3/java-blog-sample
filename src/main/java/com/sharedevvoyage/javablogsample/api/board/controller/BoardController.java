package com.sharedevvoyage.javablogsample.api.board.controller;

import com.sharedevvoyage.javablogsample.api.board.dto.CreateBoardRequestDto;
import com.sharedevvoyage.javablogsample.api.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
public class BoardController {

    private final BoardService boardService;


    @PostMapping
    public ResponseEntity<Long> createBoard(@RequestBody CreateBoardRequestDto requestDto) {
        return ResponseEntity.ok(boardService.createBoard(requestDto));
    }
}
