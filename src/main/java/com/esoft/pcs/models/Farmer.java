package com.esoft.pcs.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Farmer implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String registrationNumber;
    private String name;
    private String address;
    private String telephoneNumber;
    private Double totalMonthlyPaddyAmount = 0.0;
    private String address;


    @ManyToOne(fetch = FetchType.EAGER)
    private Branch branch;

    @OneToMany
    private List<PaddyPurchase> paddyPurchaseList;

    public Farmer() {

    }

    public Farmer(Branch branch) {
        this.branch = branch;
    }

    public Farmer(Integer farmerId) {
        this.id = farmerId;
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

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


