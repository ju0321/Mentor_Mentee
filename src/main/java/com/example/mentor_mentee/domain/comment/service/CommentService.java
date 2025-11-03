package com.example.mentor_mentee.domain.comment.service;

import com.example.mentor_mentee.domain.comment.dto.request.CommentRequestDto;
import com.example.mentor_mentee.domain.comment.dto.response.CommentResponseDto;
import com.example.mentor_mentee.domain.comment.entity.Comment;
import com.example.mentor_mentee.domain.comment.repository.CommentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

  private final CommentRepository commentRepository;

  public CommentResponseDto createComment(CommentRequestDto commentRequestDto) {
    // 1. CommentRequestDto 에 있는 값으로 comment 클래스 객체 생성
    Comment comment = Comment.builder()
        .body(commentRequestDto.getBody())
        .build();

    // 2. 새로 생성한 comment 객체 DB에 저장
    Comment savedComment = commentRepository.save(comment);

    // 3. 저장된 comment 정보를 담아 응답 객체 반환
    return CommentResponseDto.builder()
        .id(savedComment.getId())
        .body(savedComment.getBody())
        .build();
  }
}
