package com.abrahambueno.javaorders.models;

import javax.persistence.*;

@Entity
@Table(name = "agents")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agentcode;

    private String agentname;
    private String workingarea;
    private double commission;
    private String phone;
    private String country;

    public Agent() {
    }


    public Agent(String agentname, String workingarea, double commission, String phone, String country) {
        this.agentname = agentname;
        this.workingarea = workingarea;
        this.commission = commission;
        this.phone = phone;
        this.country = country;
    }

    public Long getAgentCode() {
        return agentcode;
    }

    public void setAgentCode(Long agentcode) {
        this.agentcode = agentcode;
    }

    public String getAgentName() {
        return agentname;
    }

    public void setAgentName(String agentname) {
        this.agentname = agentname;
    }

    public String getWorkingArea() {
        return workingarea;
    }

    public void setWorkingArea(String workingarea) {
        this.workingarea = workingarea;
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