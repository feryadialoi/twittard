package dev.feryadi.tweetservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RestResponse<T> {
    @JsonProperty("_embedded")
    private RestEmbeddedResponse<T> embedded;
    private RestPageResponse page;
}
