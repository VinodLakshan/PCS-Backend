package com.esoft.pcs.dto;

public class ReportIncomeOutputDto {

    private String date;
    private Double amount;
    private String bank;
    private String status;

    public ReportIncomeOutputDto() {
    }

    public ReportIncomeOutputDto(String date, Double amount, String bank, String status) {
        this.date = date;
        this.amount = amount;
        this.bank = bank;
        this.status = status;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public String getBank() {
        return bank;
    }

    public String getStatus() {
        return status;
    }
}
