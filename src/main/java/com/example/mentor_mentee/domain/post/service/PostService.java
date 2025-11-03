package com.example.mentor_mentee.domain.post.service;

import com.example.mentor_mentee.domain.post.dto.request.PostRequestDto;
import com.example.mentor_mentee.domain.post.dto.request.UpdatePostRequestDto;
import com.example.mentor_mentee.domain.post.dto.response.PostResponseDto;
import com.example.mentor_mentee.domain.post.entity.Post;
import com.example.mentor_mentee.domain.post.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
  private final PostRepository postRepository;

  @Transactional
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

  @Transactional(readOnly = true)
  public PostResponseDto readPost(Long postId){
    // 1. postId를 통해서 Post 조회(findById), 예외처리 필요
    Post post = postRepository.findById(postId)
        .orElseThrow(() -> new EntityNotFoundException("해당 게시글이 존재하지 않습니다."));

    // 2. postResponseDto에 해당 Post 내용을 담아서 반환
    return PostResponseDto.builder()
        .id(post.getId())
        .title(post.getTitle())
        .content(post.getContent())
        .views(post.getViews())
        .build();
  }

  @Transactional(readOnly = true)
  public List<PostResponseDto> readAllPosts(){

    List<Post> posts = postRepository.findAll();

    // post를 PostResponseDto로 반복 변환
    List<PostResponseDto> responseDtos = new ArrayList<>();

    for(Post post : posts){
      PostResponseDto postResponseDto = PostResponseDto.builder()
          .id(post.getId())
          .title(post.getTitle())
          .content(post.getContent())
          .views(post.getViews())
          .build();
      responseDtos.add(postResponseDto);
    }

    return responseDtos;
  }

  @Transactional
  public PostResponseDto updatePost(UpdatePostRequestDto updatePostRequestDto, Long postId) {
    Post post = postRepository.findById(postId)
        .orElseThrow(() -> new EntityNotFoundException("해당 게시글이 존재하지 않습니다."));

    post.update(updatePostRequestDto.getTitle(), updatePostRequestDto.getContent());

    Post updatedPost = postRepository.save(post);

    return PostResponseDto.builder()
        .id(updatedPost.getId())
        .title(updatedPost.getTitle())
        .content(updatedPost.getContent())
        .views(updatedPost.getViews())
        .build();
  }

  @Transactional
  public void deletePost(Long postId) {
    // 1. postId를 통해서 해당 Post 존재 여부 조회, 존재 여부에 따라 삭제 조건문 필요
    Post post = postRepository.findById(postId)
        .orElseThrow(() -> new EntityNotFoundException("해당 게시글이 존재하지 않습니다."));

    postRepository.delete(post);
  }

}
