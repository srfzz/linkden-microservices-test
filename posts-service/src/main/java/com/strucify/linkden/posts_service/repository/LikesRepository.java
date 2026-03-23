package com.strucify.linkden.posts_service.repository;

import com.strucify.linkden.posts_service.entity.postEntity.PostEntity;
import com.strucify.linkden.posts_service.entity.postlikes.PostLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LikesRepository extends JpaRepository<PostLikes,Long> {


    @Modifying
    @Transactional
    void deleteByPostAndUserId(PostEntity post, Long userId);

    boolean existsByPostIdAndUserId(Long postId, Long userId);

}
