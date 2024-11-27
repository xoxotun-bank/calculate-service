package com.example.calculateservice.component;

import java.util.*;


import com.example.calculateservice.swagger.client.abs.model.FinancialProductsResponseDto;
import com.fasterxml.jackson.databind.*;
import feign.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;

import com.example.calculateservice.clients.FinancialProductsClient;
import com.example.calculateservice.swagger.client.abs.api.FinancialProductsApi;



@Component
@RequiredArgsConstructor
public class FinancialProductsClientCacheable implements FinancialProductsApi {

    private final FinancialProductsClient financialProductsClient;

    private final CacheManager cacheManager;

    @Value("${cache.key}")
    private String key;

    @Value("${cache.name}")
    private String name;

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<FinancialProductsResponseDto> financialProductsGet() {
        Cache cache = cacheManager.getCache(name);

        ResponseEntity<FinancialProductsResponseDto> response = null;
        try {
            response = financialProductsClient.financialProductsGet();

            if (cache == null) {
                return response;
            }

            var headers = response.getHeaders();

            var lastModified = headers.get(HttpHeaders.LAST_MODIFIED);
            var etag = headers.get(HttpHeaders.ETAG);

            if (etag != null) {
                cache.put(HttpHeaders.ETAG, etag.get(0));
            }

            if (lastModified != null) {
                cache.put(HttpHeaders.LAST_MODIFIED, lastModified.get(0));
            }

            cache.put(key, response);
        } catch (FeignException e) {
            if (e.status() != HttpStatus.NOT_MODIFIED.value()) {
                throw new RuntimeException(e);
            }

            if (cache == null || cache.get(key) == null) {
                return response;
            }

            response = (ResponseEntity<FinancialProductsResponseDto>) cache.get(key).get();
        }
        return response;
    }

}
