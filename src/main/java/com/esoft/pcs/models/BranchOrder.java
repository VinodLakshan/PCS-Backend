package com.esoft.pcs.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BranchOrder implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Double paddyAmount;

    private String date;

    @ManyToOne(fetch = FetchType.EAGER)
    private Branch fromBranch;

    @ManyToOne(fetch = FetchType.EAGER)
    private Branch toBranch;

    @ManyToOne(fetch = FetchType.EAGER)
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
