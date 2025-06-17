package com.eventManagement.EventManagementApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.eventManagement.EventManagementApp.dao.VenueDao;
import com.eventManagement.EventManagementApp.entity.Event;
import com.eventManagement.EventManagementApp.entity.Venue;
import com.eventManagement.EventManagementApp.exception.IdNotFoundException;
import com.eventManagement.EventManagementApp.exception.NoRecordAvailableException;

@Service
public class VenueService {
	
	@Autowired
	private VenueDao venueDao;
	
	public ResponseEntity<ResponseStructure<Venue>> addVenue(Venue venue){
		Venue addVenue= venueDao.addVenue(venue);
		ResponseStructure<Venue> structure = new ResponseStructure<Venue>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Venue Added");
		structure.setData(venue);
		return new ResponseEntity<ResponseStructure<Venue>>(structure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure<List<Venue>>> getAllVenue(){
		List<Venue> venue = venueDao.getAllVenue();
		if(!venue.isEmpty()) {
		ResponseStructure<List<Venue>> structure = new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Record Fetched");
		structure.setData(venue);
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}
		throw new NoRecordAvailableException("No Records to Show");
	}
	public ResponseEntity<ResponseStructure<Venue>> getVenueById(@PathVariable Integer id){
		Optional<Venue> opt = venueDao.getVenueById(id);
		if(opt.isPresent()) {
			ResponseStructure<Venue> structure = new ResponseStructure<>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Record Fetched By Id");
			structure.setData(opt.get());
			return new ResponseEntity<>(structure,HttpStatus.OK);
		}
		else {
			return null;
		}
	}
	public ResponseEntity<ResponseStructure<Venue>> updateVenue(@RequestBody Venue venue){
		Venue ven = venueDao.updateVenue(venue);
		ResponseStructure<Venue> structure = new ResponseStructure<Venue>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Record Updated");
		structure.setData(ven);
		return new ResponseEntity<>(structure,HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResponseStructure<Venue>> deleteVenue(@PathVariable Integer Id){
		Optional<Venue> opt = venueDao.getVenueById(Id);
		if(opt.isPresent()) {
			venueDao.deleteVenue(opt.get());
			ResponseStructure<Venue> structure = new ResponseStructure<>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Deleted Successful");
			structure.setData(opt.get());
			return new ResponseEntity<>(structure,HttpStatus.OK);
			
		}
		else {
			throw new IdNotFoundException("Id is Unavailable");
		}
		
	}
	public ResponseEntity<ResponseStructure<List<Event>>> getEventByVenueId(@PathVariable Integer id){
		Optional<Venue> opt = venueDao.getVenueById(id);
		if(opt.isPresent()) {
			ResponseStructure<List<Event>> structure = new ResponseStructure<>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Record Fetched");
			structure.setData(opt.get().getEvents());
			return new ResponseEntity<>(structure,HttpStatus.OK);
		}
		else {
			return null;
		}
	}
	public ResponseEntity<ResponseStructure<List<Venue>>> getVenueByLocation(@PathVariable String location){
		List<Venue> venue = venueDao.getVenueByLocation(location);
		ResponseStructure<List<Venue>> structure = new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Record Fetched");
		structure.setData(venue);
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}
}
