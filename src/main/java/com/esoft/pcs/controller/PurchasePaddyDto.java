package com.esoft.pcs.controller;

public class PurchasePaddyDto {

    private Integer farmerId;
    private Integer branchId;
    private Integer paddyPriceId;
    private Double weight;
    private Double paymentAmount;
    private String date;

    public Integer getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Integer farmerId) {
        this.farmerId = farmerId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getPaddyPriceId() {
        return paddyPriceId;
    }

    public void setPaddyPriceId(Integer paddyPriceId) {
        this.paddyPriceId = paddyPriceId;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
