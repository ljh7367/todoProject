package org.example.todo.Comment.Controller;

import lombok.RequiredArgsConstructor;
import org.example.todo.Comment.Dto.CommentRequestDto;
import org.example.todo.Comment.Dto.CommentResponseDto;
import org.example.todo.Comment.Entity.CommentEntity;
import org.example.todo.Comment.Service.CommentService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")

public class CommentController {

    private final CommentService commentService;

    // 코멘트 생성
    @PostMapping
    public ResponseEntity<String> create(@RequestBody CommentRequestDto commentRequestDto){
        commentService.createComment(commentRequestDto);

        return new ResponseEntity<>("코멘트가 생성되었습니다", HttpStatusCode.valueOf(201));

    }
    // 코멘트 삭제
    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> delete(@PathVariable Long commentId)throws IllegalAccessException{
        commentService.deleteComment(commentId);

        return new ResponseEntity<>("코멘트가  삭제되었습니다.", HttpStatusCode.valueOf(200));
    }
    // 코멘트 수정
    @PutMapping("/{commentId}")
    public ResponseEntity<CommentResponseDto> update(@RequestBody CommentRequestDto commentRequestDto, @PathVariable Long commentId){
        commentService.updateComment(commentId, commentRequestDto);
        CommentResponseDto update = commentService.updateComment(commentId, commentRequestDto);

        return new ResponseEntity<>(update, HttpStatusCode.valueOf(200));
    }

    // 코멘트 전체 조회
    @GetMapping
    public ResponseEntity<List<CommentEntity>> findComments(){
        List<CommentEntity> commentEntityList = commentService.findAllComment();
    return new ResponseEntity<>(commentEntityList, HttpStatusCode.valueOf(200));
    }

    // 단일 코멘트 조회
    @GetMapping("/{commentId}")
    public ResponseEntity<Long> findOneComment(@PathVariable Long commentId) throws IllegalAccessException{
        commentService.finById(commentId);
        return new ResponseEntity<>(commentId, HttpStatusCode.valueOf(200));
    }

}
