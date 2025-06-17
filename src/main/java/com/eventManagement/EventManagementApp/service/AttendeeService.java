package com.eventManagement.EventManagementApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.eventManagement.EventManagementApp.dao.AttendeeDao;
import com.eventManagement.EventManagementApp.entity.Attendee;
import com.eventManagement.EventManagementApp.entity.Registration;
import com.eventManagement.EventManagementApp.exception.IdNotFoundException;
import com.eventManagement.EventManagementApp.exception.NoRecordAvailableException;

@Service
public class AttendeeService {
	
	@Autowired
	private AttendeeDao attendeeDao;
	
	public ResponseEntity<ResponseStructure<Attendee>> registerAttendee(Attendee attendee){
		Attendee registerAttendee = attendeeDao.registerAttendee(attendee);
		ResponseStructure<Attendee> structure = new ResponseStructure<Attendee>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Attendee Registered");
		structure.setData(attendee);
		return new ResponseEntity<ResponseStructure<Attendee>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Attendee>>> getAllAttendee(){
		List<Attendee> attendee = attendeeDao.getAllAttendee();
		if(!attendee.isEmpty()) {
		ResponseStructure<List<Attendee>> structure = new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Record Fetched");
		structure.setData(attendee);
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}
		else{
		throw new NoRecordAvailableException("No Records to show");
	    }
    }
	
	public ResponseEntity<ResponseStructure<Attendee>> getAttendeeById(@PathVariable Integer id){
		Optional<Attendee> opt = attendeeDao.getAttendeeById(id);
		if(opt.isPresent()) {
			ResponseStructure<Attendee> structure = new ResponseStructure<>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Fetched By Id");
			structure.setData(opt.get());
			return new ResponseEntity<>(structure,HttpStatus.OK);
		}
		else {
			return null;
		}
		
	}
	public ResponseEntity<ResponseStructure<Attendee>> updateAttendee(@RequestBody Attendee attendee){
		Attendee att = attendeeDao.updateAttendee(attendee);
		ResponseStructure<Attendee> structure = new ResponseStructure<Attendee>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Record Updated");
		structure.setData(att);
		return new ResponseEntity<>(structure,HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResponseStructure<Attendee>> deleteAttendee(@PathVariable Integer Id){
		Optional<Attendee> opt = attendeeDao.getAttendeeById(Id);
		if(opt.isPresent()) {
			attendeeDao.deleteAttendee(opt.get());
			ResponseStructure<Attendee> structure = new ResponseStructure<>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Deleted Successful");
			structure.setData(opt.get());
			return new ResponseEntity<>(structure,HttpStatus.OK);
			
		}
		else {
			throw new IdNotFoundException("Id is  Unavailable");
		}
		
	}
	
	public ResponseEntity<ResponseStructure<List<Registration>>> getRegistrationById(@PathVariable Integer id){
		Optional<Attendee> opt = attendeeDao.getRegistrationById(id);
		if(opt.isPresent()) {
			ResponseStructure<List<Registration>> structure = new ResponseStructure<>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Fetched By registration Id");
			structure.setData(opt.get().getRegistrations());
			return new ResponseEntity<>(structure,HttpStatus.OK);	
			}
		else {
			throw new NoRecordAvailableException("Registration Not Found");
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Attendee>> getAttendeeByContactNumber(@PathVariable Long contact){
		Attendee attendee = attendeeDao.getAttendeeByContactNumber(contact);
	//	if(!attendee.isEmpty()) {
		ResponseStructure<Attendee> structure = new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Fetched By Contact");
		structure.setData(attendee);
		return new ResponseEntity<>(structure,HttpStatus.OK);
		
	}
//		else {
//			throw new NoRecordAvailableException("Ateendee Not Found");
//		}
	
	}	
	
	

