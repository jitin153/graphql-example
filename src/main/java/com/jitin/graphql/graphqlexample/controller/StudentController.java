package com.jitin.graphql.graphqlexample.controller;

import org.springframework.http.ResponseEntity;

public interface StudentController {
	public ResponseEntity<Object> getStudent(String query);
}
