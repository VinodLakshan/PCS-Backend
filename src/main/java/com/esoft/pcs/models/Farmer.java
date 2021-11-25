package com.esoft.pcs.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "FARMER_TBL")
public class Farmer implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String registrationNumber;
    private Double totalMonthlyPaddyAmount;

    @OneToMany
    private List<PaddyPurchase> paddyPurchaseList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public double getTotalMonthlyPaddyAmount() {
        return totalMonthlyPaddyAmount;
    }

    public void setTotalMonthlyPaddyAmount(Double totalMonthlyPaddyAmount) {
        this.totalMonthlyPaddyAmount = totalMonthlyPaddyAmount;
    }

    public List<PaddyPurchase> getPaddyPurchaseList() {
        return paddyPurchaseList;
    }

    public void setPaddyPurchaseList(List<PaddyPurchase> paddyPurchaseList) {
        this.paddyPurchaseList = paddyPurchaseList;
    }
}
