package dev.feryadi.tweetservice.mapper;

import dev.feryadi.tweetservice.dto.GetCommentResponse;
import dev.feryadi.tweetservice.dto.GetListTweetResponse;
import dev.feryadi.tweetservice.dto.GetTweetResponse;
import dev.feryadi.tweetservice.entity.Tweet;

import java.util.List;

public class TweetMapper {
    public static GetTweetResponse toGetTweetResponse(Tweet tweet, List<GetCommentResponse> comments) {
        return GetTweetResponse.builder()
                .id(tweet.getId())
                .userId(tweet.getUserId())
                .content(tweet.getContent())
                .comments(comments)
                .build();
    }

    public static GetListTweetResponse toGetListTweetResponse(Tweet tweet) {
        return GetListTweetResponse.builder()
                .id(tweet.getId())
                .userId(tweet.getUserId())
                .content(tweet.getContent())
                .build();
    }
}
