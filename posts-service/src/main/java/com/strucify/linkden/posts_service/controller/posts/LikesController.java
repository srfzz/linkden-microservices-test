package com.strucify.linkden.posts_service.controller.posts;

import com.strucify.linkden.posts_service.services.likes.LikedServiceImpl;
import com.strucify.linkden.posts_service.services.likes.LikesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
public class LikesController {

    private final LikedServiceImpl likesService;

    public LikesController(LikedServiceImpl likesService) {
        this.likesService = likesService;
    }

    @PostMapping("/{postId}")
    public ResponseEntity<Void> likedPost(@PathVariable long postId){
    likesService.likedPost(postId,1L);
    return ResponseEntity.noContent().build();
    }

}
