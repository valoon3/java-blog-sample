package com.sharedevvoyage.javablogsample.api.board.repository;

import com.sharedevvoyage.javablogsample.api.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
