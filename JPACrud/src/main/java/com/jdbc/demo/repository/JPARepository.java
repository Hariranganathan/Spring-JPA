package com.jdbc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdbc.demo.model.SignUpModel;

public interface JPARepository extends JpaRepository<SignUpModel, String>{

}
