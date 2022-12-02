package dev.feryadi.tweetservice.service;

import dev.feryadi.tweetservice.dto.GetListTweetRequest;
import dev.feryadi.tweetservice.dto.GetListTweetResponse;
import dev.feryadi.tweetservice.dto.GetTweetRequest;
import dev.feryadi.tweetservice.dto.GetTweetResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TweetService {
    Mono<GetTweetResponse> getTweet(GetTweetRequest getTweetRequest);

    Flux<GetListTweetResponse> getTweets(GetListTweetRequest getListTweetRequest);
}
