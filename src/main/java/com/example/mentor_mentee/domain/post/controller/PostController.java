package com.example.mentor_mentee.domain.post.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

  @PostMapping("/")
  public String createPost(String title, String content) {
    return title + ": " + content + "게시글 생성 완료";
  }

  @GetMapping
  public String getAllPosts() {
    return "게시글 리스트 조회 완료";
  }

  @GetMapping("/{post-id}")
  public String getPostById(@PathVariable(value = "post-id") Long id) {
    return id + "번 게시글 조회 완료";
  }

  @PutMapping("/{post-id}")
  public String updatePost(@PathVariable(value = "post-id") Long id, String title, String content) {
    return id + "번 게시글 수정 완료";
  }

  @DeleteMapping("/{post-id}")
  public String deletePost(@PathVariable(value = "post-id") Long id) {
    return id + "번 게시글 삭제 완료";
  }

}
