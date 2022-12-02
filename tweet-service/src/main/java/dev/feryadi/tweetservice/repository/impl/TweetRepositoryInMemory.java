package dev.feryadi.tweetservice.repository.impl;

import dev.feryadi.tweetservice.entity.Tweet;
import dev.feryadi.tweetservice.exception.TweetNotFoundException;
import dev.feryadi.tweetservice.repository.TweetRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Component
public class TweetRepositoryInMemory implements TweetRepository {

    private static final List<Tweet> TWEETS = new ArrayList<>();

    static {
        TWEETS.add(new Tweet(1L, 1L, "Hello, Good Morning!"));
        TWEETS.add(new Tweet(2L, 1L, "Hello, Good Afternoon!"));
        TWEETS.add(new Tweet(3L, 1L, "Hello, Good Evening!"));
    }

    @Override
    public Mono<Tweet> findById(@NonNull Long id) {
        return TWEETS.stream()
                .filter(tweet -> tweet.getId().equals(id))
                .map(Mono::just)
                .findFirst()
                .orElse(Mono.error(new TweetNotFoundException("tweet not found")));
    }

    @Override
    public Flux<Tweet> findAllByUserId(@NonNull Long userId) {
        return Flux.fromStream(
                TWEETS.stream().filter(tweet -> tweet.getUserId().equals(userId))
        );
    }
}
