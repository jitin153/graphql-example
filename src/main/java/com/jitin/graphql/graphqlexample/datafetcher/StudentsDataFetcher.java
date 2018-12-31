package com.jitin.graphql.graphqlexample.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jitin.graphql.graphqlexample.model.Student;
import com.jitin.graphql.graphqlexample.repository.StudentRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class StudentsDataFetcher implements DataFetcher<List<Student>> {
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> get(DataFetchingEnvironment dataFetchingEnvironment) {
		return studentRepository.findAll();
	}
}
