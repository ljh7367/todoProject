package org.example.todo.Comment.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CommentRequestDto {

    @NotBlank
    private String title;

    @NotBlank
    private String contents;
}
