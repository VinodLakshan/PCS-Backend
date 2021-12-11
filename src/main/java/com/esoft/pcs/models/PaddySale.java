package com.esoft.pcs.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PaddySale implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String date;

    private Double weight;

    private Integer status;

    @ManyToOne
    private PaddyPrice paddyPrice;

    @ManyToOne
    private Branch branch;

    @ManyToOne
    private Customer customer;

    @OneToOne
    private Payment payment;

    public PaddySale(){

    }

    public PaddySale(Integer id, String date, Double weight, Integer status, PaddyPrice paddyPrice, Branch branch, Customer customer, Payment payment) {
        this.id = id;
        this.date = date;
        this.weight = weight;
        this.status = status;
        this.paddyPrice = paddyPrice;
        this.branch = branch;
        this.customer = customer;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
