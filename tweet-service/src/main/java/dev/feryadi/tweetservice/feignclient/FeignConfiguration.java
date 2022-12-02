package dev.feryadi.tweetservice.feignclient;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FeignConfiguration {

    @Bean
    public HttpMessageConverters httpMessageConverters() {
        return new HttpMessageConverters(new RestTemplate().getMessageConverters());
    }

}
