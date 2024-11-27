package com.example.calculateservice.clients;

import java.util.*;


import com.fasterxml.jackson.databind.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cloud.openfeign.*;

import com.example.calculateservice.swagger.client.abs.api.*;

@FeignClient(name = "financialProductsClient", url = "${abs.base-path}")
public interface FinancialProductsClient extends FinancialProductsApi {

    @Override
    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

}

