package com.eventManagement.EventManagementApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eventManagement.EventManagementApp.entity.Venue;
import com.eventManagement.EventManagementApp.repository.VenueRepository;


@Repository
public class VenueDao {
	
	@Autowired
	private VenueRepository venueRepository;
	
	public Venue addVenue(Venue venue) {
		return venueRepository.save(venue);
	}
	public List<Venue> getAllVenue(){
		return venueRepository.findAll();
	}
	public Optional<Venue> getVenueById(Integer id){
		return venueRepository.findById(id);
	}
	public Venue updateVenue(Venue venue) {
		return venueRepository.save(venue);
	}
	public void deleteVenue(Venue venue) {
		venueRepository.delete(venue);
	}
	public  Optional<Venue> getEventByVenueId(Integer id){
		return venueRepository.findById(id);
	}
	public List<Venue> getVenueByLocation(String location){
		return venueRepository.getVenueByLocation(location);
    }

}
