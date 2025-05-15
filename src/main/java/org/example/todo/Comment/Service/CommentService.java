package org.example.todo.Comment.Service;

import lombok.RequiredArgsConstructor;
import org.example.todo.Comment.Dto.CommentRequestDto;
import org.example.todo.Comment.Dto.CommentResponseDto;
import org.example.todo.Comment.Entity.CommentEntity;
import org.example.todo.Comment.Repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.stream.events.Comment;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)

public class CommentService {

    private final CommentRepository commentRepository;


    @Transactional
    public CommentResponseDto createComment(CommentRequestDto commentRequestDto){
        CommentEntity commentEntity = new CommentEntity(commentRequestDto);
        CommentEntity savedCommentEntity = commentRepository.save(commentEntity);

        return new CommentResponseDto(savedCommentEntity);
    }

    public void deleteComment(Long commentId) throws IllegalAccessException {
        CommentEntity commentEntity = commentRepository.findById(commentId).orElseThrow();
        commentRepository.delete(commentEntity);
    }

    @Transactional
    public CommentResponseDto updateComment(Long commentId, CommentRequestDto commentRequestDto){
        CommentEntity commentEntity = commentRepository.findById(commentId).orElseThrow();
        commentEntity.update(commentRequestDto);

        return new CommentResponseDto(commentEntity);
    }

    public List<CommentEntity> findAllComment(){

        return commentRepository.findAll();
    }

    public CommentEntity finById(Long commentId) throws IllegalAccessException {
        return commentRepository.findById(commentId).orElseThrow();
    }
}

