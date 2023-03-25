package com.driver;

import com.driver.Student;
import com.driver.Teacher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class TeacherRepository {

    HashMap<Teacher, ArrayList<Student>> TeacherPairs;
    HashMap<String,Teacher> TeacherDB;


    public TeacherRepository() {
        TeacherPairs = new HashMap<>();
        TeacherDB = new HashMap<>();
    }

   public void addTeacher(Teacher teacher){
        ArrayList<Student> studentList = new ArrayList<>();
        TeacherPairs.put(teacher,studentList);
        String name = teacher.getName();
        TeacherDB.put(name,teacher);

    }

    public Teacher getTeacher(String name){
        return TeacherDB.get(name);
    }

    public List<Student> getStudents(Teacher teacher){
        return TeacherPairs.get(teacher);
    }

    public void deleteTeacher(Teacher teacher){

        TeacherPairs.remove(teacher);
        TeacherDB.remove(teacher.getName());
    }

    public void deleteAll(){
        TeacherPairs.clear();
        TeacherDB.clear();
    }

    public void pairStudentTeacher(Student student,Teacher teacher){
        ArrayList<Student> SList = TeacherPairs.get(teacher);

        SList.add(student);

        TeacherPairs.put(teacher,SList);
    }
}
