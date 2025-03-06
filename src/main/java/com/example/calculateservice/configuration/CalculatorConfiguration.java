package com.example.calculateservice.configuration;

import com.example.calculateservice.calculator.CapitalizationType;
import com.example.calculateservice.calculator.impl.CapitalizationCalculator;
import com.example.calculateservice.calculator.provider.impl.MonthPeriodProvider;
import com.example.calculateservice.calculator.provider.impl.QuarterPeriodProvider;
import org.springframework.context.annotation.*;

@Configuration
public class CalculatorConfiguration {

    @Bean
    public CapitalizationCalculator monthlyCapitalizationCalculator(
        MonthPeriodProvider periodProvider
    ) {
        return new CapitalizationCalculator(periodProvider, CapitalizationType.MONTHLY);
    }

    @Bean
    public CapitalizationCalculator quarterlyCapitalizationCalculator(
        QuarterPeriodProvider periodProvider
    ) {
        return new CapitalizationCalculator(periodProvider, CapitalizationType.QUARTERLY);
    }

}
