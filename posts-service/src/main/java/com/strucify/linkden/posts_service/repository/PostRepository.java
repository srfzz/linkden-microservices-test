package com.strucify.linkden.posts_service.repository;


import com.strucify.linkden.posts_service.entity.postEntity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {
    List<PostEntity> findAllByUserId(Long userId);
    List<PostEntity> userId(Long userId);
}
