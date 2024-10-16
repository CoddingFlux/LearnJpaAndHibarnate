package com.spring_boot.learn_jpa_and_hibernate.springjdbc;

import com.spring_boot.learn_jpa_and_hibernate.datamodel.StudentModel;
import com.spring_boot.learn_jpa_and_hibernate.services.SpringJdbcServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SpringJdbcStudentRepo implements SpringJdbcServices {

    public final JdbcTemplate jt;


    private String dbName;

    public SpringJdbcStudentRepo(JdbcTemplate jt) {
        this.jt = jt;
    }

    public void createTable(String dbName){
        String sqlCreate="create table " +dbName+
                "(" +
                "stuId BIGINT," +
                "stuName VARCHAR(255)," +
                "stuContact VARCHAR(255)," +
                "stuAddress VARCHAR(255)," +
                "stuStandard VARCHAR(255)"+
                ");";
        try {
            this.dbName=dbName;
            jt.update(con -> con.prepareStatement(sqlCreate));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.printf("\"%s\" Table created...",dbName);
        }
    }

    public void insertData(StudentModel data){

        try {
            String sqlinsert="insert into "+dbName
                    +"(stuId,stuName,stuContact,stuAddress,stuStandard)" +
                    "values" +
                    "('"+data.getStuId()+"','"+data.getStuName()+"','"+data.getStuContact()+"','"+data.getStuAddress()+"','"+data.getStuStandard()+
                    "');";
            jt.update(sqlinsert);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.printf("\nStudent record insert in \"%s\" table...",dbName);
        }
    }

    public void deleteById(long id){
        try {
            String sqldelete="delete from "+dbName+" where stuId=?";
            jt.update(sqldelete,id);
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.printf("\nRecord deleted from \"%s\" table with \"%d\" Student Id..",dbName,id);
        }
    }

    public StudentModel findById(long id){
        try {
            String sqlselect="select * from "+dbName+" where stuId=?";
            return jt.queryForObject(sqlselect,new BeanPropertyRowMapper<>(StudentModel.class),id);
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.printf("\nRecord selected from \"%s\" table with \"%d\" Student Id..",dbName,id);
        }
    }

    
    public List<StudentModel> findAll(){
        try {
            String sqlselect="select * from "+dbName;
            return jt.query(sqlselect, new RowMapper<StudentModel>() {

                @Override
                public StudentModel mapRow(ResultSet rs, int rowNum) throws SQLException {

                    StudentModel model=new StudentModel();

                    model.setStuId(rs.getLong("stuId"));
                    model.setStuName(rs.getString("stuName"));
                    model.setStuContact(rs.getString("stuContact"));
                    model.setStuAddress(rs.getString("stuAddress"));
                    model.setStuStandard(rs.getString("stuStandard"));
                    return model;
                }
            });
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        } finally {

            System.out.printf("\nAll record selected from \"%s\" table..",dbName);

        }
    }
}
