package com.rksp8.postservice.service;

import com.rksp8.postservice.client.RatingServiceClient;
import com.rksp8.postservice.context.UsernameContext;
import com.rksp8.postservice.dto.PostCreateDto;
import com.rksp8.postservice.dto.PostDto;
import com.rksp8.postservice.dto.RatingDto;
import com.rksp8.postservice.entity.Post;
import com.rksp8.postservice.mapper.PostMapper;
import com.rksp8.postservice.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final RatingServiceClient ratingServiceClient;


    @Override
    @Transactional
    public PostDto createPost(PostCreateDto postCreateDto) {

        Post post = postMapper.toEntity(postCreateDto);

        post.setAuthor(UsernameContext.getUsername());

        post = postRepository.save(post);

        log.info("Post with id {} created", post.getId());

        List<RatingDto> ratings = ratingServiceClient.getAllPostsRatings(post.getId());

        return postMapper.toDto(post, ratings);
    }

    @Override
    @Transactional
    public List<PostDto> getAllPosts() {
        return postRepository.findAll().stream()
                .map(post -> {
                    List<RatingDto> ratings = ratingServiceClient.getAllPostsRatings(post.getId());
                    return postMapper.toDto(post, ratings);
                })
                .toList();
    }

    @Override
    @Transactional
    public List<PostDto> getPostsByAuthor(String author) {
        return postRepository.findByAuthor(author).stream()
                .map(post -> {
                    List<RatingDto> ratings = ratingServiceClient.getAllPostsRatings(post.getId());
                    return postMapper.toDto(post, ratings);
                })
                .toList();
    }

    @Override
    @Transactional
    public PostDto getPostByAuthorAndId(String author, Long id) {
        Post post = postRepository.findByAuthorAndId(author, id)
                .orElseThrow(() -> new IllegalArgumentException("Post with id " + id + " not found"));
        List<RatingDto> ratings = ratingServiceClient.getAllPostsRatings(post.getId());
        return postMapper.toDto(post, ratings);
    }

    @Override
    @Transactional
    public void deletePost(Long id) {
        postRepository.deleteById(id);

        log.info("Post with id {} deleted", id);
    }

    private List<Post> getPostByAuthor(String author) {
        return postRepository.findByAuthor(author);
    }
}
