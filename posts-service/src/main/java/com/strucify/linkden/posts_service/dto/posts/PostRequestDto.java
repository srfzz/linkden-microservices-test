package com.strucify.linkden.posts_service.dto.posts;



import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.strucify.linkden.posts_service.validation.HtmlSanitizerDeserializer;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostRequestDto {
    @NotBlank
    @JsonDeserialize(using = HtmlSanitizerDeserializer.class)
    private String content;
}
