package com.esoft.pcs.models;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@DynamicUpdate
@Data
public class PaddyTransfer implements Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Branch branch;

    @ManyToOne(fetch = FetchType.EAGER)
    private Branch ToBranch;

    private Double stock;

    private Integer status;

    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    private Vehicle vehicle;
}
