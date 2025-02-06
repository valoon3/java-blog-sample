package com.sharedevvoyage.javablogsample.api.board.repository;

import com.sharedevvoyage.javablogsample.api.board.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
