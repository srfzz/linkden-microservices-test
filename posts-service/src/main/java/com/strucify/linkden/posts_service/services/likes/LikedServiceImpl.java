package com.strucify.linkden.posts_service.services.likes;

import com.strucify.linkden.posts_service.entity.postEntity.PostEntity;
import com.strucify.linkden.posts_service.entity.postlikes.PostLikes;
import com.strucify.linkden.posts_service.exceptions.ResourceNotFoundException;
import com.strucify.linkden.posts_service.repository.LikesRepository;
import com.strucify.linkden.posts_service.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class LikedServiceImpl implements LikesService {
    private final LikesRepository likesRepository;
    private final PostRepository postRepository;

    public LikedServiceImpl(LikesRepository likesRepository, PostRepository postRepository) {
        this.likesRepository = likesRepository;
        this.postRepository = postRepository;
    }

    @Override
    @Transactional
    public void likedPost(Long postId, Long userid) {
    log.info("likedPost Service ");
        PostEntity post =postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("post no found"));
        boolean alreadyLiked=likesRepository.existsByPostIdAndUserId(postId,userid);
        if(alreadyLiked){
            log.info("like deleted ");
            likesRepository.deleteByPostAndUserId(post,userid);
        }else
        {
            log.info("new Like");
            PostLikes postLikes= PostLikes.builder()
                    .post(post)
                    .userId(userid)
                    .build();
            likesRepository.save(postLikes);
        }
    }
}
