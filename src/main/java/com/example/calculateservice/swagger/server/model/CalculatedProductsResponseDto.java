package com.example.calculateservice.swagger.server.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import com.example.calculateservice.swagger.server.model.CalculatedProductDto;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CalculatedProductsResponseDto
 */
@Validated



public class CalculatedProductsResponseDto   {
  @JsonProperty("products")
  @Valid
  private List<CalculatedProductDto> products = null;

  public CalculatedProductsResponseDto products(List<CalculatedProductDto> products) {
    this.products = products;
    return this;
  }

  public CalculatedProductsResponseDto addProductsItem(CalculatedProductDto productsItem) {
    if (this.products == null) {
      this.products = new ArrayList<>();
    }
    this.products.add(productsItem);
    return this;
  }

  /**
   * Get products
   * @return products
   **/
  @Schema(description = "")
      @Valid
    public List<CalculatedProductDto> getProducts() {
    return products;
  }

  public void setProducts(List<CalculatedProductDto> products) {
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
    CalculatedProductsResponseDto calculatedProductsResponseDto = (CalculatedProductsResponseDto) o;
    return Objects.equals(this.products, calculatedProductsResponseDto.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(products);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalculatedProductsResponseDto {\n");
    
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
