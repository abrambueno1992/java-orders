package com.abrahambueno.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordNum;

    private double ordAmount;

    private double advanceAmount;

    @ManyToOne()
    @JoinColumn(name = "custCode", nullable = false)
    @JsonIgnore
    private Customer customer;


    @Column(nullable = false)
    @OneToMany(mappedBy = "order")
    @JoinColumn(name = "custCode")
    @JsonIgnore
    private Set<Order> orders;

    private String ordDescription;

    public Order(Long ordNum, double ordAmount, double advanceAmount, String ordDescription) {
        this.ordNum = ordNum;
        this.ordAmount = ordAmount;
        this.advanceAmount = advanceAmount;

        this.ordDescription = ordDescription;
    }

    public Long getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(Long ordNum) {
        this.ordNum = ordNum;
    }

    public double getOrdAmount() {
        return ordAmount;
    }

    public void setOrdAmount(double ordAmount) {
        this.ordAmount = ordAmount;
    }

    public double getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(double advanceAmount) {
        this.advanceAmount = advanceAmount;
    }



    public String getOrdDescription() {
        return ordDescription;
    }

    public void setOrdDescription(String ordDescription) {
        this.ordDescription = ordDescription;
    }
}
