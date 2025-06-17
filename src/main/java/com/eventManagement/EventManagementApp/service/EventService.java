package com.eventManagement.EventManagementApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.eventManagement.EventManagementApp.dao.EventDao;
import com.eventManagement.EventManagementApp.entity.Attendee;
import com.eventManagement.EventManagementApp.entity.Event;
import com.eventManagement.EventManagementApp.exception.IdNotFoundException;
import com.eventManagement.EventManagementApp.exception.NoRecordAvailableException;

@Service
public class EventService {
	
	@Autowired
	private EventDao eventDao;
	
	public ResponseEntity<ResponseStructure<Event>> createEvent(Event event){
		Event createEvent = eventDao.createEvent(event);
		ResponseStructure<Event> structure = new ResponseStructure<Event>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Event Created");
		structure.setData(event);
		return new ResponseEntity<ResponseStructure<Event>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<List<Event>>> getAllEvent(){
		List<Event> event = eventDao.getAllEvent();
		if(!event.isEmpty()) {
		ResponseStructure<List<Event>> structure = new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Record Fetched");
		structure.setData(event);
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}
		else {
			throw new NoRecordAvailableException("No Record To Show");
		}
	}
	public ResponseEntity<ResponseStructure<Event>> getEventById(@PathVariable Integer id){
		Optional<Event> opt = eventDao.getEventById(id);
		if(opt.isPresent()) {
			ResponseStructure<Event> structure = new ResponseStructure<Event>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Fetched by Id");
			structure.setData(opt.get());
			return new ResponseEntity<>(structure,HttpStatus.OK);
		}
		else {
			return null;
		}
	}
	public ResponseEntity<ResponseStructure<Event>> updateEvent(@RequestBody Event event){
		Event eve=eventDao.updateEvent(event);
		ResponseStructure<Event> structure = new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Record Updated");
		structure.setData(eve);
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Event>> deleteEvent(@PathVariable Integer id){
		Optional<Event> opt = eventDao.getEventById(id);
		if(opt.isPresent()) {
			ResponseStructure<Event> structure = new ResponseStructure<Event>();
	        structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Deleted Successful");
			structure.setData(opt.get());
			return new ResponseEntity<>(structure,HttpStatus.OK);
		}
		else {
			throw new NoRecordAvailableException("Id is Unavailable");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Attendee>>> getAttendeeByEventId(@PathVariable Integer id) {
	    List<Attendee> attendees = eventDao.getAttendeeByEventId(id);
	    ResponseStructure<List<Attendee>> structure = new ResponseStructure<>();

	    if (attendees == null || attendees.isEmpty()) {
	        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	        structure.setMessage("No attendees found for event with ID: " + id);
	        structure.setData(null);
	        return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
	    } else {
	    	throw new IdNotFoundException("No Such Record Found"); 
	    }
	}
	public ResponseEntity<ResponseStructure<List<Event>>> getEventByOrganizerId(@PathVariable Integer id){
		List<Event> events = eventDao.getEventByOrganizerId(id);
		if(!events.isEmpty()) {
			ResponseStructure<List<Event>> structure = new ResponseStructure<List<Event>>();
			structure.setStatusCode(HttpStatus.FOUND.value());
	        structure.setMessage("Attendees found for event ID: " + id);
	        structure.setData(events);
	        return new ResponseEntity<>(structure, HttpStatus.FOUND);
		}
		else {
			throw new IdNotFoundException("No Such Record Found");
		}
	}
	


}
