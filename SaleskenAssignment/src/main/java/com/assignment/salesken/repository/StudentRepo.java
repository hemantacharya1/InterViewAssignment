package com.assignment.salesken.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.salesken.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}
