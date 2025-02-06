package com.sharedevvoyage.javablogsample.api.board.service;

import com.sharedevvoyage.javablogsample.api.board.entity.Board;
import com.sharedevvoyage.javablogsample.api.board.entity.Comment;
import com.sharedevvoyage.javablogsample.api.board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;


    public Long createParentComment(String content, Board board) {
        Comment comment = Comment.createParentComment(content, board);
        commentRepository.save(comment);

        return comment.getCommentId();
    }

    public Long createChildComment(Long parentCommentId, String content, Board board) {
        Comment parentComment = commentRepository.findById(parentCommentId)
                .orElseThrow(() -> new IllegalArgumentException("Parent comment not found"));

        Comment comment = Comment.createParentComment(content, parentComment.getBoard());
        commentRepository.save(comment);

        return comment.getCommentId();
    }

}
