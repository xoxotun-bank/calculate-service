package com.example.calculateservice.configuration.feign;

import feign.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.cache.CacheManager;

@Component
@RequiredArgsConstructor
public class CacheableInterceptor implements RequestInterceptor {

    private final CacheManager cacheManager;

    @Value("${cache.key}")
    private String key;

    @Value("${cache.name}")
    private String name;

    @Override
    public synchronized void apply(RequestTemplate requestTemplate) {
        Cache cache = cacheManager.getCache(name);

        if (cache == null || cache.get(key) == null) {
            return;
        }

        addEtagHeader(requestTemplate, cache);
        addLastModifiedHeader(requestTemplate, cache);
    }

    private void addEtagHeader(RequestTemplate requestTemplate, Cache cache) {
        var etagValueWrapper = cache.get(HttpHeaders.ETAG);

        var etag = getHeaderValueFromWrapper(etagValueWrapper);
        if (etag == null) {
            return;
        }
        requestTemplate.header(HttpHeaders.ETAG, etag.toString());
    }

    private void addLastModifiedHeader(RequestTemplate requestTemplate, Cache cache) {
        var lastModifiedValueWrapper = cache.get(HttpHeaders.LAST_MODIFIED);

        var lastModified = getHeaderValueFromWrapper(lastModifiedValueWrapper);
        if (lastModified == null) {
            return;
        }
        requestTemplate.header(HttpHeaders.IF_MODIFIED_SINCE, lastModified.toString());
    }

    private Object getHeaderValueFromWrapper(Cache.ValueWrapper valueWrapper) {
        if (valueWrapper == null || valueWrapper.get() == null) {
            return null;
        }
        var result = valueWrapper.get();
        return result;
    }

}
