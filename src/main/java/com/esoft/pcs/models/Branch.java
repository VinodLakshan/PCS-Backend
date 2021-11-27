package com.esoft.pcs.models;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@DynamicUpdate
public class Branch implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String address;

    private Double stock;

    private Double bankAccountAmount;

    private Double monthlyExpectedStock;

    private Double MaximumCapacity;

    private Double totalMonthlyPaddyLimitPerFarmer;

    @OneToMany()
    private List<Employee> employeeList;

    @OneToMany
    private List<PaddyPurchase> paddyPurchaseList;

    @OneToMany
    private List<PaddySale> paddySaleList;

    @OneToMany
    private List<BranchOrder> branchOrderList;

    public Branch() {
    }

    public Branch(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public Double getBankAccountAmount() {
        return bankAccountAmount;
    }

    public void setBankAccountAmount(Double bankAccountAmount) {
        this.bankAccountAmount = bankAccountAmount;
    }

    public Double getMonthlyExpectedStock() {
        return monthlyExpectedStock;
    }

    public void setMonthlyExpectedStock(Double monthlyExpectedStock) {
        this.monthlyExpectedStock = monthlyExpectedStock;
    }

    public Double getMaximumCapacity() {
        return MaximumCapacity;
    }

    public void setMaximumCapacity(Double maximumCapacity) {
        MaximumCapacity = maximumCapacity;
    }

    public Double getTotalMonthlyPaddyLimitPerFarmer() {
        return totalMonthlyPaddyLimitPerFarmer;
    }

    public void setTotalMonthlyPaddyLimitPerFarmer(Double totalMonthlyPaddyLimitPerFarmer) {
        this.totalMonthlyPaddyLimitPerFarmer = totalMonthlyPaddyLimitPerFarmer;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<PaddyPurchase> getPaddyPurchaseList() {
        return paddyPurchaseList;
    }

    public void setPaddyPurchaseList(List<PaddyPurchase> paddyPurchaseList) {
        this.paddyPurchaseList = paddyPurchaseList;
    }

    public List<PaddySale> getPaddySaleList() {
        return paddySaleList;
    }

    public void setPaddySaleList(List<PaddySale> paddySaleList) {
        this.paddySaleList = paddySaleList;
    }

    public List<BranchOrder> getBranchOrderList() {
        return branchOrderList;
    }

    public void setBranchOrderList(List<BranchOrder> branchOrderList) {
        this.branchOrderList = branchOrderList;
    }
}
