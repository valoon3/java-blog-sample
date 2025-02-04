package com.sharedevvoyage.javablogsample.api.board.controller;

import com.sharedevvoyage.javablogsample.api.board.dto.BoardRequestDto;
import com.sharedevvoyage.javablogsample.api.board.dto.SelectBoardPageResponseDto;
import com.sharedevvoyage.javablogsample.api.board.dto.SelectBoardResponseDto;
import com.sharedevvoyage.javablogsample.api.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
public class BoardController {

    private final BoardService boardService;


    @PostMapping
    public ResponseEntity<Long> createBoard(@RequestBody BoardRequestDto requestDto) {
        return ResponseEntity.ok(boardService.createBoard(requestDto));
    }

    @GetMapping()
    public ResponseEntity<List<SelectBoardPageResponseDto>> getBoardPage() {
        return ResponseEntity.ok(boardService.getBoardPage());
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<SelectBoardResponseDto> getBoard(@PathVariable Long boardId) {
        return ResponseEntity.ok(boardService.getBoard(boardId));
    }

    @PatchMapping("/{boardId}")
    public ResponseEntity<Long> updateBoard(@PathVariable Long boardId, @RequestBody BoardRequestDto requestDto) {
        return ResponseEntity.ok(boardService.updateBoard(boardId, requestDto));
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<String> deleteBoard(@PathVariable Long boardId) {
        return ResponseEntity.ok(boardService.deleteBoard(boardId));
    }
}
