package com.example.rentalcar.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentalcar.domain.DriveType;

@Repository
public interface DriveTypeRepository extends JpaRepository<DriveType, Integer> {

	List<DriveType> findByNameContainingIgnoreCaseOrderByName(String name);
	
	Page<DriveType> findByNameContainingIgnoreCaseOrderByName(String name, Pageable pegeable);
}
