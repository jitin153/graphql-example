package com.jitin.graphql.graphqlexample.service;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.jitin.graphql.graphqlexample.model.Student;
import com.jitin.graphql.graphqlexample.repository.StudentRepository;
import com.jitin.graphql.graphqlexample.service.datafetcher.StudentDataFetcher;
import com.jitin.graphql.graphqlexample.service.datafetcher.StudentsDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Value("classpath:student.graphql")
	Resource resource;

	private GraphQL graphQL;
	@Autowired
	private StudentsDataFetcher studentsDataFetcher;
	@Autowired
	private StudentDataFetcher studentDataFetcher;

	@PostConstruct
	private void loadSchema() throws IOException {
		loadStudentRecordsIntoHSQL();
		File schemaFile = resource.getFile();
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphQL = GraphQL.newGraphQL(schema).build();
	}

	private void loadStudentRecordsIntoHSQL() {
		Stream.of(new Student(1001, "Rohan Shinde", "BCA", new String[] { "DBMS", "JAVA" }),
				new Student(1002, "Manish Pandey", "BCA", new String[] { "OS", "JAVA" }),
				new Student(1003, "Rakshit Patel", "BCA", new String[] { "DBMS", "DOT NET" }),
				new Student(1004, "Ritu Chaudhary", "BCA", new String[] { "DAA", "CBOT" }),
				new Student(1005, "Anamika Shukla", "BCA", new String[] { "CN", "DE" })

		).forEach(student -> {
			studentRepository.save(student);
		});

	}

	private RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring.newRuntimeWiring().type("Query", typeWiring -> typeWiring
				.dataFetcher("students", studentsDataFetcher).dataFetcher("student", studentDataFetcher)).build();
	}

	@Override
	public GraphQL getGraphQL() {
		return graphQL;
	}
}
