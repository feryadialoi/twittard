package dev.feryadi.tweetservice.feignclient;

import dev.feryadi.tweetservice.dto.GetCommentRequest;
import dev.feryadi.tweetservice.dto.GetCommentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "COMMENT-SERVICE", path = "/comments")
public interface CommentFeignClient {

    @GetMapping("")
    CollectionModel<GetCommentResponse> getComments(@SpringQueryMap GetCommentRequest getCommentRequest);
}
