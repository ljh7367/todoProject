package org.example.todo.Schedule.Controller;

import lombok.RequiredArgsConstructor;
import org.example.todo.Schedule.Dto.ScheduleRequestDto;
import org.example.todo.Schedule.Dto.ScheduleResponseDto;
import org.example.todo.Schedule.Entity.ScheduleEntity;
import org.example.todo.Schedule.Service.ScheduleService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")

public class ScheduleController {

    private final ScheduleService scheduleService;

    // 일정생성
    @PostMapping
    public ResponseEntity<String> create(@RequestBody ScheduleRequestDto scheduleRequestDto) {
         scheduleService.createSchedule(scheduleRequestDto);

        return new ResponseEntity<>("일정이 생성되었습니다", HttpStatusCode.valueOf(201));
    }

    // 일정삭제
    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<String> delete(@PathVariable Long scheduleId)throws IllegalAccessException {
        scheduleService.deleteSchedule(scheduleId);

        return new ResponseEntity<>("일정이 삭제되었습니다.", HttpStatusCode.valueOf(200));
    }

    // 일정수정
    @PutMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> update(@RequestBody ScheduleRequestDto scheduleRequestDto, @PathVariable Long scheduleId){
        scheduleService.updateSchedule(scheduleId, scheduleRequestDto);
        ScheduleResponseDto update = scheduleService.updateSchedule(scheduleId, scheduleRequestDto);

        return new ResponseEntity<>(update, HttpStatusCode.valueOf(200));
    }

    //전체조회
    @GetMapping
    public ResponseEntity<List<ScheduleEntity>> findSchedules(){
        List<ScheduleEntity> scheduleEntityList = scheduleService.findAllSchedules();
    return new ResponseEntity<>(scheduleEntityList, HttpStatusCode.valueOf(200));
    }


    //단일 조회
    @GetMapping("/{scheduleId}")
    public ResponseEntity<Long> findOneSchedule(@PathVariable Long scheduleId) throws  IllegalAccessException{
        scheduleService.findById(scheduleId);
        return new ResponseEntity<>(scheduleId, HttpStatusCode.valueOf(200));

    }

}
