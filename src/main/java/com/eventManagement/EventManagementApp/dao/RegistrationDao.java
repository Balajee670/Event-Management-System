package com.eventManagement.EventManagementApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eventManagement.EventManagementApp.entity.Event;
import com.eventManagement.EventManagementApp.entity.Registration;
import com.eventManagement.EventManagementApp.repository.RegistrationRepository;

@Repository
public class RegistrationDao {
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	public Registration createRegistration(Registration registration) {
		return registrationRepository.save(registration);	
	}
	public List<Registration> getAllRegistration(){
		return registrationRepository.findAll();
	}
	public Optional<Registration> getRegistrationById(Integer id){
		return registrationRepository.findById(id);
	}
	public void deleteRegistration(Registration registration) {
		registrationRepository.delete(registration);
	}
	public List<Registration> getRegistrationByEventId(Integer id){
		return registrationRepository.getRegistrationByEventId(id);
	}
	public List<Registration> getRegistrationByAttendeId(Integer id){
		return registrationRepository.getRegistrationByAttendeeId(id);
	}

}
