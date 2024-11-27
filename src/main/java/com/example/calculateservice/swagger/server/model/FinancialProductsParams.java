package com.example.calculateservice.swagger.server.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FinancialProductsParams
 */
@Validated



public class FinancialProductsParams   {
  @JsonProperty("sum")
  private BigDecimal sum = null;

  @JsonProperty("categories")
  @Valid
  private List<String> categories = new ArrayList<>();

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("periods")
  @Valid
  private List<Integer> periods = null;

  @JsonProperty("canDeposit")
  private Boolean canDeposit = null;

  @JsonProperty("canWithdrawal")
  private Boolean canWithdrawal = null;

  @JsonProperty("capitalizationToSameAccount")
  private Boolean capitalizationToSameAccount = null;

  @JsonProperty("capitalizationPeriods")
  @Valid
  private List<String> capitalizationPeriods = null;

  public FinancialProductsParams sum(BigDecimal sum) {
    this.sum = sum;
    return this;
  }

  /**
   * Сумма, которую клиент хочет разместить в банке
   * minimum: 0
   * @return sum
   **/
  @Schema(example = "300000", required = true, description = "Сумма, которую клиент хочет разместить в банке")
      @NotNull

    @Valid
  @DecimalMin("0")  public BigDecimal getSum() {
    return sum;
  }

  public void setSum(BigDecimal sum) {
    this.sum = sum;
  }

  public FinancialProductsParams categories(List<String> categories) {
    this.categories = categories;
    return this;
  }

  public FinancialProductsParams addCategoriesItem(String categoriesItem) {
    this.categories.add(categoriesItem);
    return this;
  }

  /**
   * Get categories
   * @return categories
   **/
  @Schema(required = true, description = "")
      @NotNull

    public List<String> getCategories() {
    return categories;
  }

  public void setCategories(List<String> categories) {
    this.categories = categories;
  }

  public FinancialProductsParams currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Валюта вклада (Трёхбуквенный ИСО-код валюты)
   * @return currency
   **/
  @Schema(example = "RUB", required = true, description = "Валюта вклада (Трёхбуквенный ИСО-код валюты)")
      @NotNull

  @Pattern(regexp="^[A-Z]{3}$")   public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public FinancialProductsParams periods(List<Integer> periods) {
    this.periods = periods;
    return this;
  }

  public FinancialProductsParams addPeriodsItem(Integer periodsItem) {
    if (this.periods == null) {
      this.periods = new ArrayList<>();
    }
    this.periods.add(periodsItem);
    return this;
  }

  /**
   * Период вклада в днях
   * @return periods
   **/
  @Schema(description = "Период вклада в днях")
  
    public List<Integer> getPeriods() {
    return periods;
  }

  public void setPeriods(List<Integer> periods) {
    this.periods = periods;
  }

  public FinancialProductsParams canDeposit(Boolean canDeposit) {
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

  public FinancialProductsParams canWithdrawal(Boolean canWithdrawal) {
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

  public FinancialProductsParams capitalizationToSameAccount(Boolean capitalizationToSameAccount) {
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

  public FinancialProductsParams capitalizationPeriods(List<String> capitalizationPeriods) {
    this.capitalizationPeriods = capitalizationPeriods;
    return this;
  }

  public FinancialProductsParams addCapitalizationPeriodsItem(String capitalizationPeriodsItem) {
    if (this.capitalizationPeriods == null) {
      this.capitalizationPeriods = new ArrayList<>();
    }
    this.capitalizationPeriods.add(capitalizationPeriodsItem);
    return this;
  }

  /**
   * Переиодичность выплат по вкладу
   * @return capitalizationPeriods
   **/
  @Schema(description = "Переиодичность выплат по вкладу")
  
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
    FinancialProductsParams financialProductsParams = (FinancialProductsParams) o;
    return Objects.equals(this.sum, financialProductsParams.sum) &&
        Objects.equals(this.categories, financialProductsParams.categories) &&
        Objects.equals(this.currency, financialProductsParams.currency) &&
        Objects.equals(this.periods, financialProductsParams.periods) &&
        Objects.equals(this.canDeposit, financialProductsParams.canDeposit) &&
        Objects.equals(this.canWithdrawal, financialProductsParams.canWithdrawal) &&
        Objects.equals(this.capitalizationToSameAccount, financialProductsParams.capitalizationToSameAccount) &&
        Objects.equals(this.capitalizationPeriods, financialProductsParams.capitalizationPeriods);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sum, categories, currency, periods, canDeposit, canWithdrawal, capitalizationToSameAccount, capitalizationPeriods);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FinancialProductsParams {\n");
    
    sb.append("    sum: ").append(toIndentedString(sum)).append("\n");
    sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    periods: ").append(toIndentedString(periods)).append("\n");
    sb.append("    canDeposit: ").append(toIndentedString(canDeposit)).append("\n");
    sb.append("    canWithdrawal: ").append(toIndentedString(canWithdrawal)).append("\n");
    sb.append("    capitalizationToSameAccount: ").append(toIndentedString(capitalizationToSameAccount)).append("\n");
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
