package com.example.calculateservice.swagger.client.abs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ParametersDto
 */
@Validated



public class ParametersDto   {
  @JsonProperty("currencies")
  @Valid
  private List<String> currencies = null;

  @JsonProperty("periods")
  @Valid
  private List<Integer> periods = null;

  @JsonProperty("capitalizationPeriods")
  @Valid
  private List<String> capitalizationPeriods = null;

  public ParametersDto currencies(List<String> currencies) {
    this.currencies = currencies;
    return this;
  }

  public ParametersDto addCurrenciesItem(String currenciesItem) {
    if (this.currencies == null) {
      this.currencies = new ArrayList<>();
    }
    this.currencies.add(currenciesItem);
    return this;
  }

  /**
   * Get currencies
   * @return currencies
   **/
  @Schema(example = "[\"RUB\",\"CNY\",\"USD\",\"EUR\"]", description = "")
  
    public List<String> getCurrencies() {
    return currencies;
  }

  public void setCurrencies(List<String> currencies) {
    this.currencies = currencies;
  }

  public ParametersDto periods(List<Integer> periods) {
    this.periods = periods;
    return this;
  }

  public ParametersDto addPeriodsItem(Integer periodsItem) {
    if (this.periods == null) {
      this.periods = new ArrayList<>();
    }
    this.periods.add(periodsItem);
    return this;
  }

  /**
   * Get periods
   * @return periods
   **/
  @Schema(example = "[31,62,92,122,182,243,273,365,731,1098]", description = "")
  
    public List<Integer> getPeriods() {
    return periods;
  }

  public void setPeriods(List<Integer> periods) {
    this.periods = periods;
  }

  public ParametersDto capitalizationPeriods(List<String> capitalizationPeriods) {
    this.capitalizationPeriods = capitalizationPeriods;
    return this;
  }

  public ParametersDto addCapitalizationPeriodsItem(String capitalizationPeriodsItem) {
    if (this.capitalizationPeriods == null) {
      this.capitalizationPeriods = new ArrayList<>();
    }
    this.capitalizationPeriods.add(capitalizationPeriodsItem);
    return this;
  }

  /**
   * Get capitalizationPeriods
   * @return capitalizationPeriods
   **/
  @Schema(example = "[\"Ежедневно\",\"Ежеквартально\",\"Ежемесячно\",\"Ежегодно\"]", description = "")
  
    public List<String> getCapitalizationPeriods() {
    return capitalizationPeriods;
  }

  public void setCapitalizationPeriods(List<String> capitalizationPeriods) {
    this.capitalizationPeriods = capitalizationPeriods;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParametersDto parametersDto = (ParametersDto) o;
    return Objects.equals(this.currencies, parametersDto.currencies) &&
        Objects.equals(this.periods, parametersDto.periods) &&
        Objects.equals(this.capitalizationPeriods, parametersDto.capitalizationPeriods);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currencies, periods, capitalizationPeriods);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParametersDto {\n");
    
    sb.append("    currencies: ").append(toIndentedString(currencies)).append("\n");
    sb.append("    periods: ").append(toIndentedString(periods)).append("\n");
    sb.append("    capitalizationPeriods: ").append(toIndentedString(capitalizationPeriods)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
