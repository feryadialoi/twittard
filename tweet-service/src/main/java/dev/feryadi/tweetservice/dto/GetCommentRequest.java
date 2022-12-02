package dev.feryadi.tweetservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCommentRequest {
    private Long userId;
    private Long tweetId;
    private Integer page;
    private Integer size;
}
