package com.example.calculateservice.swagger.server.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PaymentDto
 */
@Validated



public class PaymentDto   {
  @JsonProperty("date")
  private LocalDate date = null;

  @JsonProperty("paymentAmount")
  private BigDecimal paymentAmount = null;

  @JsonProperty("percent")
  private BigDecimal percent = null;

  @JsonProperty("daysAmount")
  private Integer daysAmount = null;

  public PaymentDto date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Дата выплаты по вкладу
   * @return date
   **/
  @Schema(required = true, description = "Дата выплаты по вкладу")
      @NotNull

    @Valid
    public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public PaymentDto paymentAmount(BigDecimal paymentAmount) {
    this.paymentAmount = paymentAmount;
    return this;
  }

  /**
   * Выплата по вкладу в валюте на указанное число
   * @return paymentAmount
   **/
  @Schema(example = "123.45", required = true, description = "Выплата по вкладу в валюте на указанное число")
      @NotNull

    @Valid
    public BigDecimal getPaymentAmount() {
    return paymentAmount;
  }

  public void setPaymentAmount(BigDecimal paymentAmount) {
    this.paymentAmount = paymentAmount;
  }

  public PaymentDto percent(BigDecimal percent) {
    this.percent = percent;
    return this;
  }

  /**
   * Выплата по вкладу в процентах на указанное число
   * @return percent
   **/
  @Schema(example = "0.96", required = true, description = "Выплата по вкладу в процентах на указанное число")
      @NotNull

    @Valid
    public BigDecimal getPercent() {
    return percent;
  }

  public void setPercent(BigDecimal percent) {
    this.percent = percent;
  }

  public PaymentDto daysAmount(Integer daysAmount) {
    this.daysAmount = daysAmount;
    return this;
  }

  /**
   * Количество дней в периоде, за который будет осуществлена выплата
   * @return daysAmount
   **/
  @Schema(example = "31", required = true, description = "Количество дней в периоде, за который будет осуществлена выплата")
      @NotNull

    public Integer getDaysAmount() {
    return daysAmount;
  }

  public void setDaysAmount(Integer daysAmount) {
    this.daysAmount = daysAmount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentDto paymentDto = (PaymentDto) o;
    return Objects.equals(this.date, paymentDto.date) &&
        Objects.equals(this.paymentAmount, paymentDto.paymentAmount) &&
        Objects.equals(this.percent, paymentDto.percent) &&
        Objects.equals(this.daysAmount, paymentDto.daysAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, paymentAmount, percent, daysAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentDto {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    paymentAmount: ").append(toIndentedString(paymentAmount)).append("\n");
    sb.append("    percent: ").append(toIndentedString(percent)).append("\n");
    sb.append("    daysAmount: ").append(toIndentedString(daysAmount)).append("\n");
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
