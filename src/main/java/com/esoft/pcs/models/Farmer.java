package com.esoft.pcs.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@DynamicUpdate
public class Farmer implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String registrationNumber;

    private Double totalMonthlyPaddyAmount = 0.0;

    @OneToMany
    private List<PaddyPurchase> paddyPurchaseList;

    public Farmer() {
    }

    public Farmer(Integer id) {
        this.id = id;
    }

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
