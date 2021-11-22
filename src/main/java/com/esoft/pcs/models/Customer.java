package com.esoft.pcs.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String Address;

    @OneToMany
    private List<PaddySale> paddySaleList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public List<PaddySale> getPaddySaleList() {
        return paddySaleList;
    }

    public void setPaddySaleList(List<PaddySale> paddySaleList) {
        this.paddySaleList = paddySaleList;
    }
}
