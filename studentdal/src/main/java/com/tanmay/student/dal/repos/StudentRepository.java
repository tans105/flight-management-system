package com.tanmay.student.dal.repos;

import com.tanmay.student.dal.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * @author Tanmay
 * @date 30/11/19
 **/

@Component
public interface StudentRepository extends CrudRepository<Student, Long> {
    /*
    The single class will take care of all the CRUD operations for student table
     */
}
