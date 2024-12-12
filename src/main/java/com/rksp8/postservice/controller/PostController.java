package com.rksp8.postservice.controller;

import com.rksp8.postservice.dto.PostCreateDto;
import com.rksp8.postservice.dto.PostDto;
import com.rksp8.postservice.service.PostService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/all/{author}")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> getPostsByAuthor(@PathVariable String author) {
        return postService.getPostsByAuthor(author);
    }

    @GetMapping("/{author}/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto getPostById(@PathVariable String author,@PathVariable Long id) {
        return postService.getPostByAuthorAndId(author, id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Parameter(in = ParameterIn.HEADER, name = "x-username", required = true)
    public PostDto createPost(@RequestBody PostCreateDto postDto) {
        return postService.createPost(postDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
