package com.example.mentor_mentee.domain.comment.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CommentRequestDto {

  private final String body;
}
