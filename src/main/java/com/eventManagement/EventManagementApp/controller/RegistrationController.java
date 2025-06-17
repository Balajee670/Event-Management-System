package com.eventManagement.EventManagementApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventManagement.EventManagementApp.dao.EventDao;
import com.eventManagement.EventManagementApp.entity.Event;
import com.eventManagement.EventManagementApp.entity.Registration;
import com.eventManagement.EventManagementApp.service.RegistrationService;
import com.eventManagement.EventManagementApp.service.ResponseStructure;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private EventDao eventDao;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Registration>> createRegistration(@RequestBody Registration registration){
		return registrationService.createRegistration(registration);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Registration>>> getAllRegistration(){
		return registrationService.getAllRegistration();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Registration>> getRegistrationById(@PathVariable Integer id){
		return registrationService.getRegistrationById(id);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Registration>> deleteRegistration(@PathVariable Integer id){
		return registrationService.deleteRegistration(id);
	}
	@GetMapping("/registrationsByEventId/{id}")
	public ResponseEntity<ResponseStructure<List<Registration>>> getRegistrationByEventId(@PathVariable Integer id){
		return registrationService.getRegistrationByEventId(id);
	}
	@GetMapping("/registrationsByAttendeeId/{id}")
	public ResponseEntity<ResponseStructure<List<Registration>>> getRegistrationByAttendeeId(@PathVariable Integer id){
		return registrationService.getRegistrationByAttendeeId(id);
	}
	

}
