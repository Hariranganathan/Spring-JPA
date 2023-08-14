package com.jdbc.demo.service;

import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbc.demo.model.SignUpModel;
import com.jdbc.demo.repository.JPARepository;
import com.jdbc.demo.responce.Response;

import antlr.collections.List;

@Service
public class SignUpService {

	@PersistenceContext
	EntityManager entityManager;
	
	Response rsp = new Response();

	@Autowired
	JPARepository jparepo;

public Response createUser(SignUpModel value) {
	
	try {
		String uuid = UUID.randomUUID().toString();
		value.setsNo(uuid);
		value.setCreatedBy(uuid);
		value.setUpdatedBy(uuid);
		
		jparepo.save(value);
		
		rsp.setData( "user updated successfully");
		rsp.setResponseCode(200);
		rsp.setResponsemsg("success");
	} catch (Exception e) {
		 e.printStackTrace();
		 
		 rsp.setData("cannot create successfullyss");
			rsp.setResponseCode(500);
			rsp.setResponsemsg("Error");
	}
		
		return null;
	
	}

	public Response getUser() {
		
		
		return rsp;
	}

	public Response updateUser(SignUpModel value) {
		
		try {
			Optional <SignUpModel> optObj = jparepo.findById(value.getsNo());
			
			if (optObj.isPresent()) {
				
				SignUpModel update = optObj.get();
				update.setEmailId( value.getEmailId());
				
				jparepo.save(update);
				
				rsp.setData( "user updated successfully");
				rsp.setResponseCode(200);
				rsp.setResponsemsg("success");

			} else {
				rsp.setData("No such user");
				rsp.setResponseCode(500);
				rsp.setResponsemsg("Error");
			}
		} catch (Exception e) {
			 e.printStackTrace();
			 
			 rsp.setData("Failed to delete user");
				rsp.setResponseCode(500);
				rsp.setResponsemsg("Error");
		}


		return rsp;
	}

	public Response getOneUser() {

		return rsp;
	}

	public Response deleteUser(String sNo) {
		
		try {
			jparepo.deleteById(sNo);
			
			rsp.setData("user deleted successfully");
			rsp.setResponseCode(200);
			rsp.setResponsemsg("success");
		} catch (Exception e) {
			rsp.setData("Failed to delete user");
			rsp.setResponseCode(500);
			rsp.setResponsemsg("Error");
		}

		return rsp;
	}

	public Response scamUser() {

		return rsp;
	}

	public Response loginUser(String email, String pswrd ) {
		
		try {
			
		} catch (Exception e) {
			rsp.setData("Failed to delete user");
			rsp.setResponseCode(500);
			rsp.setResponsemsg("Error");
			
		}

		return rsp;
	}
public Response login(String email, String pswrd ) {
		
		try {
			Query query = entityManager
					.createQuery("select you from SignUpModel u where u.email = email AND u.pswrd = :pswrd");
			query.setParameter("email", email);
			query.setParameter("pswrd", pswrd);
			
			List<SignUpModel> value = query.getResultList();
			
			if (value != null) {
				rsp.setData("Existing User");
				rsp.setResponseCode(200);
				rsp.setResponsemsg("Error");
				
			} else {

			}
		} catch (Exception e) {
			rsp.setData("Failed to delete user");
			rsp.setResponseCode(500);
			rsp.setResponsemsg("Error");
			
		}

		return rsp;

	

}
