package com.esoft.pcs.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PaddyPurchase implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String date;

    private Double weight;

    @ManyToOne(fetch = FetchType.EAGER)
    private Farmer farmer;

    @ManyToOne(fetch = FetchType.EAGER)
    private PaddyPrice paddyPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    private Branch branch;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Payment payment;

    public PaddyPurchase() {
    }

    public PaddyPurchase(String date, Double weight, Farmer farmer, PaddyPrice paddyPrice, Branch branch, Payment payment) {
        this.date = date;
        this.weight = weight;
        this.farmer = farmer;
        this.paddyPrice = paddyPrice;
        this.branch = branch;
        this.payment = payment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public PaddyPrice getPaddyPrice() {
        return paddyPrice;
    }

    public void setPaddyPrice(PaddyPrice paddyPrice) {
        this.paddyPrice = paddyPrice;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
