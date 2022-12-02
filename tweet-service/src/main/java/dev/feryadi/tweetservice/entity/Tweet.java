package dev.feryadi.tweetservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tweet {

    private Long id;

    private Long userId;

    private String content;
}
