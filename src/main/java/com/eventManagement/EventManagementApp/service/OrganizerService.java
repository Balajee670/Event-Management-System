package com.eventManagement.EventManagementApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.eventManagement.EventManagementApp.dao.OrganizerDao;
import com.eventManagement.EventManagementApp.entity.Organizer;
import com.eventManagement.EventManagementApp.exception.IdNotFoundException;
import com.eventManagement.EventManagementApp.exception.NoRecordAvailableException;

@Service
public class OrganizerService {
	
	@Autowired
	private OrganizerDao organizerDao;

	public ResponseEntity<ResponseStructure<Organizer>> addOrganizer(Organizer organizer){
		Organizer addOrganizer = organizerDao.addOrganizer(organizer);
		ResponseStructure<Organizer> structure = new ResponseStructure<Organizer>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Organizer Added");
		structure.setData(organizer);
		return new ResponseEntity<ResponseStructure<Organizer>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<List<Organizer>>> getAllOrganizer(){
		List<Organizer> organizer = organizerDao.getAllOrganizer();
		if(!organizer.isEmpty()) {
		ResponseStructure<List<Organizer>> structure = new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Record Fetched");
		structure.setData(organizer);
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}
		throw new NoRecordAvailableException("No Record to Show");
	}
	public ResponseEntity<ResponseStructure<Organizer>> getOrganizerById(@PathVariable Integer id){
		Optional<Organizer> opt = organizerDao.getOrganizerById(id);
		if(opt.isPresent()) {
			ResponseStructure<Organizer> structure = new ResponseStructure<Organizer>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Fetched by Id");
			structure.setData(opt.get());
			return new ResponseEntity<>(structure,HttpStatus.OK);
		}
		else {
			return null;
		}
	}
	public ResponseEntity<ResponseStructure<Organizer>> updateOrganizer(@RequestBody Organizer organizer){
		Organizer org=organizerDao.updateOrganizer(organizer);
		ResponseStructure<Organizer> structure = new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Record Updated");
		structure.setData(org);
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Organizer>> deleteOrganizer(@PathVariable Integer id){
		Optional<Organizer> opt = organizerDao.getOrganizerById(id);
		if(opt.isPresent()) {
			ResponseStructure<Organizer> structure = new ResponseStructure<Organizer>();
	structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Deleted Successful");
			structure.setData(opt.get());
			return new ResponseEntity<>(structure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("Organizer Not Found");
		}
	}
}
