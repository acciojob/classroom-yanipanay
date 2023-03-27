package com.driver;

import com.driver.Student;
import com.driver.Teacher;
import com.driver.StudentRepository;
import com.driver.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository = new StudentRepository();
    TeacherRepository teacherRepository = new TeacherRepository();
    public StudentService() {
    }

    public void addStudent(Student student){
        String name = student.getName();

        studentRepository.addStudent(name,student);
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.addTeacher(teacher);
    }

    public Student getStudent(String name){
        return studentRepository.getStudent(name);
    }

    public Teacher getTeacher(String name){
        return teacherRepository.getTeacher(name);
    }
    public List<String> getListByTeacher(String teacherName){
        Teacher teacher = teacherRepository.getTeacher(teacherName);

        List<Student> Slist;
        Slist = teacherRepository.getStudents(teacher);

        List<String> StudentList = new ArrayList<>();

        for(Student s:Slist){
            StudentList.add(s.getName());
        }
        return StudentList;
    }

    public List<String> getAll() {
        return studentRepository.getAllStudents();
    }

    public void deleteTeacher(String teacherName){
        Teacher teacher = teacherRepository.getTeacher(teacherName);
        List<String> students = getListByTeacher(teacherName);
        for(String nam: students){
            studentRepository.removeStudent(nam);
        }
        teacherRepository.deleteTeacher(teacher);
    }

    public void deleteAllTeachers(){
        teacherRepository.deleteAll();
    }

    public void pairStudentTeacher(String studentName,String teacherName){
        Student student = studentRepository.getStudent(studentName);
        Teacher teacher = teacherRepository.getTeacher(teacherName);
        teacherRepository.pairStudentTeacher(student,teacher);
    }
}
