package com.example.calculateservice.swagger.client.abs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FinancialProductDto
 */
@Validated



public class FinancialProductDto   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("percent")
  private BigDecimal percent = null;

  @JsonProperty("category")
  private String category = null;

  @JsonProperty("period")
  private Integer period = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("canDeposit")
  private Boolean canDeposit = null;

  @JsonProperty("canWithdrawal")
  private Boolean canWithdrawal = null;

  @JsonProperty("capitalizationToSameAccount")
  private Boolean capitalizationToSameAccount = null;

  @JsonProperty("capitalizationPeriod")
  private String capitalizationPeriod = null;

  public FinancialProductDto id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(example = "12345", description = "")
  
    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public FinancialProductDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Название вклада
   * @return name
   **/
  @Schema(example = "АТБ. Вклад", description = "Название вклада")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FinancialProductDto percent(BigDecimal percent) {
    this.percent = percent;
    return this;
  }

  /**
   * Процент по вкладу в год
   * @return percent
   **/
  @Schema(example = "15.3", description = "Процент по вкладу в год")
  
    @Valid
    public BigDecimal getPercent() {
    return percent;
  }

  public void setPercent(BigDecimal percent) {
    this.percent = percent;
  }

  public FinancialProductDto category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Тип клиента, которому доступен вклад
   * @return category
   **/
  @Schema(example = "Клиент", description = "Тип клиента, которому доступен вклад")
  
    public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public FinancialProductDto period(Integer period) {
    this.period = period;
    return this;
  }

  /**
   * Период вклада в днях
   * @return period
   **/
  @Schema(example = "62", description = "Период вклада в днях")
  
    public Integer getPeriod() {
    return period;
  }

  public void setPeriod(Integer period) {
    this.period = period;
  }

  public FinancialProductDto currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Валюта вклада (Трёхбуквенный ИСО-код валюты)
   * @return currency
   **/
  @Schema(example = "RUB", description = "Валюта вклада (Трёхбуквенный ИСО-код валюты)")
  
    public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public FinancialProductDto canDeposit(Boolean canDeposit) {
    this.canDeposit = canDeposit;
    return this;
  }

  /**
   * Возможность пополнения с вклада
   * @return canDeposit
   **/
  @Schema(example = "true", description = "Возможность пополнения с вклада")
  
    public Boolean isCanDeposit() {
    return canDeposit;
  }

  public void setCanDeposit(Boolean canDeposit) {
    this.canDeposit = canDeposit;
  }

  public FinancialProductDto canWithdrawal(Boolean canWithdrawal) {
    this.canWithdrawal = canWithdrawal;
    return this;
  }

  /**
   * Возможность снятия вклада
   * @return canWithdrawal
   **/
  @Schema(example = "true", description = "Возможность снятия вклада")
  
    public Boolean isCanWithdrawal() {
    return canWithdrawal;
  }

  public void setCanWithdrawal(Boolean canWithdrawal) {
    this.canWithdrawal = canWithdrawal;
  }

  public FinancialProductDto capitalizationToSameAccount(Boolean capitalizationToSameAccount) {
    this.capitalizationToSameAccount = capitalizationToSameAccount;
    return this;
  }

  /**
   * Вклад с капитализацией на тот же акаунт
   * @return capitalizationToSameAccount
   **/
  @Schema(example = "true", description = "Вклад с капитализацией на тот же акаунт")
  
    public Boolean isCapitalizationToSameAccount() {
    return capitalizationToSameAccount;
  }

  public void setCapitalizationToSameAccount(Boolean capitalizationToSameAccount) {
    this.capitalizationToSameAccount = capitalizationToSameAccount;
  }

  public FinancialProductDto capitalizationPeriod(String capitalizationPeriod) {
    this.capitalizationPeriod = capitalizationPeriod;
    return this;
  }

  /**
   * Переиодичность выплат по вкладу
   * @return capitalizationPeriod
   **/
  @Schema(example = "Ежедневно", description = "Переиодичность выплат по вкладу")
  
    public String getCapitalizationPeriod() {
    return capitalizationPeriod;
  }

  public void setCapitalizationPeriod(String capitalizationPeriod) {
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
    FinancialProductDto financialProductDto = (FinancialProductDto) o;
    return Objects.equals(this.id, financialProductDto.id) &&
        Objects.equals(this.name, financialProductDto.name) &&
        Objects.equals(this.percent, financialProductDto.percent) &&
        Objects.equals(this.category, financialProductDto.category) &&
        Objects.equals(this.period, financialProductDto.period) &&
        Objects.equals(this.currency, financialProductDto.currency) &&
        Objects.equals(this.canDeposit, financialProductDto.canDeposit) &&
        Objects.equals(this.canWithdrawal, financialProductDto.canWithdrawal) &&
        Objects.equals(this.capitalizationToSameAccount, financialProductDto.capitalizationToSameAccount) &&
        Objects.equals(this.capitalizationPeriod, financialProductDto.capitalizationPeriod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, percent, category, period, currency, canDeposit, canWithdrawal, capitalizationToSameAccount, capitalizationPeriod);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FinancialProductDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    percent: ").append(toIndentedString(percent)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    period: ").append(toIndentedString(period)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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
