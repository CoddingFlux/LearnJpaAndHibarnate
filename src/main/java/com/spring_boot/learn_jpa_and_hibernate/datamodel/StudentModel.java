package com.spring_boot.learn_jpa_and_hibernate.datamodel;

import org.springframework.stereotype.Component;

@Component
public class StudentModel {

    private long stuId;
    private String stuName;
    private String stuContact;
    private String stuAddress;
    private String stuStandard;

    public StudentModel() {}

    public StudentModel(long stuId, String stuName, String stuContact, String stuAddress, String stuStandard) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuContact = stuContact;
        this.stuAddress = stuAddress;
        this.stuStandard = stuStandard;
    }

    public long getStuId() {
        return stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public String getStuContact() {
        return stuContact;
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public String getStuStandard() {
        return stuStandard;
    }

    public void setStuId(long stuId) {
        this.stuId = stuId;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setStuContact(String stuContact) {
        this.stuContact = stuContact;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    public void setStuStandard(String stuStandard) {
        this.stuStandard = stuStandard;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuContact='" + stuContact + '\'' +
                ", stuAddress='" + stuAddress + '\'' +
                ", stuStandard='" + stuStandard + '\'' +
                '}';
    }
}
