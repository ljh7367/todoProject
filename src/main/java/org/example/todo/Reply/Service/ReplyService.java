package org.example.todo.Reply.Service;



import lombok.RequiredArgsConstructor;
import org.example.todo.Reply.Dto.ReplyRequestDto;
import org.example.todo.Reply.Dto.ReplyResponseDto;
import org.example.todo.Reply.Entity.ReplyEntity;
import org.example.todo.Reply.Repository.ReplyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)

public class ReplyService {

    private final ReplyRepository replyRepository;


    //  대댓글  생성
    @Transactional
    public ReplyResponseDto createReply(ReplyRequestDto replyRequestDto){
        ReplyEntity replyEntity = new ReplyEntity(replyRequestDto);
        ReplyEntity savedReplyEntity = replyRepository.save(replyEntity);

        return new ReplyResponseDto(savedReplyEntity);
    }

    // 대댓글 삭제
    public void deleteReply(Long replyId) throws IllegalAccessException{
        ReplyEntity replyEntity = replyRepository.findById(replyId).orElseThrow();
        replyRepository.delete(replyEntity);
    }

    // 대댓글 수정
    @Transactional
    public ReplyResponseDto updateReply(Long replyId, ReplyRequestDto replyRequestDto){
        ReplyEntity replyEntity = replyRepository.findById(replyId).orElseThrow();

        return new ReplyResponseDto(replyEntity);
    }

    //  단일 대댓글 조회
    public ReplyEntity findByID(Long replyId) throws IllegalAccessException {
        return replyRepository.findById(replyId).orElseThrow();
    }
}
