package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "CurrencyRule", uniqueConstraints = { @UniqueConstraint( columnNames = { "CurrencyRuleName" } ) } )
public class CurrencyRule extends BaseEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "CurrencyRuleName")
    private String CurrencyRuleName;

    @Size(max = 50)
    @Column(name = "Currency")
    private String Currency;

    @Size(max = 50)
    @Column(name = "PayCurrency")
    private String PayCurrency;

    @Size(max = 50)
    @Column(name = "NetCurrency")
    private String NetCurrency;

    public String getCurrencyRuleName() {
        return CurrencyRuleName;
    }

    public void setCurrencyRuleName(String CurrencyRuleName) {
        this.CurrencyRuleName = CurrencyRuleName;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String Currency) {
        this.Currency = Currency;
    }

    public String getPayCurrency() {
        return PayCurrency;
    }

    public void setPayCurrency(String PayCurrency) {
        this.PayCurrency = PayCurrency;
    }

    public String getNetCurrency() {
        return NetCurrency;
    }

    public void setNetCurrency(String NetCurrency) {
        this.NetCurrency = NetCurrency;
    }
}
