package com.sharedevvoyage.javablogsample.api.board.controller;

import com.sharedevvoyage.javablogsample.api.board.dto.BoardRequestDto;
import com.sharedevvoyage.javablogsample.api.board.dto.SelectBoardPageResponseDto;
import com.sharedevvoyage.javablogsample.api.board.dto.SelectBoardResponseDto;
import com.sharedevvoyage.javablogsample.api.board.service.BoardApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
public class BoardApplicationController {

    private final BoardApplicationService boardApplicationService;


    @PostMapping
    public ResponseEntity<Long> createBoard(@RequestBody BoardRequestDto requestDto) {
        return ResponseEntity.ok(boardApplicationService.createBoard(requestDto));
    }

    @GetMapping()
    public ResponseEntity<List<SelectBoardPageResponseDto>> getBoardPage() {
        return ResponseEntity.ok(boardApplicationService.getBoardPage());
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<SelectBoardResponseDto> getBoard(@PathVariable Long boardId) {
        return ResponseEntity.ok(boardApplicationService.getBoard(boardId));
    }

    @PatchMapping("/{boardId}")
    public ResponseEntity<Long> updateBoard(@PathVariable Long boardId, @RequestBody BoardRequestDto requestDto) {
        return ResponseEntity.ok(boardApplicationService.updateBoard(boardId, requestDto));
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<String> deleteBoard(@PathVariable Long boardId) {
        return ResponseEntity.ok(boardApplicationService.deleteBoard(boardId));
    }

    @PostMapping("/{boardId}/comment")
    public ResponseEntity<Long> createParentComment(@PathVariable Long boardId, @RequestBody String content) {
        return ResponseEntity.ok(boardApplicationService.createParentComment(content, boardId));
    }

    @PostMapping("/{boardId}/comment/{commentId}")
    public ResponseEntity<Long> createChildComment(@PathVariable Long boardId, @PathVariable Long commentId, @RequestBody String content) {
        return ResponseEntity.ok(boardApplicationService.createChildComment(content, boardId, commentId));
    }
}
