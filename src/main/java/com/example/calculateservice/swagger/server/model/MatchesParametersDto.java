package com.example.calculateservice.swagger.server.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MatchesParametersDto
 */
@Validated



public class MatchesParametersDto   {
  @JsonProperty("period")
  private Boolean period = null;

  @JsonProperty("canDeposit")
  private Boolean canDeposit = null;

  @JsonProperty("canWithdrawal")
  private Boolean canWithdrawal = null;

  @JsonProperty("capitalizationToSameAccount")
  private Boolean capitalizationToSameAccount = null;

  @JsonProperty("capitalizationPeriod")
  private Boolean capitalizationPeriod = null;

  public MatchesParametersDto period(Boolean period) {
    this.period = period;
    return this;
  }

  /**
   * Get period
   * @return period
   **/
  @Schema(description = "")
  
    public Boolean isPeriod() {
    return period;
  }

  public void setPeriod(Boolean period) {
    this.period = period;
  }

  public MatchesParametersDto canDeposit(Boolean canDeposit) {
    this.canDeposit = canDeposit;
    return this;
  }

  /**
   * Get canDeposit
   * @return canDeposit
   **/
  @Schema(description = "")
  
    public Boolean isCanDeposit() {
    return canDeposit;
  }

  public void setCanDeposit(Boolean canDeposit) {
    this.canDeposit = canDeposit;
  }

  public MatchesParametersDto canWithdrawal(Boolean canWithdrawal) {
    this.canWithdrawal = canWithdrawal;
    return this;
  }

  /**
   * Get canWithdrawal
   * @return canWithdrawal
   **/
  @Schema(description = "")
  
    public Boolean isCanWithdrawal() {
    return canWithdrawal;
  }

  public void setCanWithdrawal(Boolean canWithdrawal) {
    this.canWithdrawal = canWithdrawal;
  }

  public MatchesParametersDto capitalizationToSameAccount(Boolean capitalizationToSameAccount) {
    this.capitalizationToSameAccount = capitalizationToSameAccount;
    return this;
  }

  /**
   * Get capitalizationToSameAccount
   * @return capitalizationToSameAccount
   **/
  @Schema(description = "")
  
    public Boolean isCapitalizationToSameAccount() {
    return capitalizationToSameAccount;
  }

  public void setCapitalizationToSameAccount(Boolean capitalizationToSameAccount) {
    this.capitalizationToSameAccount = capitalizationToSameAccount;
  }

  public MatchesParametersDto capitalizationPeriod(Boolean capitalizationPeriod) {
    this.capitalizationPeriod = capitalizationPeriod;
    return this;
  }

  /**
   * Get capitalizationPeriod
   * @return capitalizationPeriod
   **/
  @Schema(description = "")
  
    public Boolean isCapitalizationPeriod() {
    return capitalizationPeriod;
  }

  public void setCapitalizationPeriod(Boolean capitalizationPeriod) {
    this.capitalizationPeriod = capitalizationPeriod;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MatchesParametersDto matchesParametersDto = (MatchesParametersDto) o;
    return Objects.equals(this.period, matchesParametersDto.period) &&
        Objects.equals(this.canDeposit, matchesParametersDto.canDeposit) &&
        Objects.equals(this.canWithdrawal, matchesParametersDto.canWithdrawal) &&
        Objects.equals(this.capitalizationToSameAccount, matchesParametersDto.capitalizationToSameAccount) &&
        Objects.equals(this.capitalizationPeriod, matchesParametersDto.capitalizationPeriod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(period, canDeposit, canWithdrawal, capitalizationToSameAccount, capitalizationPeriod);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MatchesParametersDto {\n");
    
    sb.append("    period: ").append(toIndentedString(period)).append("\n");
    sb.append("    canDeposit: ").append(toIndentedString(canDeposit)).append("\n");
    sb.append("    canWithdrawal: ").append(toIndentedString(canWithdrawal)).append("\n");
    sb.append("    capitalizationToSameAccount: ").append(toIndentedString(capitalizationToSameAccount)).append("\n");
    sb.append("    capitalizationPeriod: ").append(toIndentedString(capitalizationPeriod)).append("\n");
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
