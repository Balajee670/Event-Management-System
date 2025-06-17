package com.eventManagement.EventManagementApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eventManagement.EventManagementApp.entity.Attendee;
import com.eventManagement.EventManagementApp.repository.AttendeeRepository;

@Repository
public class AttendeeDao {
	
	@Autowired
	private AttendeeRepository attendeeRepository;
	
	public Attendee registerAttendee(Attendee attendee) {
		return attendeeRepository.save(attendee);	
	}
	public List<Attendee> getAllAttendee(){
		return attendeeRepository.findAll();
	}
	public Optional<Attendee> getAttendeeById(Integer id){
		return attendeeRepository.findById(id);
	}
	public Attendee updateAttendee(Attendee attendee) {
		return attendeeRepository.save(attendee);
	}
	public void deleteAttendee(Attendee attendee) {
		attendeeRepository.delete(attendee);
	}
	public Optional<Attendee> getRegistrationById(Integer id){
		return attendeeRepository.findById(id);
	}
	public Attendee getAttendeeByContactNumber(Long contact) {
		return attendeeRepository.getAttendeeByContact(contact);
	}

}
