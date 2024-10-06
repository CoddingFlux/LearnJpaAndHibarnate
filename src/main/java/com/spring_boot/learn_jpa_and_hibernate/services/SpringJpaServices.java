package com.spring_boot.learn_jpa_and_hibernate.services;

import com.spring_boot.learn_jpa_and_hibernate.datamodel.EmployeeModel;

import java.util.List;

public interface SpringJpaServices {

    public void insertData(EmployeeModel model);
    public void deleteById(long id);
    public EmployeeModel findById(long id);
    public List<EmployeeModel> findAll();
}
