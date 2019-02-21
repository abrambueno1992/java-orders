package com.abrahambueno.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordnum;

    private double ordamount;
    private double advanceamount;

    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnore
    private Customer custcode;

    @ManyToOne
    @JoinColumn(name = "agentcode")
    @JsonIgnore
    private Agent agentcode;

    private String orddescription;

    public Order() {
    }

    public Order(double ordamount, double advanceamount, Customer custcode, Agent agentcode, String orddescription) {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.custcode = custcode;
        this.agentcode = agentcode;
        this.orddescription = orddescription;
    }

    public Long getOrdNum() {
        return ordnum;
    }

    public void setOrdNum(Long ordnum) {
        this.ordnum = ordnum;
    }

    public double getOrdAmount() {
        return ordamount;
    }

    public void setOrdAmount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceAmount() {
        return advanceamount;
    }

    public void setAdvanceAmount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public Customer getCustCode() {
        return custcode;
    }

    public void setCustCode(Customer custcode) {
        this.custcode = custcode;
    }

    public Agent getAgentCode() {
        return agentcode;
    }

    public void setAgentCode(Agent agentcode) {
        this.agentcode = agentcode;
    }

    public String getOrdDescription() {
        return orddescription;
    }

    public void setOrdDescription(String orddescription) {
        this.orddescription = orddescription;
    }
}