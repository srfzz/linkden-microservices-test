package com.strucify.linkden.posts_service.entity.postlikes;


import com.strucify.linkden.posts_service.entity.postEntity.PostEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "post_likes")
public class PostLikes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id",nullable = false)
    @ToString.Exclude
    private PostEntity post;
    private Long userId;
    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private Instant createdAt;

}
