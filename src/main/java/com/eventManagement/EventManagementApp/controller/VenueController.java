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

import com.eventManagement.EventManagementApp.entity.Event;
import com.eventManagement.EventManagementApp.entity.Venue;
import com.eventManagement.EventManagementApp.service.ResponseStructure;
import com.eventManagement.EventManagementApp.service.VenueService;

@RestController
@RequestMapping("/venue")
public class VenueController {

	@Autowired
	private VenueService venueService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Venue>> addVenue(@RequestBody Venue venue){
		return venueService.addVenue(venue);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Venue>>> getAllVenue(){
		return venueService.getAllVenue();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Venue>> getVenueById(@PathVariable Integer id){
		return venueService.getVenueById(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Venue>> updateVenue(@RequestBody Venue venue){
		return venueService.updateVenue(venue);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Venue>> deleteVenue(@PathVariable Integer id){
		return venueService.deleteVenue(id);
    }
	@GetMapping("/venues/{id}")
	public ResponseEntity<ResponseStructure<List<Event>>> getEventByVenueId(@PathVariable Integer id){
		return venueService.getEventByVenueId(id);
	}
	@GetMapping("/location/{location}")
	public ResponseEntity<ResponseStructure<List<Venue>>> getVenueByLocation(@PathVariable String location){
		return venueService.getVenueByLocation(location);
	}
	
	
}
