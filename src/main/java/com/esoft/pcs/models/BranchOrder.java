package com.esoft.pcs.models;

import javax.persistence.*;

@Entity
public class BranchOrder {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Double paddyAmount;

    private String date;

    @ManyToOne
    private Branch fromBranch;

    @ManyToOne
    private Branch toBranch;

    @ManyToOne
    private Vehicle vehicle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPaddyAmount() {
        return paddyAmount;
    }

    public void setPaddyAmount(Double paddyAmount) {
        this.paddyAmount = paddyAmount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Branch getFromBranch() {
        return fromBranch;
    }

    public void setFromBranch(Branch fromBranch) {
        this.fromBranch = fromBranch;
    }

    public Branch getToBranch() {
        return toBranch;
    }

    public void setToBranch(Branch toBranch) {
        this.toBranch = toBranch;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
