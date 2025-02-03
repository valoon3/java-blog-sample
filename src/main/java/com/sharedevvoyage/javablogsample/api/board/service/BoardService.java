package com.sharedevvoyage.javablogsample.api.board.service;

import com.sharedevvoyage.javablogsample.api.board.dto.CreateBoardRequestDto;
import com.sharedevvoyage.javablogsample.api.board.entity.Board;
import com.sharedevvoyage.javablogsample.api.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long createBoard(CreateBoardRequestDto requestDto) {
        Board board = Board.create(requestDto.getTitle(), requestDto.getContent());
        return boardRepository.save(board).getBoardId();
    }
}
