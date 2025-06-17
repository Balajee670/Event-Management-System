package com.eventManagement.EventManagementApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.eventManagement.EventManagementApp.dao.EventDao;
import com.eventManagement.EventManagementApp.dao.RegistrationDao;
import com.eventManagement.EventManagementApp.entity.Registration;
import com.eventManagement.EventManagementApp.exception.IdNotFoundException;
import com.eventManagement.EventManagementApp.exception.NoRecordAvailableException;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationDao registrationDao;
	
	@Autowired
	private EventDao eventDao;
	
	public ResponseEntity<ResponseStructure<Registration>> createRegistration(Registration registration){
		Registration createRegistration = registrationDao.createRegistration(registration);
		ResponseStructure<Registration> structure = new ResponseStructure<Registration>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Registration Created");
		structure.setData(registration);
		return new ResponseEntity<ResponseStructure<Registration>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<List<Registration>>> getAllRegistration(){
		List<Registration> registration = registrationDao.getAllRegistration();
		if(!registration.isEmpty()) {
		ResponseStructure<List<Registration>> structure = new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Record Fetched");
		structure.setData(registration);
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}
		else {
			throw new NoRecordAvailableException("No Records to Show");
		}
	}
	public ResponseEntity<ResponseStructure<Registration>> getRegistrationById(@PathVariable Integer id){
		Optional<Registration> opt = registrationDao.getRegistrationById(id);
		if(opt.isPresent()) {
			ResponseStructure<Registration> structure = new ResponseStructure<Registration>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Fetched by Id");
			structure.setData(opt.get());
			return new ResponseEntity<>(structure,HttpStatus.OK);
		}
		else {
			return null;
		}
	}
	public ResponseEntity<ResponseStructure<Registration>> deleteRegistration(@PathVariable Integer id){
		Optional<Registration> opt = registrationDao.getRegistrationById(id);
		if(opt.isPresent()) {
			ResponseStructure<Registration> structure = new ResponseStructure<Registration>();
	        structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Deleted Successful");
			structure.setData(opt.get());
			return new ResponseEntity<>(structure,HttpStatus.OK);
		}
		else {
			throw new NoRecordAvailableException("Registration Not Found");
		}
	}
	public ResponseEntity<ResponseStructure<List<Registration>>> getRegistrationByEventId(@PathVariable Integer id){
		List<Registration> registrations = registrationDao.getRegistrationByEventId(id);
		if(!registrations.isEmpty()) {
			ResponseStructure<List<Registration>> structure = new ResponseStructure<List<Registration>>();
			structure.setStatusCode(HttpStatus.OK.value());
	        structure.setMessage("Registration found for event ID: " + id);
	        structure.setData(registrations);
	        return new ResponseEntity<>(structure, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("No Such Record Found");
		}
	}
	public ResponseEntity<ResponseStructure<List<Registration>>> getRegistrationByAttendeeId(@PathVariable Integer id){
		List<Registration> attendees = registrationDao.getRegistrationByAttendeId(id);
		if(!attendees.isEmpty()) {
			ResponseStructure<List<Registration>> structure = new ResponseStructure<List<Registration>>();
			structure.setStatusCode(HttpStatus.FOUND.value());
	        structure.setMessage("Registration found for event ID: " + id);
	        structure.setData(attendees);
	        return new ResponseEntity<>(structure, HttpStatus.FOUND);
		}
		else {
			throw new IdNotFoundException("No Such Record Found");
		}
	}

}
