package org.example.todo.Comment.Dto;

import lombok.Getter;
import org.example.todo.Comment.Entity.CommentEntity;

import java.time.LocalDateTime;

@Getter

public class CommentResponseDto {

    private final Long id;
    private final String title;
    private final String contents;
    private final LocalDateTime createTime;
    private final LocalDateTime updatedTime;

    public CommentResponseDto(Long id, String title, String contents, LocalDateTime createTime, LocalDateTime updatedTime) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.createTime = createTime;
        this.updatedTime = updatedTime;
    }

    public CommentResponseDto(CommentEntity entity) {
        this.id = entity.getCommentId();
        this.title = entity.getTitle();
        this.contents = entity.getContents();
        this.createTime = entity.getCreateTime();
        this.updatedTime = entity.getUpdatedTime();

    }
}
