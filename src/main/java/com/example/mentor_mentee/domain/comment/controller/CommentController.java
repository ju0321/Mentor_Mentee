package com.example.mentor_mentee.domain.comment.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts/{post-id}/comments")
public class CommentController {

  @PostMapping
  public String createComment(@PathVariable(value = "post-id")Long postId,@RequestParam String content) {
    return  postId + "번 게시글에 '" + content + "' 댓글 생성 완료";
  }

  @GetMapping
  public String getAllComments(@PathVariable(value = "post-id") Long postId) {
    return postId + "번 게시글의 댓글 리스트 조회 완료";
  }

  @GetMapping("/{comment-id}")
  public String getCommentById(@PathVariable(value = "post-id") Long postId,
      @PathVariable(value = "comment-id") Long commentId) {
    return postId + "번 게시글의 " + commentId + "번 댓글 조회 완료";
  }

  @PutMapping("/{comment-id}")
  public String updateComment(@PathVariable(value = "post-id") Long postId,
      @PathVariable(value = "comment-id") Long id,@RequestParam String content) {
    return postId + "번 게시글의 " + id + "번 댓글 수정 완료 → 내용: " + content;
  }

  @DeleteMapping("/{comment-id}")
  public String deleteComment(@PathVariable(value = "post-id") Long postId,
      @PathVariable(value = "comment-id") Long commentId) {
    return postId + "번 게시글의 " + commentId + "번 댓글 삭제 완료";
  }
}
