package org.example.todo.Schedule.Service;


import lombok.RequiredArgsConstructor;
import org.example.todo.Schedule.Dto.ScheduleRequestDto;
import org.example.todo.Schedule.Dto.ScheduleResponseDto;
import org.example.todo.Schedule.Entity.ScheduleEntity;
import org.example.todo.Schedule.Repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;


    // 일정 생성
    @Transactional
    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto){
        ScheduleEntity scheduleEntity = new ScheduleEntity(scheduleRequestDto);
        ScheduleEntity savedScheduleEntity = scheduleRepository.save(scheduleEntity);

        return new ScheduleResponseDto(savedScheduleEntity);
    }


    // 일정 삭제
    public void deleteSchedule(Long scheduleId) throws IllegalAccessException {
        ScheduleEntity scheduleEntity = scheduleRepository.findById(scheduleId).orElseThrow();
        scheduleRepository.delete(scheduleEntity);
    }


    // 일정 수정
    @Transactional
    public ScheduleResponseDto updateSchedule(Long scheduleId, ScheduleRequestDto scheduleRequestDto){
        ScheduleEntity scheduleEntity = scheduleRepository.findById(scheduleId).orElseThrow();
        scheduleEntity.update(scheduleRequestDto);

        return new ScheduleResponseDto(scheduleEntity);
    }


    // 일정 조회
    public List<ScheduleEntity> findAllSchedules() {

        return scheduleRepository.findAll();
    }


    // 특정 일정 조회
    public ScheduleEntity findById(Long scheduleId) throws IllegalAccessException {
        return scheduleRepository.findById(scheduleId).orElseThrow();
    }


    }

