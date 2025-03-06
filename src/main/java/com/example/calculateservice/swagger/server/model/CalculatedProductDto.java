package com.example.calculateservice.swagger.server.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CalculatedProductDto
 */
@Validated



public class CalculatedProductDto   {
  @JsonProperty("financialProduct")
  private FinancialProductDto financialProduct = null;

  @JsonProperty("profit")
  private BigDecimal profit = null;

  @JsonProperty("profitInPercent")
  private BigDecimal profitInPercent = null;

  @JsonProperty("matchesParameters")
  private MatchesParametersDto matchesParameters = null;

  public CalculatedProductDto financialProduct(FinancialProductDto financialProduct) {
    this.financialProduct = financialProduct;
    return this;
  }

  /**
   * Get financialProduct
   * @return financialProduct
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public FinancialProductDto getFinancialProduct() {
    return financialProduct;
  }

  public void setFinancialProduct(FinancialProductDto financialProduct) {
    this.financialProduct = financialProduct;
  }

  public CalculatedProductDto profit(BigDecimal profit) {
    this.profit = profit;
    return this;
  }

  /**
   * Get profit
   * @return profit
   **/
  @Schema(example = "36857.33", required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getProfit() {
    return profit;
  }

  public void setProfit(BigDecimal profit) {
    this.profit = profit;
  }

  public CalculatedProductDto profitInPercent(BigDecimal profitInPercent) {
    this.profitInPercent = profitInPercent;
    return this;
  }

  /**
   * Get profitInPercent
   * @return profitInPercent
   **/
  @Schema(example = "8.36", required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getProfitInPercent() {
    return profitInPercent;
  }

  public void setProfitInPercent(BigDecimal profitInPercent) {
    this.profitInPercent = profitInPercent;
  }

  public CalculatedProductDto matchesParameters(MatchesParametersDto matchesParameters) {
    this.matchesParameters = matchesParameters;
    return this;
  }

  /**
   * Get matchesParameters
   * @return matchesParameters
   **/
  @Schema(description = "")
  
    @Valid
    public MatchesParametersDto getMatchesParameters() {
    return matchesParameters;
  }

  public void setMatchesParameters(MatchesParametersDto matchesParameters) {
    this.matchesParameters = matchesParameters;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalculatedProductDto calculatedProductDto = (CalculatedProductDto) o;
    return Objects.equals(this.financialProduct, calculatedProductDto.financialProduct) &&
        Objects.equals(this.profit, calculatedProductDto.profit) &&
        Objects.equals(this.profitInPercent, calculatedProductDto.profitInPercent) &&
        Objects.equals(this.matchesParameters, calculatedProductDto.matchesParameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(financialProduct, profit, profitInPercent, matchesParameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalculatedProductDto {\n");
    
    sb.append("    financialProduct: ").append(toIndentedString(financialProduct)).append("\n");
    sb.append("    profit: ").append(toIndentedString(profit)).append("\n");
    sb.append("    profitInPercent: ").append(toIndentedString(profitInPercent)).append("\n");
    sb.append("    matchesParameters: ").append(toIndentedString(matchesParameters)).append("\n");
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
