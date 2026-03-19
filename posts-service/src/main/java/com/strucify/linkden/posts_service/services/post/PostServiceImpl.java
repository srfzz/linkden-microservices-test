package com.strucify.linkden.posts_service.services.post;


import com.strucify.linkden.posts_service.dto.posts.PostRequestDto;
import com.strucify.linkden.posts_service.dto.posts.PostsResponseDto;
import com.strucify.linkden.posts_service.entity.postEntity.PostEntity;
import com.strucify.linkden.posts_service.exceptions.ResourceNotFoundException;
import com.strucify.linkden.posts_service.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
        PostEntity postEntity = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post not found"));
        return modelMapper.map(postEntity, PostsResponseDto.class);
    }

    @Override
    @Transactional
    public PostsResponseDto createPost(PostRequestDto postRequestDto) {

        PostEntity postEntity =modelMapper.map(postRequestDto,PostEntity.class);
        postEntity.setUserId(1L);
        postEntity = postRepository.save(postEntity);
        log.info("Post Created Successfully");
        return modelMapper.map(postEntity,PostsResponseDto.class);
    }

    @Override
    @Transactional
    public PostsResponseDto updatePost(Long id, PostRequestDto postRequestDto) {

        PostEntity existingPost = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        modelMapper.map(postRequestDto,existingPost);
       log.info("Post Updated Successfully");
       return modelMapper.map(existingPost,PostsResponseDto.class);
    }

    @Override
    @Transactional
    public PostsResponseDto partialUpdatePost(Long id, PostRequestDto postRequestDto) {
        PostEntity existingPost = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        modelMapper.map(postRequestDto,existingPost);
        log.info("Post Updated Successfully");

        return modelMapper.map(existingPost,PostsResponseDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostsResponseDto> findAll() {
        List<PostEntity> postEntities = postRepository.findAll();
        List<PostsResponseDto> postsResponseDtos  =postEntities.stream().map(postEntity -> modelMapper.map(postEntity,PostsResponseDto.class)).collect(Collectors.toList());
        return postsResponseDtos;
    }

    @Override
    @Transactional
    public void deletePost(Long id) {
        postRepository.deleteById(id);

    }

    @Override
    public Boolean existsById(Long id) {
        return postRepository.existsById(id);
    }
}
