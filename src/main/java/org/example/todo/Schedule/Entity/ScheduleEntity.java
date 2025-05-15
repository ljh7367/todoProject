package org.example.todo.Schedule.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.todo.Schedule.Dto.ScheduleRequestDto;


import java.time.LocalDateTime;


@Getter @Setter
@Entity

public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long scheduleId;

    private String title;
    private String contents;
    private Long writerId;
    private LocalDateTime createTime;
    private LocalDateTime updatedTime;

    @Builder
    public ScheduleEntity(Long scheduleId, String title, String contents, Long writerId, LocalDateTime createTime, LocalDateTime updatedTime) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.contents = contents;
        this.writerId = writerId;
        this.createTime = createTime;
        this.updatedTime = updatedTime;
    }

    public ScheduleEntity(ScheduleRequestDto scheduleRequestDto) {
        this.title = scheduleRequestDto.getTitle();
        this.contents = scheduleRequestDto.getContents();
        this.createTime = LocalDateTime.now();
        this.updatedTime = LocalDateTime.now();
    }

    public void update(ScheduleRequestDto dto) {
        this.title = dto.getTitle();
        this.contents = dto.getContents();
        this.updatedTime = LocalDateTime.now();
    }


    public ScheduleEntity() {

    }
}
