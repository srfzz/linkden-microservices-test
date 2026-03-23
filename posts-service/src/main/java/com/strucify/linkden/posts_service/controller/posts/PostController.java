package com.strucify.linkden.posts_service.controller.posts;

import com.strucify.linkden.posts_service.apiresponse.ApiResponse;
import com.strucify.linkden.posts_service.dto.posts.PostRequestDto;
import com.strucify.linkden.posts_service.dto.posts.PostsResponseDto;
import com.strucify.linkden.posts_service.services.post.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@Slf4j
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<PostsResponseDto>> createPost(@RequestBody PostRequestDto postRequestDto) {
        log.info("Request to create post : {}", postRequestDto);
     PostsResponseDto postsResponseDto=   postService.createPost(postRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(postsResponseDto,"Post Created Successfully",HttpStatus.CREATED));
    }


    @GetMapping("/{postId}")
    public ResponseEntity<ApiResponse<PostsResponseDto>> getPost(@PathVariable("postId") Long postId) {
        log.info("Request to get post : {}", postId);
       PostsResponseDto postsResponseDto= postService.findById(postId);
       return ResponseEntity.ok().body(ApiResponse.success(postsResponseDto,"Post Found Successfully",HttpStatus.OK));

    }

    @PutMapping("/{postId}")
    public ResponseEntity<ApiResponse<PostsResponseDto>> updatePost(@PathVariable("postId") Long postId, @RequestBody PostRequestDto postRequestDto) {
        log.info("Request to update post : {}", postId);
        PostsResponseDto postsResponseDto= postService.updatePost(postId, postRequestDto);
        return ResponseEntity.ok().body(ApiResponse.success(postsResponseDto,"Post Updated Successfully",HttpStatus.OK));
    }
    @GetMapping()
    public ResponseEntity<ApiResponse<List<PostsResponseDto>>> getAllPosts() {
        log.info("Request to get all posts");
        List<PostsResponseDto> postsResponseDto= postService.findAll();
        return ResponseEntity.ok().body(ApiResponse.success(postsResponseDto,"Data Fethcehed Sucessfully",HttpStatus.OK));
    }
    @DeleteMapping("/{postId}")
    public ResponseEntity<ApiResponse<Void>> deletePost(@PathVariable("postId") Long postId) {
        log.info("Request to delete post : {}", postId);
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/{userId}/allPosts")
    public ResponseEntity<ApiResponse<List<PostsResponseDto>>> getAllPostsByUserId(@PathVariable("userId") Long userId) {
        log.info("Request to get all posts by userId : {}", userId);
        List<PostsResponseDto> postsResponseDto= postService.findAllByUserId(userId);
        return ResponseEntity.ok().body(ApiResponse.success(postsResponseDto,"success",HttpStatus.OK));
    }
}
