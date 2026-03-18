package com.strucify.linkden.posts_service.repository;


import com.strucify.linkden.posts_service.entity.postEntity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {
}
