package com.sharedevvoyage.javablogsample.api.board.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(
        name = "comment",
        indexes = {

        }
)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    /**
     * commentId 와 parentCommentId 가 같은 경우는 parentComment
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Comment parent;

    public static Comment createParentComment(String content, Board board) {
        Comment comment = new Comment();
        comment.content = content;
        comment.isDeleted = false;
        comment.board = board;
        comment.parent = comment;
        return comment;
    }

    public static Comment createChildComment(String content, Board board, Comment parentComment) {
        Comment childComment = new Comment();
        childComment.content = content;
        childComment.isDeleted = false;
        childComment.board = board;
        childComment.parent = parentComment;
        return childComment;
    }

    public void update(String content) {
        this.content = content;
    }

}
