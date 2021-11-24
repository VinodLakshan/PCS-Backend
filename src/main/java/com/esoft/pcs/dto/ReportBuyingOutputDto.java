package com.esoft.pcs.dto;

import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.Farmer;
import com.esoft.pcs.models.PaddyPrice;
import com.esoft.pcs.models.Payment;


public class ReportBuyingOutputDto {
    private String date;
    private Double weight;
    private Farmer farmer;
    private PaddyPrice paddyPrice;
    private Branch branch;
    private Payment payment;

    public ReportBuyingOutputDto() {
    }

    public ReportBuyingOutputDto(String date, Double weight, Farmer farmer, PaddyPrice paddyPrice, Branch branch, Payment payment) {
        this.date = date;
        this.weight = weight;
        this.farmer = farmer;
        this.paddyPrice = paddyPrice;
        this.branch = branch;
        this.payment = payment;
    }

    public String getDate() {
        return date;
    }

    public Double getWeight() {
        return weight;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public PaddyPrice getPaddyPrice() {
        return paddyPrice;
    }

    public Branch getBranch() {
        return branch;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public void setPaddyPrice(PaddyPrice paddyPrice) {
        this.paddyPrice = paddyPrice;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
