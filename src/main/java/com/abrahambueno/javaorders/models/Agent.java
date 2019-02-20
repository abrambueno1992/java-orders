package com.abrahambueno.javaorders.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "agent")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agentCode;

    private String agentName;

    private String workingArea;

    private double commission;

    private String phone;

    private String country;

    public Agent(Long agentCode, String agentName, String workingArea, double commission, String phone, String country) {
        this.agentCode = agentCode;
        this.agentName = agentName;
        this.workingArea = workingArea;
        this.commission = commission;
        this.phone = phone;
        this.country = country;
    }

    public Agent() {
    }

    @OneToMany(mappedBy = "customer")
    @JoinColumn(name = "custCode")
    private Set<Customer> customers;

    public Long getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(Long agentCode) {
        this.agentCode = agentCode;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getWorkingArea() {
        return workingArea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingArea = workingArea;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
