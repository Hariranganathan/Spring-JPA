package com.jdbc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.demo.model.SignUpModel;
import com.jdbc.demo.responce.Response;
import com.jdbc.demo.service.SignUpService;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class SignUpController {

	@Autowired
	SignUpService jpa;

	@PostMapping("/create")
	public ResponseEntity<Response> createUser(@RequestBody SignUpModel value) {
		return ResponseEntity.ok(jpa.createUser(value));
	}

	public ResponseEntity<Response> getUser() {
		return ResponseEntity.ok(jpa.getUser());
	}

	public ResponseEntity<Response> updateUser() {
		return ResponseEntity.ok(jpa.updateUser(null));
	}

	public ResponseEntity<Response> getOneUser() {
		return ResponseEntity.ok(jpa.getOneUser());
	}

	public ResponseEntity<Response> deleteUser() {
		return ResponseEntity.ok(jpa.deleteUser());
	}

	public ResponseEntity<Response> scamUser() {
		return ResponseEntity.ok(jpa.scamUser());
	}
	@PostMapping ("/login")
	public ResponseEntity<Response> loginUser(@RequestParam String email,String pswrd) {
		return ResponseEntity.ok(jpa.loginUser(email,pswrd));
	}
	
}
