package com.example.mentor_mentee.domain.comment.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CommentResponseDto {

  private final Long id;
  private final String body;
}
