package com.example.calculateservice.configuration.feign;

import com.example.jwtstarter.exception.InvalidJwtTokenException;
import feign.*;
import org.springframework.security.core.context.*;
import org.springframework.stereotype.*;


@Component
public class BearerTokenInterceptor implements RequestInterceptor {

    @Override
    public synchronized void apply(RequestTemplate template) {

        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getDetails() == null) {
            throw new InvalidJwtTokenException("Token not found");
        }
        var token = auth.getDetails();

        template.header("Authorization", "Bearer " + token);
    }
}
