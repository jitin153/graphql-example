package com.jitin.graphql.graphqlexample.repository;

import com.jitin.graphql.graphqlexample.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
