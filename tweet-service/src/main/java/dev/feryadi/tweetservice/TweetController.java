package dev.feryadi.tweetservice;

import dev.feryadi.tweetservice.dto.GetListTweetRequest;
import dev.feryadi.tweetservice.dto.GetListTweetResponse;
import dev.feryadi.tweetservice.dto.GetTweetRequest;
import dev.feryadi.tweetservice.dto.GetTweetResponse;
import dev.feryadi.tweetservice.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/tweets")
@RequiredArgsConstructor
public class TweetController {

    private final TweetService tweetService;

    @GetMapping("")
    public Flux<GetListTweetResponse> getTweets(GetListTweetRequest getListTweetRequest) {
        return tweetService.getTweets(getListTweetRequest);
    }

    @GetMapping("/{id}")
    public Mono<GetTweetResponse> getTweet(GetTweetRequest getTweetRequest) {
        return tweetService.getTweet(getTweetRequest);
    }

}
