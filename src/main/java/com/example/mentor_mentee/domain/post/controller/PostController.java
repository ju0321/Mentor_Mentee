package com.example.mentor_mentee.domain.post.controller;

import com.example.mentor_mentee.domain.post.dto.request.PostRequestDto;
import com.example.mentor_mentee.domain.post.dto.request.UpdatePostRequestDto;
import com.example.mentor_mentee.domain.post.dto.response.PostResponseDto;
import com.example.mentor_mentee.domain.post.service.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostController {

  private final PostService postService;

  @PostMapping
  public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto) {
    PostResponseDto responseDto = postService.createPost(postRequestDto);
    return responseDto;
  }

  @GetMapping("/{post-id}")
  public PostResponseDto getPostById(@PathVariable(value = "post-id") Long id) {
    PostResponseDto responseDto = postService.readPost(id);
    return responseDto;
  }

  @GetMapping
  public List<PostResponseDto> getAllPosts() {
    return postService.readAllPosts();
  }

  @PutMapping("/{post-id}")
  public PostResponseDto updatePost(@RequestBody UpdatePostRequestDto updatePostRequestDto, @PathVariable(value = "post-id") Long id) {
    PostResponseDto responseDto = postService.updatePost(updatePostRequestDto, id);
    return responseDto;
  }

  @DeleteMapping("/{post-id}")
  public String deletePost(@PathVariable(value = "post-id") Long id){
    postService.deletePost(id);
    return "삭제 완료";
  }
}
