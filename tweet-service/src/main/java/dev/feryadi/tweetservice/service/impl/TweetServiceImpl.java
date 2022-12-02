package dev.feryadi.tweetservice.service.impl;

import com.github.feryadialoi.tuplemapper.TupleMapper;
import dev.feryadi.tweetservice.feignclient.CommentFeignClient;
import dev.feryadi.tweetservice.dto.*;
import dev.feryadi.tweetservice.entity.Tweet;
import dev.feryadi.tweetservice.mapper.TweetMapper;
import dev.feryadi.tweetservice.repository.TweetRepository;
import dev.feryadi.tweetservice.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService {

    private static final Integer DEFAULT_REQUEST_PAGE = 0;
    private static final Integer DEFAULT_REQUEST_SIZE = 3;

    private final TweetRepository tweetRepository;
    private final CommentFeignClient commentFeignClient;

    @Override
    public Mono<GetTweetResponse> getTweet(GetTweetRequest getTweetRequest) {
        Mono<Tweet> tweetMono = tweetRepository.findById(getTweetRequest.getId());
        Mono<List<GetCommentResponse>> commentsMono = doGetComments(getTweetRequest.getId());

        return Mono.zip(tweetMono, commentsMono).map(TupleMapper.map(TweetMapper::toGetTweetResponse));
    }

    private Mono<List<GetCommentResponse>> doGetComments(Long tweetId) {
        GetCommentRequest getCommentRequest = GetCommentRequest.builder()
                .tweetId(tweetId)
                .page(DEFAULT_REQUEST_PAGE)
                .size(DEFAULT_REQUEST_SIZE)
                .build();

        return Mono
                .fromCallable(() -> commentFeignClient.getComments(getCommentRequest))
                .publishOn(Schedulers.boundedElastic())
                .map(getCommentResponseRestResponse -> getCommentResponseRestResponse.getContent().stream().toList());
    }

    @Override
    public Flux<GetListTweetResponse> getTweets(GetListTweetRequest getListTweetRequest) {
        return tweetRepository
                .findAllByUserId(getListTweetRequest.getUserId())
                .map(TweetMapper::toGetListTweetResponse);
    }
}
