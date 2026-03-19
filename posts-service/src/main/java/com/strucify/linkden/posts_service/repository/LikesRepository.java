package com.strucify.linkden.posts_service.repository;

import com.strucify.linkden.posts_service.entity.postlikes.PostLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<PostLikes,Long> {
}
