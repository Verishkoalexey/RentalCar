package com.example.rentalcar.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentalcar.domain.Transmission;

@Repository
public interface TransmissionRepository extends JpaRepository<Transmission, Integer>{

	List<Transmission> findByNameContainingIgnoreCaseOrderByName(String name);
	
	Page<Transmission> findByNameContainingIgnoreCaseOrderByName(String name, Pageable pegeable);
}
