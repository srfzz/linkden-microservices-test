package com.strucify.linkden.posts_service.apiresponse;


import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T> {

    private boolean success;
    private int status;
    private String message;
    private T data;

    private  Object error;


    private Instant timestamp;

    public static <T> ApiResponse<T> success(T data,String message,HttpStatus status) {
        return  ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .status(status.value())
                .timestamp(Instant.now())
                .build();
    }

    public static <T> ApiResponse<T> error(Object error,String message,HttpStatus status) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .error(error)
                .status(status.value())
                .timestamp(Instant.now())
                .build();
    }


}
