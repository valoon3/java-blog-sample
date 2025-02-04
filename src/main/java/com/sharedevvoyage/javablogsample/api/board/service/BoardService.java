package com.sharedevvoyage.javablogsample.api.board.service;

import com.sharedevvoyage.javablogsample.api.board.dto.BoardRequestDto;
import com.sharedevvoyage.javablogsample.api.board.dto.SelectBoardPageResponseDto;
import com.sharedevvoyage.javablogsample.api.board.dto.SelectBoardResponseDto;
import com.sharedevvoyage.javablogsample.api.board.entity.Board;
import com.sharedevvoyage.javablogsample.api.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Long createBoard(BoardRequestDto requestDto) {
        Board board = Board.create(requestDto.getTitle(), requestDto.getContent());
        return boardRepository.save(board).getBoardId();
    }

    public SelectBoardResponseDto getBoard(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("Board not found"));

        return new SelectBoardResponseDto(board);
    }

    public List<SelectBoardPageResponseDto> getBoardPage() {
        List<Board> boards = boardRepository.findAll();

        return boards.stream()
                .map(SelectBoardPageResponseDto::new)
                .toList();
    }

    public Long updateBoard(Long boardId, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("Board not found"));

        board.update(requestDto.getTitle(), requestDto.getContent());

        return boardRepository.save(board).getBoardId();
    }

    public String deleteBoard(Long boardId) {
        boardRepository.deleteById(boardId);

        return "success";
    }

}
