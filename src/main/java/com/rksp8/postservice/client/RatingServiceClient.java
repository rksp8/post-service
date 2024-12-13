package com.rksp8.postservice.client;

import com.rksp8.postservice.dto.RatingDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "rating-service", url = "http://localhost:8082")
public interface RatingServiceClient {

    @GetMapping("/rating/post/{postId}")
    List<RatingDto> getAllPostsRatings(@PathVariable Long postId);

}
