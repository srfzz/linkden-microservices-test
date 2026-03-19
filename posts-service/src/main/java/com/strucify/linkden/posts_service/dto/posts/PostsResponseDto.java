package com.strucify.linkden.posts_service.dto.posts;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostsResponseDto {

    private Long id;
    private String content;
    private Long userId;
}
