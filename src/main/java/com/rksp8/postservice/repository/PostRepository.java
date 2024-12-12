package com.rksp8.postservice.repository;

import com.rksp8.postservice.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


    List<Post> findByAuthor(String author);

    Optional<Post> findByAuthorAndId(String author, Long id);
}
