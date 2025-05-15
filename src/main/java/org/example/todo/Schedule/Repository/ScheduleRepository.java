package org.example.todo.Schedule.Repository;

import org.example.todo.Schedule.Entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
}
