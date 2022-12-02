package dev.feryadi.tweetservice.exception;

public class TweetNotFoundException extends RuntimeException {
    public TweetNotFoundException(String message) {
        super(message);
    }
}
