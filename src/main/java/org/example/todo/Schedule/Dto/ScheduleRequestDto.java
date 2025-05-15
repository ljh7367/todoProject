package org.example.todo.Schedule.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleRequestDto {

    @NotBlank
    private String title;
    @NotBlank
    private String contents;

}
