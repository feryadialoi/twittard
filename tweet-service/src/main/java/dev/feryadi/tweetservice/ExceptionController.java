package dev.feryadi.tweetservice;

import dev.feryadi.tweetservice.exception.TweetNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(TweetNotFoundException.class)
    public ResponseEntity<Mono<?>> handleTweetNotFoundException(TweetNotFoundException tweetNotFoundException) {
        Map<String, Object> body = new HashMap<>();
        body.put("errors", tweetNotFoundException.getMessage());
        return new ResponseEntity<>(Mono.just(body), HttpStatus.NOT_FOUND);
    }
}
