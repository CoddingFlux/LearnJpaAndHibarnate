package com.spring_boot.learn_jpa_and_hibernate.services;

import com.spring_boot.learn_jpa_and_hibernate.datamodel.StudentModel;

import java.util.List;

public interface SpringJdbcServices {
    public void createTable(String dbName);

    public void insertData(StudentModel data);

    public void deleteById(long id);

    public StudentModel findById(long id);

    public List<StudentModel> findAll();

}
