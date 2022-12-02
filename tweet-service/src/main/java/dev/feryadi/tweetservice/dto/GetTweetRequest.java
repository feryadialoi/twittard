package dev.feryadi.tweetservice.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GetTweetRequest {
    @NotNull
    private Long id;
}
