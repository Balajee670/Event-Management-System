package com.eventManagement.EventManagementApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventManagement.EventManagementApp.entity.Attendee;
import com.eventManagement.EventManagementApp.entity.Registration;
import com.eventManagement.EventManagementApp.service.AttendeeService;
import com.eventManagement.EventManagementApp.service.ResponseStructure;

@RestController
@RequestMapping("/attendee")
public class AttendeeController {
	
	@Autowired
	private AttendeeService attendeeService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Attendee>> registerAttendee(@RequestBody Attendee attendee){
		return attendeeService.registerAttendee(attendee);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Attendee>>> getAllAttendee(){
		return attendeeService.getAllAttendee();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Attendee>> getAttendeeById(@PathVariable Integer id){
		return attendeeService.getAttendeeById(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Attendee>> updateAttendee(@RequestBody Attendee attendee){
		return attendeeService.updateAttendee(attendee);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Attendee>> deleteAttendee(@PathVariable Integer id){
		return attendeeService.deleteAttendee(id);
	}
	@GetMapping("/registration/{id}")
	public ResponseEntity<ResponseStructure<List<Registration>>> getRegistrationById(@PathVariable Integer id){
		return attendeeService.getRegistrationById(id);
	}
	
	@GetMapping("/contact/{contact}")
	public ResponseEntity<ResponseStructure<Attendee>> getAttendeeByContactNumber(@PathVariable Long contact){
		return attendeeService.getAttendeeByContactNumber(contact);
	}

}
