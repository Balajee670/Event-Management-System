package com.eventManagement.EventManagementApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventManagement.EventManagementApp.entity.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Integer>{

}
