package com.example.calculateservice.configuration;

import com.example.calculateservice.component.wrapper.ScoredProductDto;
import com.example.calculateservice.swagger.server.model.CalculatedProductDto;
import org.modelmapper.*;
import org.modelmapper.convention.*;
import org.springframework.context.annotation.*;

import static org.modelmapper.config.Configuration.AccessLevel.*;

import com.example.calculateservice.swagger.client.abs.model.FinancialProductDto;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var mapper = new ModelMapper();
        mapper.getConfiguration()
            .setMatchingStrategy(MatchingStrategies.STRICT)
            .setFieldMatchingEnabled(true)
            .setFieldAccessLevel(PRIVATE)
            .setSkipNullEnabled(true);
        createAbsToCalculatorMapperConfig(mapper);
        return mapper;
    }

    private void createAbsToCalculatorMapperConfig(ModelMapper modelMapper) {
        modelMapper.createTypeMap(
                        com.example.calculateservice.swagger.client.abs.model.FinancialProductDto.class,
                        com.example.calculateservice.swagger.server.model.FinancialProductDto.class)
            .addMappings(mapper -> {
                mapper.map(
                    FinancialProductDto::getId,
                        com.example.calculateservice.swagger.server.model.FinancialProductDto::setId);
                mapper.map(
                    FinancialProductDto::getName,
                        com.example.calculateservice.swagger.server.model.FinancialProductDto::setName);
                mapper.map(
                    FinancialProductDto::getPercent,
                        com.example.calculateservice.swagger.server.model.FinancialProductDto::setPercent);
                mapper.map(
                    FinancialProductDto::getCategory,
                        com.example.calculateservice.swagger.server.model.FinancialProductDto::setCategory);
                mapper.map(
                    FinancialProductDto::getPeriod,
                        com.example.calculateservice.swagger.server.model.FinancialProductDto::setPeriod);
                mapper.map(
                    FinancialProductDto::getCurrency,
                        com.example.calculateservice.swagger.server.model.FinancialProductDto::setCurrency);
                mapper.map(
                    FinancialProductDto::isCanDeposit,
                        com.example.calculateservice.swagger.server.model.FinancialProductDto::setCanDeposit);
                mapper.map(
                    FinancialProductDto::isCanWithdrawal,
                        com.example.calculateservice.swagger.server.model.FinancialProductDto::setCanWithdrawal);
                mapper.map(
                    FinancialProductDto::isCapitalizationToSameAccount,
                        com.example.calculateservice.swagger.server.model.FinancialProductDto::setCapitalizationToSameAccount);
                mapper.map(
                    FinancialProductDto::getCapitalizationPeriod,
                        com.example.calculateservice.swagger.server.model.FinancialProductDto::setCapitalizationPeriod);
            });

        modelMapper.createTypeMap(
                ScoredProductDto.class,
                CalculatedProductDto.class)
            .addMappings(mapper -> {
                    mapper.map(
                        ScoredProductDto::getFinancialProduct,
                        CalculatedProductDto::setFinancialProduct
                    );
                    mapper.map(
                        ScoredProductDto::getProfit,
                        CalculatedProductDto::setProfit
                    );
                    mapper.map(
                        ScoredProductDto::getProfitInPercent,
                        CalculatedProductDto::setProfitInPercent
                    );
                    mapper.map(
                        ScoredProductDto::getMatchesParameters,
                        CalculatedProductDto::setMatchesParameters
                    );
                }
            );
    }

}

