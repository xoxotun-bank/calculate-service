package com.example.calculateservice.swagger.client.abs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import com.example.calculateservice.swagger.client.abs.model.AbsFinancialProductDto;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FinancialProductsResponseDto
 */
@Validated



public class FinancialProductsResponseDto   {
  @JsonProperty("products")
  @Valid
  private List<AbsFinancialProductDto> products = null;

  public FinancialProductsResponseDto products(List<AbsFinancialProductDto> products) {
    this.products = products;
    return this;
  }

  public FinancialProductsResponseDto addProductsItem(AbsFinancialProductDto productsItem) {
    if (this.products == null) {
      this.products = new ArrayList<>();
    }
    this.products.add(productsItem);
    return this;
  }

  /**
   * Список вкладов
   * @return products
   **/
  @Schema(description = "Список вкладов")
      @Valid
    public List<AbsFinancialProductDto> getProducts() {
    return products;
  }

  public void setProducts(List<AbsFinancialProductDto> products) {
    this.products = products;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FinancialProductsResponseDto financialProductsResponseDto = (FinancialProductsResponseDto) o;
    return Objects.equals(this.products, financialProductsResponseDto.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(products);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FinancialProductsResponseDto {\n");
    
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
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
