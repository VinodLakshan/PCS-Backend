package com.esoft.pcs.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
//@Table(name = "FARMER")
public class Farmer implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String telephoneNumber;
    private Double totalMonthlyPaddyAmount = 0.0;
    private String address;
    private String nicNumber;


    @ManyToOne(fetch = FetchType.EAGER)
    private Branch branch;

    @OneToMany
    private List<PaddyPurchase> paddyPurchaseList;

    public Farmer() {

    }
    public Farmer(String nicNumber) {
        this.nicNumber = nicNumber;
    }

    public Farmer(Branch branch) {
        this.branch = branch;
    }

    public Farmer(Integer farmerId) {
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

    public double getTotalMonthlyPaddyAmount() {
        return totalMonthlyPaddyAmount;
    }

    public String getNicNumber() {
        return nicNumber;
    }

    public void setNicNumber(String nicNumber) {
        this.nicNumber = nicNumber;
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


