package org.example.todo.Schedule.Dto;

import lombok.Getter;
import org.example.todo.Schedule.Entity.ScheduleEntity;

import java.time.LocalDateTime;

@Getter

public class ScheduleResponseDto {

    private final Long id;
    private final String title;
    private final String contents;
    private final Long writer_id;
    private final LocalDateTime createTime;
    private final LocalDateTime updatedTime;

    public ScheduleResponseDto(Long id, String title, String contents, Long writer_id, LocalDateTime createTime, LocalDateTime updatedTime){
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.writer_id = writer_id;
        this.createTime = createTime;
        this.updatedTime = updatedTime;
    }
    public ScheduleResponseDto(ScheduleEntity entity) {
        this.id = entity.getScheduleId();
        this.title = entity.getTitle();
        this.contents = entity.getContents();
        this.writer_id = entity.getWriterId();
        this.createTime = entity.getCreateTime();
        this.updatedTime = entity.getUpdatedTime();
    }

}
