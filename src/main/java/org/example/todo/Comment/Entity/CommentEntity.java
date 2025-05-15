package org.example.todo.Comment.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import org.example.todo.Comment.Dto.CommentRequestDto;
import org.example.todo.Schedule.Dto.ScheduleRequestDto;

import java.time.LocalDateTime;

@Entity
@Getter

public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long commentId;
    private String title;
    private String contents;
    private LocalDateTime createTime;
    private LocalDateTime updatedTime;

    @Builder
    public CommentEntity(Long commentId,String title, String contents,LocalDateTime createTime,LocalDateTime updatedTime){
        this.commentId = commentId;
        this.title = title;
        this.contents = contents;
        this.createTime = createTime;
        this.updatedTime = updatedTime;
    }

    public CommentEntity() {

    }

    public void update(ScheduleRequestDto dto) {
        this.title = dto.getTitle();
        this.contents = dto.getContents();
        this.updatedTime = LocalDateTime.now();
    }
    public CommentEntity(CommentRequestDto commentRequestDto) {

    }

    public void update(CommentRequestDto commentRequestDto) {
    }
}
