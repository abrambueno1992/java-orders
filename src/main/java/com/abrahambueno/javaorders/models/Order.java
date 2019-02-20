package com.abrahambueno.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordNum;

    private double ordAmount;
    private double advanceAmount;

    @ManyToOne
    @JoinColumn(name = "custCode", nullable = false)
    @JsonIgnore
    private Customer custCode;

    @ManyToOne
    @JoinColumn(name = "agentCode")
    @JsonIgnore
    private Agent agentCode;

    private String ordDescription;

    public Order() {
    }

    public Order(double ordAmount, double advanceAmount, Customer custCode, Agent agentCode, String ordDescription) {
        this.ordAmount = ordAmount;
        this.advanceAmount = advanceAmount;
        this.custCode = custCode;
        this.agentCode = agentCode;
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

    public Customer getCustCode() {
        return custCode;
    }

    public void setCustCode(Customer custCode) {
        this.custCode = custCode;
    }

    public Agent getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(Agent agentCode) {
        this.agentCode = agentCode;
    }

    public String getOrdDescription() {
        return ordDescription;
    }

    public void setOrdDescription(String ordDescription) {
        this.ordDescription = ordDescription;
    }
}
