package com.strucify.linkden.posts_service.services.post;


import com.strucify.linkden.posts_service.dto.posts.PostRequestDto;
import com.strucify.linkden.posts_service.dto.posts.PostsResponseDto;

import java.util.List;

public interface PostService {


    PostsResponseDto findById(Long id);
    PostsResponseDto createPost(PostRequestDto postRequestDto);
    PostsResponseDto updatePost(Long id, PostRequestDto postRequestDto);
    PostsResponseDto partialUpdatePost(Long id, PostRequestDto postRequestDto);
    List<PostsResponseDto> findAll();
    void deletePost(Long id);
    Boolean existsById(Long id);
    List<PostsResponseDto> findAllByUserId(Long id);
}
