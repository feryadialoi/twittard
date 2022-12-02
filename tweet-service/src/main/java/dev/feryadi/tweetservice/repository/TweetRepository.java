package dev.feryadi.tweetservice.repository;

import dev.feryadi.tweetservice.entity.Tweet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TweetRepository {
    Mono<Tweet> findById(Long id);

    Flux<Tweet> findAllByUserId(Long userId);
}
