package com.driver.Repository;

import com.driver.Model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String, Student> StudentDB ;

    public StudentRepository() {
        StudentDB = new HashMap<>();
    }

    public void addStudent(String name,Student student){
        StudentDB.put(name,student);
    }

    public Student getStudent(String name){
        return StudentDB.get(name);
    }
    public List<String> getAllStudents(){
        List<String> st = new ArrayList<>();

        for(String name:StudentDB.keySet()){
            st.add(name);
        }
        return st;
    }
}
