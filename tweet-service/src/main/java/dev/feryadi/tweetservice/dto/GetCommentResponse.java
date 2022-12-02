package dev.feryadi.tweetservice.dto;

import lombok.Data;

@Data
public class GetCommentResponse {
    private Long id;
    private Long userId;
    private Long tweetId;
    private String content;
}
