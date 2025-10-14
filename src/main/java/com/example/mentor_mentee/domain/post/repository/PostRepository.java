package com.example.mentor_mentee.domain.post.repository;

import com.example.mentor_mentee.domain.post.entity.Post;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
  Optional<Post> findById(Long id);
  boolean existsById(Long id);
  void deleteById(Long id);
}
