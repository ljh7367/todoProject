package org.example.todo.Reply.Dto;

import lombok.Getter;
import org.example.todo.Reply.Entity.ReplyEntity;

import java.time.LocalDateTime;

@Getter

public class ReplyResponseDto {

    private final Long id;
    private final String contents;
    private final LocalDateTime createTime;
    private final LocalDateTime updatedTime;

    public ReplyResponseDto(Long id, String contents, LocalDateTime createTime, LocalDateTime updatedTime){
        this.id = id;
        this.contents = contents;
        this.createTime = createTime;
        this.updatedTime = updatedTime;
    }

    public ReplyResponseDto(ReplyEntity entity){
        this.id = entity.getReplyId();
        this.contents = entity.getContents();
        this.createTime = entity.getCreateTime();
        this.updatedTime = entity.getUpdatedTime();
    }
}

