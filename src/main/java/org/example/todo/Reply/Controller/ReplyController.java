package org.example.todo.Reply.Controller;


import lombok.RequiredArgsConstructor;
import org.example.todo.Reply.Dto.ReplyRequestDto;
import org.example.todo.Reply.Dto.ReplyResponseDto;
import org.example.todo.Reply.Service.ReplyService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class ReplyController {

    private final ReplyService replyService;


    // 대댓글 생성
    @PostMapping("/comments/{commentId}/replies")
    public ResponseEntity<String> create(@RequestBody ReplyRequestDto replyRequestDto){
        replyService.createReply(replyRequestDto);

        return new ResponseEntity<>("대댓글이 생성되었습니다.", HttpStatusCode.valueOf(201));
    }

    // 대댓글 삭제
    @DeleteMapping("/replies/{replyId}")
        public ResponseEntity<String> delete(@PathVariable Long replyId) throws IllegalAccessException {
            replyService.deleteReply(replyId);

            return new ResponseEntity<>("대댓글이 삭제되었습니다", HttpStatusCode.valueOf(200));
    }

    // 대댓글 수정
    @PutMapping("/replies/{replyId}")
    public ResponseEntity<ReplyResponseDto> update(@RequestBody ReplyRequestDto replyRequestDto, @PathVariable Long replyId){
        replyService.updateReply(replyId, replyRequestDto);
        ReplyResponseDto update = replyService.updateReply(replyId, replyRequestDto);

        return new ResponseEntity<>(update, HttpStatusCode.valueOf(200));
    }

    // 단일 대댓글 조회
    @GetMapping("/replies/{replyId}")
    public ResponseEntity<Long> findOneReply(@PathVariable Long replyId) throws IllegalAccessException {
        replyService.findByID(replyId);
        return new ResponseEntity<>(replyId, HttpStatusCode.valueOf(200));
    }
}
