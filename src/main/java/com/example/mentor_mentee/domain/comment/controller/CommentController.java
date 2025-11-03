package com.example.mentor_mentee.domain.comment.controller;

import com.example.mentor_mentee.domain.comment.dto.request.CommentRequestDto;
import com.example.mentor_mentee.domain.comment.dto.response.CommentResponseDto;

import com.example.mentor_mentee.domain.comment.service.CommentService;
import com.example.mentor_mentee.domain.post.dto.request.PostRequestDto;
import com.example.mentor_mentee.domain.post.dto.response.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

  private final CommentService commentService;


  @PostMapping
  public CommentResponseDto createComment(@RequestBody CommentRequestDto commentRequestDto) {
    CommentResponseDto commentResponseDto = commentService.createComment(commentRequestDto);
    return commentResponseDto;
  }


  @GetMapping
  public String getAllComments() {
    return "댓글 리스트 조회 완료";
  }

  @GetMapping("/{comment-id}")
  public String getCommentById(@PathVariable(value = "comment-id") Long commentId) {
    return commentId + "번 댓글 조회 완료";
  }

  @PutMapping("/{comment-id}")
  public String updateComment(@PathVariable(value = "comment-id") Long id,@RequestBody String content) {
    return  id + "번 댓글 수정 완료 → 내용: " + content;
  }

  @DeleteMapping("/{comment-id}")
  public String deleteComment(@PathVariable(value = "comment-id") Long commentId) {
    return commentId + "번 댓글 삭제 완료";
  }
}
