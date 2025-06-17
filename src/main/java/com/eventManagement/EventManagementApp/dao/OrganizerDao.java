package com.eventManagement.EventManagementApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eventManagement.EventManagementApp.entity.Organizer;
import com.eventManagement.EventManagementApp.repository.OrganizerRepository;

@Repository
public class OrganizerDao {
	
	@Autowired
	private OrganizerRepository organizerRepository;
	
	public Organizer addOrganizer(Organizer organizer) {
		return organizerRepository.save(organizer);
	}
	public List<Organizer> getAllOrganizer(){
		return organizerRepository.findAll();
	}
	public Optional<Organizer> getOrganizerById(Integer id){
		return organizerRepository.findById(id);
	}
	public Organizer updateOrganizer(Organizer organizer) {
		return organizerRepository.save(organizer);
	}
	public void deleteOrganizer(Organizer organizer) {
		organizerRepository.delete(organizer);
	}

}
