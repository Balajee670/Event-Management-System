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

import com.eventManagement.EventManagementApp.entity.Organizer;
import com.eventManagement.EventManagementApp.service.OrganizerService;
import com.eventManagement.EventManagementApp.service.ResponseStructure;

@RestController
@RequestMapping("/organizer")
public class OrganizerController {
	
	@Autowired
	private OrganizerService organizerService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Organizer>> addrOrganizer(@RequestBody Organizer organizer){
		return organizerService.addOrganizer(organizer);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Organizer>>> getAllOrganizer(){
		return organizerService.getAllOrganizer();
	}
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Organizer>> getOrganizerById(@PathVariable Integer id){
		return organizerService.getOrganizerById(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Organizer>> updateOrganizer(@RequestBody Organizer organizer){
		return organizerService.updateOrganizer(organizer);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Organizer>> deleteOrganizer(@PathVariable Integer id){
		return organizerService.deleteOrganizer(id);
	}

}
