package com.spring_boot.learn_jpa_and_hibernate;

import com.spring_boot.learn_jpa_and_hibernate.datamodel.EmployeeModel;
import com.spring_boot.learn_jpa_and_hibernate.datamodel.StudentModel;
import com.spring_boot.learn_jpa_and_hibernate.services.SpringDataJpaServices;
import com.spring_boot.learn_jpa_and_hibernate.services.SpringJdbcServices;
import com.spring_boot.learn_jpa_and_hibernate.services.SpringJpaServices;
import com.spring_boot.learn_jpa_and_hibernate.springdatajpa.SpringDataJpaEmployeeRepo;
import com.spring_boot.learn_jpa_and_hibernate.springjdbc.SpringJdbcStudentRepo;
import org.hibernate.dialect.SybaseASEDialect;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringCommandLineRunner implements CommandLineRunner {

//    SpringJdbcStudentRunner...
//    SpringJdbcServices service;
//
//    public SpringCommandLineRunner(SpringJdbcServices service) {
//        this.service = service;
//    }

//     SpringJpaEmployeeRunner...

//    SpringJpaServices service;
//
//    public SpringCommandLineRunner(SpringJpaServices services) {
//        this.services = services;
//    }

    SpringDataJpaEmployeeRepo service;

    public SpringCommandLineRunner(SpringDataJpaEmployeeRepo service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {

//    SpringJdbcStudentRunner...
//        service.createTable("StudentInfo");
//        service.insertData(new StudentModel(1,"Rnish","8728333288","Rajkot","12std"));
//        service.insertData(new StudentModel(2,"enish","8728333288","Rajkot","12std"));
//        service.insertData(new StudentModel(3,"Renish","8728333288","Rajkot","12std"));
//        service.insertData(new StudentModel(4,"Re","8728333288","Rajkot","12std"));
//        service.deleteById(3);
//        System.out.println(service.findById(2));
//        System.out.println(service.findAll());

//        service.insertData(new EmployeeModel(1,"Rnish","r@gmail.com","8728333288","Rajkot","remote"));
//        service.insertData(new EmployeeModel(2,"enish","r1@gmail.com","8728333288","Rajkot","offline"));
//        service.insertData(new EmployeeModel(3,"Renish","r2@gmail.com","8728333288","Rajkot","remote"));
//        service.insertData(new EmployeeModel(4,"Re","r3@gmail.com","8728333288","Rajkot","hybrid"));
//
//        service.deleteById(2);
//
//        System.out.println(service.findById(1));
//
//        System.out.println(service.findAll());

//        SpringDataJpaRunner...

        service.saveEmployee(new EmployeeModel(1,"Rnish","r@gmail.com","8728333288","Rajkot","remote"));
        service.saveEmployee(new EmployeeModel(2,"enish","r1@gmail.com","8728333288","Rajkot","offline"));
        service.saveEmployee(new EmployeeModel(3,"Renish","r2@gmail.com","8728333288","Rajkot","remote"));
        service.saveEmployee(new EmployeeModel(4,"Re","r3@gmail.com","8728333288","Rajkot","hybrid"));

        System.out.println(service.findById(1));

        service.deleteById(3);

        System.out.println(service.findAllData());

        System.out.println(service.findByName("Re"));

        System.out.println(service.findByEmail("r1@gmail.com"));

    }
}
