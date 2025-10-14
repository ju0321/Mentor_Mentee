package com.example.mentor_mentee.domain.post.dto.request;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class PostRequestDto {
  private final String title;
  private final String content;
}
