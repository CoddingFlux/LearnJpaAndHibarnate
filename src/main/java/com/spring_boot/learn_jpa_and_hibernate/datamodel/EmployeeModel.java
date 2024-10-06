package com.spring_boot.learn_jpa_and_hibernate.datamodel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employeeinfo")
public class EmployeeModel {

    @Id
    private long empId;
    private String empName;
    private String empEmail;
    private String empContact;
    private String empAddress;
    private String empWorkMode;

    public EmployeeModel() {}

    public EmployeeModel(long empId, String empName, String empEmail, String empContact, String empAddress, String empWorkMode) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.empContact = empContact;
        this.empAddress = empAddress;
        this.empWorkMode = empWorkMode;
    }

    public long getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public String getEmpContact() {
        return empContact;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public String getEmpWorkMode() {
        return empWorkMode;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public void setEmpContact(String empContact) {
        this.empContact = empContact;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public void setEmpWorkMode(String empWorkMode) {
        this.empWorkMode = empWorkMode;
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empContact='" + empContact + '\'' +
                ", empAddress='" + empAddress + '\'' +
                ", empWorkMode='" + empWorkMode + '\'' +
                '}';
    }
}
