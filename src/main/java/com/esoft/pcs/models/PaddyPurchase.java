package com.esoft.pcs.models;

import javax.persistence.*;

@Entity
public class PaddyPurchase {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String date;

    private Double weight;

    @ManyToOne
    private Farmer farmer;

    @ManyToOne
    private PaddyPrice paddyPrice;

    @ManyToOne
    private Branch branch;

    @OneToOne
    private Payment payment;

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
