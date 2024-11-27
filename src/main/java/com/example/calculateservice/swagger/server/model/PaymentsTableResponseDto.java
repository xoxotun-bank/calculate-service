package com.example.calculateservice.swagger.server.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import com.example.calculateservice.swagger.server.model.PaymentDto;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PaymentsTableResponseDto
 */
@Validated



public class PaymentsTableResponseDto   {
  @JsonProperty("payments")
  @Valid
  private List<PaymentDto> payments = new ArrayList<>();

  public PaymentsTableResponseDto payments(List<PaymentDto> payments) {
    this.payments = payments;
    return this;
  }

  public PaymentsTableResponseDto addPaymentsItem(PaymentDto paymentsItem) {
    this.payments.add(paymentsItem);
    return this;
  }

  /**
   * Get payments
   * @return payments
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<PaymentDto> getPayments() {
    return payments;
  }

  public void setPayments(List<PaymentDto> payments) {
    this.payments = payments;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentsTableResponseDto paymentsTableResponseDto = (PaymentsTableResponseDto) o;
    return Objects.equals(this.payments, paymentsTableResponseDto.payments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentsTableResponseDto {\n");
    
    sb.append("    payments: ").append(toIndentedString(payments)).append("\n");
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
