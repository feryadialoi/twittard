package dev.feryadi.tweetservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetListTweetResponse {
    private Long id;
    private Long userId;
    private String content;
}
