package com.rksp8.postservice.service;

import com.rksp8.postservice.dto.PostCreateDto;
import com.rksp8.postservice.dto.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostCreateDto postCreateDto);

    List<PostDto> getAllPosts();

    List<PostDto> getPostsByAuthor(String author);

    PostDto getPostByAuthorAndId(String author, Long id);

    void deletePost(Long id);
}
