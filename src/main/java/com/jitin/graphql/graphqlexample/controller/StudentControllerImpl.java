package com.jitin.graphql.graphqlexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jitin.graphql.graphqlexample.service.StudentService;

import graphql.ExecutionResult;

@RequestMapping("/rest/student")
@RestController
public class StudentControllerImpl implements StudentController {
	
	@Autowired
	StudentService studentService;

	@PostMapping
	public ResponseEntity<Object> getStudent(@RequestBody String query) {
		ExecutionResult execute = studentService.getGraphQL().execute(query);

		return new ResponseEntity<>(execute, HttpStatus.OK);
	}
}
