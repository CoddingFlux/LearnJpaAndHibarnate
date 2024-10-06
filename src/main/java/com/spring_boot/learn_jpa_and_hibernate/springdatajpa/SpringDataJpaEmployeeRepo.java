package com.spring_boot.learn_jpa_and_hibernate.springdatajpa;

import com.spring_boot.learn_jpa_and_hibernate.datamodel.EmployeeModel;
import com.spring_boot.learn_jpa_and_hibernate.services.SpringDataJpaServices;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SpringDataJpaEmployeeRepo{

    SpringDataJpaServices services;

    public SpringDataJpaEmployeeRepo(SpringDataJpaServices services) {
        this.services = services;
    }

    public void saveEmployee(EmployeeModel model){
        try {
            services.save(model);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Record saved...");
        }
    }

    public void deleteById(long id){
        try {
            services.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Record deleted...");

        }
    }

    public List<EmployeeModel> findAllData(){
        try {
            return services.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Found all Records ...");
        }
    }

    public Optional<EmployeeModel> findById(long id){
        try {
            return services.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.printf("Record found with \"%d\" EmployeeId",id);
        }
    }

    public List<EmployeeModel> findByEmail(String Email){
        try {
            return services.findByEmpEmail(Email);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.printf("Record found with \"%s\" EmployeeEmail",Email);
        }
    }

    public List<EmployeeModel> findByName(String name){
        try {
            return services.findByEmpName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.printf("Record found with \"%s\" EmployeeName",name);
        }
    }
}
