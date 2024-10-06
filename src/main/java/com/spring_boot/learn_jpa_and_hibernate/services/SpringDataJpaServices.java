package com.spring_boot.learn_jpa_and_hibernate.services;

import com.spring_boot.learn_jpa_and_hibernate.datamodel.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaServices extends JpaRepository<EmployeeModel,Long> {

    public List<EmployeeModel> findByEmpEmail(String empEmail);
    public List<EmployeeModel> findByEmpName(String empName);

}
