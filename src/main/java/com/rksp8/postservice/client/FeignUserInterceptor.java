package com.rksp8.postservice.client;

import com.rksp8.postservice.context.UsernameContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FeignUserInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header("x-username", String.valueOf(UsernameContext.getUsername()));
    }
}
