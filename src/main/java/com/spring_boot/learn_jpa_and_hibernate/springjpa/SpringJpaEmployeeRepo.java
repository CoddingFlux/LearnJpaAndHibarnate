package com.spring_boot.learn_jpa_and_hibernate.springjpa;

import com.spring_boot.learn_jpa_and_hibernate.datamodel.EmployeeModel;
import com.spring_boot.learn_jpa_and_hibernate.services.SpringJpaServices;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Transactional
public class SpringJpaEmployeeRepo implements SpringJpaServices {

    EntityManager entityManager;

    public SpringJpaEmployeeRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insertData(EmployeeModel model) {

        try {
            entityManager.merge(model);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Data inserted...");
        }

    }

    @Override
    public void deleteById(long id) {
        try {
            EmployeeModel employeeModel = entityManager.find(EmployeeModel.class, id);
            entityManager.remove(employeeModel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Data deleted...");
        }
    }

    @Override
    public EmployeeModel findById(long id) {
        try {
            return entityManager.find(EmployeeModel.class,id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.printf("Data selected with \"%d\" EmployeeId...",id);
        }
    }

    @Override
    public List<EmployeeModel> findAll() {
        try {
            String sqlselect="select e from EmployeeModel e";
            TypedQuery<EmployeeModel> tq= entityManager.createQuery(sqlselect,EmployeeModel.class);
            return tq.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("All Data selected...");
        }
    }
}
