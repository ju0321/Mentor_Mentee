package com.example.mentor_mentee.domain.post.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Time;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="post")
public class Post {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(nullable = false)
  private String title;
  @Column(nullable = false)
  private String content;
  @Column(nullable = false)
  @Builder.Default
  private Long views = 0L;

  public void update(String title, String content) {
    this.title = title;
    this.content = content;
  }
}
