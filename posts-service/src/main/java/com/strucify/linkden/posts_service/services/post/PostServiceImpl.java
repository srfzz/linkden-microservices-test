package com.strucify.linkden.posts_service.services.post;


import com.strucify.linkden.posts_service.dto.posts.PostRequestDto;
import com.strucify.linkden.posts_service.dto.posts.PostsResponseDto;
import com.strucify.linkden.posts_service.entity.postEntity.PostEntity;
import com.strucify.linkden.posts_service.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostsResponseDto findById(Long id) {
        return null;
    }

    @Override
    public PostsResponseDto createPost(PostRequestDto postRequestDto) {
        PostEntity postEntity =modelMapper.map(postRequestDto,PostEntity.class);
        postEntity = postRepository.save(postEntity);
        return modelMapper.map(postEntity,PostsResponseDto.class);
    }

    @Override
    public PostsResponseDto updatePost(Long id, PostRequestDto postRequestDto) {
        return null;
    }

    @Override
    public PostsResponseDto partialUpdatePost(Long id, PostRequestDto postRequestDto) {
        return null;
    }

    @Override
    public List<PostsResponseDto> findAll() {
        return List.of();
    }

    @Override
    public void deletePost(Long id) {

    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }
}
