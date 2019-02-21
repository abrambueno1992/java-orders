package com.abrahambueno.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custcode;

    @Column(nullable = false)
    private  String custname;

    private String custcity;
    private String workingarea;
    private String custcountry;
    private String grade;
    private double openingamt;
    private double receiveamt;
    private double paymentamt;
    private double outstandingamt;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    @JsonIgnore
    private Agent agentcode;

    public Customer() {
    }
//     <<<<<<<<<<<<<>>>>>>>>>>>


    public Customer(String custname, String custcity, String workingarea, String custcountry, String grade, double openingamt, double receiveamt, double paymentamt, double outstandingamt, String phone, Agent agentcode) {
        this.custname = custname;
        this.custcity = custcity;
        this.workingarea = workingarea;
        this.custcountry = custcountry;
        this.grade = grade;
        this.openingamt = openingamt;
        this.receiveamt = receiveamt;
        this.paymentamt = paymentamt;
        this.outstandingamt = outstandingamt;
        this.phone = phone;
        this.agentcode = agentcode;
    }

    public Long getCustCode() {
        return custcode;
    }

    public void setCustCode(Long custcode) {
        this.custcode = custcode;
    }

    public String getCustName() {
        return custname;
    }

    public void setCustName(String custname) {
        this.custname = custname;
    }

    public String getCustCity() {
        return custcity;
    }

    public void setCustCity(String custcity) {
        this.custcity = custcity;
    }

    public String getWorkingArea() {
        return workingarea;
    }

    public void setWorkingArea(String workingarea) {
        this.workingarea = workingarea;
    }

    public String getCustCountry() {
        return custcountry;
    }

    public void setCustCountry(String custcountry) {
        this.custcountry = custcountry;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getOpeningAmt() {
        return openingamt;
    }

    public void setOpeningAmt(double openingamt) {
        this.openingamt = openingamt;
    }

    public double getReceiveAmt() {
        return receiveamt;
    }

    public void setReceiveAmt(double receiveamt) {
        this.receiveamt = receiveamt;
    }

    public double getPaymentAmt() {
        return paymentamt;
    }

    public void setPaymentAmt(double paymentamt) {
        this.paymentamt = paymentamt;
    }

    public double getOutstandingAmt() {
        return outstandingamt;
    }

    public void setOutstandingAmt(double outstandingamt) {
        this.outstandingamt = outstandingamt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Agent getAgentCode() {
        return agentcode;
    }

    public void setAgentCode(Agent agentcode) {
        this.agentcode = agentcode;
    }
}