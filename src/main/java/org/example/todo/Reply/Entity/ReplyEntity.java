package org.example.todo.Reply.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import org.example.todo.Reply.Dto.ReplyRequestDto;

import java.time.LocalDateTime;

@Entity
@Getter

public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long replyId;
    private String contents;
    private LocalDateTime createTime;
    private LocalDateTime updatedTime;

    @Builder
    public ReplyEntity(Long replyId, String contents, LocalDateTime createTime, LocalDateTime updatedTime){
        this.replyId = replyId;
        this.contents = contents;
        this.createTime = createTime;
        this.updatedTime = updatedTime;
    }

    public ReplyEntity(ReplyRequestDto replyRequestDto) {

    }

    public void update(ReplyRequestDto dto){
        this.contents = dto.getContents();
        this.updatedTime = LocalDateTime.now();
    }
}
