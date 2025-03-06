package com.example.calculateservice.swagger.client.abs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import com.example.calculateservice.swagger.client.abs.model.FinancialProductDto;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AbsFinancialProductDto
 */
@Validated



public class AbsFinancialProductDto   {
  @JsonProperty("financialProduct")
  private FinancialProductDto financialProduct = null;

  @JsonProperty("minSum")
  private BigDecimal minSum = null;

  @JsonProperty("maxSum")
  private BigDecimal maxSum = null;

  public AbsFinancialProductDto financialProduct(FinancialProductDto financialProduct) {
    this.financialProduct = financialProduct;
    return this;
  }

  /**
   * Get financialProduct
   * @return financialProduct
   **/
  @Schema(description = "")
  
    @Valid
    public FinancialProductDto getFinancialProduct() {
    return financialProduct;
  }

  public void setFinancialProduct(FinancialProductDto financialProduct) {
    this.financialProduct = financialProduct;
  }

  public AbsFinancialProductDto minSum(BigDecimal minSum) {
    this.minSum = minSum;
    return this;
  }

  /**
   * Минимальная сумма для вклада
   * @return minSum
   **/
  @Schema(example = "5000", description = "Минимальная сумма для вклада")
  
    @Valid
    public BigDecimal getMinSum() {
    return minSum;
  }

  public void setMinSum(BigDecimal minSum) {
    this.minSum = minSum;
  }

  public AbsFinancialProductDto maxSum(BigDecimal maxSum) {
    this.maxSum = maxSum;
    return this;
  }

  /**
   * Максимальная сумма для вклада
   * @return maxSum
   **/
  @Schema(example = "5000000", description = "Максимальная сумма для вклада")
  
    @Valid
    public BigDecimal getMaxSum() {
    return maxSum;
  }

  public void setMaxSum(BigDecimal maxSum) {
    this.maxSum = maxSum;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbsFinancialProductDto absFinancialProductDto = (AbsFinancialProductDto) o;
    return Objects.equals(this.financialProduct, absFinancialProductDto.financialProduct) &&
        Objects.equals(this.minSum, absFinancialProductDto.minSum) &&
        Objects.equals(this.maxSum, absFinancialProductDto.maxSum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(financialProduct, minSum, maxSum);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AbsFinancialProductDto {\n");
    
    sb.append("    financialProduct: ").append(toIndentedString(financialProduct)).append("\n");
    sb.append("    minSum: ").append(toIndentedString(minSum)).append("\n");
    sb.append("    maxSum: ").append(toIndentedString(maxSum)).append("\n");
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
