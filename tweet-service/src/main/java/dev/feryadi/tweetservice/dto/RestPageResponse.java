package dev.feryadi.tweetservice.dto;

import lombok.Data;

@Data
public class RestPageResponse {
    private Integer size;
    private Integer totalElements;
    private Integer totalPages;
    private Integer number;
}
