package com.abrahambueno.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custcode;

    @Column(nullable = false)
    private  String custname;

    private String custcity;
    private String workingArea;
    private String custCountry;
    private String grade;
    private double openingAmt;
    private double receiveAmt;
    private double paymentAmt;
    private double outstandingAmt;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "agentCode", nullable = false)
    @JsonIgnore
    private Agent agentCode;

    public Customer() {
    }
//     <<<<<<<<<<<<<>>>>>>>>>>>


    public Customer(String custname, String custcity, String workingArea, String custCountry, String grade, double openingAmt, double receiveAmt, double paymentAmt, double outstandingAmt, String phone, Agent agentCode) {
        this.custname = custname;
        this.custcity = custcity;
        this.workingArea = workingArea;
        this.custCountry = custCountry;
        this.grade = grade;
        this.openingAmt = openingAmt;
        this.receiveAmt = receiveAmt;
        this.paymentAmt = paymentAmt;
        this.outstandingAmt = outstandingAmt;
        this.phone = phone;
        this.agentCode = agentCode;
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
        return workingArea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingArea = workingArea;
    }

    public String getCustCountry() {
        return custCountry;
    }

    public void setCustCountry(String custCountry) {
        this.custCountry = custCountry;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getOpeningAmt() {
        return openingAmt;
    }

    public void setOpeningAmt(double openingAmt) {
        this.openingAmt = openingAmt;
    }

    public double getReceiveAmt() {
        return receiveAmt;
    }

    public void setReceiveAmt(double receiveAmt) {
        this.receiveAmt = receiveAmt;
    }

    public double getPaymentAmt() {
        return paymentAmt;
    }

    public void setPaymentAmt(double paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public double getOutstandingAmt() {
        return outstandingAmt;
    }

    public void setOutstandingAmt(double outstandingAmt) {
        this.outstandingAmt = outstandingAmt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Agent getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(Agent agentCode) {
        this.agentCode = agentCode;
    }
}
