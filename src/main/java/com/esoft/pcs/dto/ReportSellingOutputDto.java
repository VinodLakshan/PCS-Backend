package com.esoft.pcs.dto;

import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.Customer;
import com.esoft.pcs.models.PaddyPrice;
import com.esoft.pcs.models.Payment;


public class ReportSellingOutputDto {
    private String date;
    private Double weight;
    private PaddyPrice paddyPrice;
    private Branch branch;
    private Customer customer;
    private Payment payment;

    public ReportSellingOutputDto() {
    }

    public ReportSellingOutputDto(String date, Double weight, PaddyPrice paddyPrice, Branch branch, Customer customer, Payment payment) {
        this.date = date;
        this.weight = weight;
        this.paddyPrice = paddyPrice;
        this.branch = branch;
        this.customer = customer;
        this.payment = payment;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setPaddyPrice(PaddyPrice paddyPrice) {
        this.paddyPrice = paddyPrice;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getDate() {
        return date;
    }

    public Double getWeight() {
        return weight;
    }

    public PaddyPrice getPaddyPrice() {
        return paddyPrice;
    }

    public Branch getBranch() {
        return branch;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Payment getPayment() {
        return payment;
    }
}
