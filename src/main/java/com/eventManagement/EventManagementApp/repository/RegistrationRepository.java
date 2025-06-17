package com.eventManagement.EventManagementApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eventManagement.EventManagementApp.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
	
	@Query("select e.registrations from Event e where e.id=?1")
	List<Registration> getRegistrationByEventId(Integer id);
	
	@Query("select a.registrations from Attendee a where a.id=?1")
	List<Registration> getRegistrationByAttendeeId(Integer id);

}
