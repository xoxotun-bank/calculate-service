package com.example.calculateservice.component.wrapper;

import lombok.*;

import com.example.calculateservice.swagger.server.model.CalculatedProductDto;

@Data
public class ScoredProductDto extends CalculatedProductDto {

    private int matchCount = 0;

}
