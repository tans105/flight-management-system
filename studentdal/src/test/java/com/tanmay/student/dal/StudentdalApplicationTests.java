package com.tanmay.student.dal;

import com.tanmay.student.dal.entities.Student;
import com.tanmay.student.dal.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import java.util.Optional;

@SpringBootTest
class StudentdalApplicationTests {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void testCreateStudent() {
        Student s = new Student();
        s.setCourse("abc");
        s.setFee(30d);
        s.setName("Test");

        studentRepository.save(s);
        studentRepository.delete(s);
    }

    @Test
    public void testFindStudent() {
        Optional<Student> s = studentRepository.findById(1l);
        System.out.println(s);
    }

    @Test
    public void testUpdateStudent() {
        Optional<Student> s = studentRepository.findById(1l);
        Student s1 = s.get();
        s1.setName("Tanmay do it again");
        studentRepository.save(s1);
    }
}
