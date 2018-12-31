package com.jitin.graphql.graphqlexample.service.datafetcher;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jitin.graphql.graphqlexample.model.Student;
import com.jitin.graphql.graphqlexample.repository.StudentRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class StudentDataFetcher implements DataFetcher<Student> {
	private static final Logger LOG = LoggerFactory.getLogger(StudentDataFetcher.class);
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student get(DataFetchingEnvironment dataFetchingEnvironment) {
		Integer id = dataFetchingEnvironment.getArgument("id");
		Optional<Student> otionalStudent = studentRepository.findById(id);
		Student student = new Student();
		if (otionalStudent.isPresent()) {
			student = otionalStudent.get();
		} else {
			LOG.error("Student not present!");
		}
		return student;
	}
}
