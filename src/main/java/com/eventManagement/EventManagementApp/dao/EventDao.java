package com.eventManagement.EventManagementApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eventManagement.EventManagementApp.entity.Attendee;
import com.eventManagement.EventManagementApp.entity.Event;
import com.eventManagement.EventManagementApp.repository.EventRepository;

@Repository
public class EventDao {
	
	@Autowired
	private EventRepository eventRepository;
	
	public Event createEvent(Event event) {
		return eventRepository.save(event);	
	}
	public List<Event> getAllEvent(){
		return eventRepository.findAll();
	}
	public Optional<Event> getEventById(Integer id){
		return eventRepository.findById(id);
	}
	public Event updateEvent(Event event) {
		return eventRepository.save(event);
	}
	public void deleteEvent(Event event) {
		eventRepository.delete(event);
	}
	public List<Attendee> getAttendeeByEventId(Integer id){
		return eventRepository.getAttendeeByEventId(id);
	}
	public List<Event> getEventByOrganizerId(Integer id){
		return eventRepository.getEventByOrganizerId(id);
	}

}
