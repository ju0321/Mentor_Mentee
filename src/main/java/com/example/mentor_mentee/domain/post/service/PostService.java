package com.example.mentor_mentee.domain.post.service;

import com.example.mentor_mentee.domain.post.dto.request.PostRequestDto;
import com.example.mentor_mentee.domain.post.dto.response.PostResponseDto;
import com.example.mentor_mentee.domain.post.entity.Post;
import com.example.mentor_mentee.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
  private final PostRepository postRepository;

  public PostResponseDto createPost(PostRequestDto postRequestDto) {
    //1. PostRequestDto 에 있는 값으로 post 클래스 객체 생성
    Post post = Post.builder()
        .title(postRequestDto.getTitle())
        .content(postRequestDto.getContent())
        .build();

    //2. 새로 생성한 post 객체 DB에 저장
    Post savedPost = postRepository.save(post);

    //3. 새로 생성한 post 객체 데이터에서 필요한 부분을 PostResponseDto에 넣어서 반환
    return PostResponseDto.builder()
        .id(savedPost.getId())
        .title(savedPost.getTitle())
        .content(savedPost.getContent())
        .views(savedPost.getViews())
        .build();
  }



}
