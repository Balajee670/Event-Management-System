package com.eventManagement.EventManagementApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eventManagement.EventManagementApp.entity.Attendee;
import com.eventManagement.EventManagementApp.entity.Registration;

public interface AttendeeRepository extends JpaRepository<Attendee, Integer> {
	
	public Attendee getAttendeeByContact(long contact);
	
	@Query("select a.registrations from Attendee a where a.id = ?1")
	List<Registration> getRegistrationByAttendee(Integer id);

}
