package dev.feryadi.tweetservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class RestEmbeddedResponse<T> {
    private List<T> comments;
}
