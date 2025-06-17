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
import com.eventManagement.EventManagementApp.entity.Event;
import com.eventManagement.EventManagementApp.service.EventService;
import com.eventManagement.EventManagementApp.service.ResponseStructure;

@RestController
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Event>> createEvent(@RequestBody Event event){
		return eventService.createEvent(event);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Event>>> getAllEvent(){
		return eventService.getAllEvent();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Event>> getEventById(@PathVariable Integer id){
		return eventService.getEventById(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Event>> updateEvent(@RequestBody Event event){
		return eventService.updateEvent(event);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Event>> deleteEvent(@PathVariable Integer id){
		return eventService.deleteEvent(id);
	}
	
	@GetMapping("/attendeeByEventId/{id}")
	public ResponseEntity<ResponseStructure<List<Attendee>>> getAttendeeByEventId(@PathVariable Integer id) {
		return  eventService.getAttendeeByEventId(id);
	}
	@GetMapping("/eventsByOrganizerId/{id}")
	public ResponseEntity<ResponseStructure<List<Event>>> getEventByOrganizerId(@PathVariable Integer id){
		return eventService.getEventByOrganizerId(id);
	}

}
