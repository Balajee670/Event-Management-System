package com.eventManagement.EventManagementApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventManagement.EventManagementApp.entity.Venue;

public interface VenueRepository extends JpaRepository<Venue, Integer> {
	
	public List<Venue> getVenueByLocation(String location);

}
