package com.esoft.pcs.dto;

import com.esoft.pcs.models.BranchOrder;
import com.esoft.pcs.models.PaddyPurchase;
import com.esoft.pcs.models.PaddySale;

import java.util.List;

public class ReportStockOutputDto {
    private String address;
    private Double stock;
    private Double monthlyExpectedStock;
    private Double MaximumCapacity;
    private Double totalMonthlyPaddyLimitPerFarmer;

    public ReportStockOutputDto() {
    }

    public ReportStockOutputDto(String address, Double stock, Double monthlyExpectedStock, Double maximumCapacity, Double totalMonthlyPaddyLimitPerFarmer) {
        this.address = address;
        this.stock = stock;
        this.monthlyExpectedStock = monthlyExpectedStock;
        MaximumCapacity = maximumCapacity;
        this.totalMonthlyPaddyLimitPerFarmer = totalMonthlyPaddyLimitPerFarmer;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public void setMonthlyExpectedStock(Double monthlyExpectedStock) {
        this.monthlyExpectedStock = monthlyExpectedStock;
    }

    public void setMaximumCapacity(Double maximumCapacity) {
        MaximumCapacity = maximumCapacity;
    }

    public void setTotalMonthlyPaddyLimitPerFarmer(Double totalMonthlyPaddyLimitPerFarmer) {
        this.totalMonthlyPaddyLimitPerFarmer = totalMonthlyPaddyLimitPerFarmer;
    }

    public String getAddress() {
        return address;
    }

    public Double getStock() {
        return stock;
    }

    public Double getMonthlyExpectedStock() {
        return monthlyExpectedStock;
    }

    public Double getMaximumCapacity() {
        return MaximumCapacity;
    }

    public Double getTotalMonthlyPaddyLimitPerFarmer() {
        return totalMonthlyPaddyLimitPerFarmer;
    }
}
