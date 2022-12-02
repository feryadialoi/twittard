package dev.feryadi.tweetservice.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GetListTweetRequest {
    @NotBlank
    private Long userId;
}
