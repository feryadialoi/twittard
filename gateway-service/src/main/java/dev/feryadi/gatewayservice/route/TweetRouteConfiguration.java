package dev.feryadi.gatewayservice.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TweetRouteConfiguration {
    @Bean
    public RouteLocator tweetRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(predicateSpec -> predicateSpec
                        .path("/tweets/**")
                        .uri("lb://TWEET-SERVICE")
                )
                .build();
    }

    @Bean
    public RouteLocator commentRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(predicateSpec -> predicateSpec
                        .path("/comments/**")
                        .uri("lb://COMMENT-SERVICE")
                )
                .build();
    }
}
