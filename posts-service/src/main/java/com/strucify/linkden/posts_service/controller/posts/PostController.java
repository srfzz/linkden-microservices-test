package com.strucify.linkden.posts_service.controller.posts;

import com.strucify.linkden.posts_service.apiresponse.ApiResponse;
import com.strucify.linkden.posts_service.dto.posts.PostRequestDto;
import com.strucify.linkden.posts_service.dto.posts.PostsResponseDto;
import com.strucify.linkden.posts_service.services.post.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts/")
@Slf4j
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<PostsResponseDto>> createPost(@RequestBody PostRequestDto postRequestDto) {
     PostsResponseDto postsResponseDto=   postService.createPost(postRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(postsResponseDto,"Post Created Successfully",HttpStatus.CREATED));
    }
}
