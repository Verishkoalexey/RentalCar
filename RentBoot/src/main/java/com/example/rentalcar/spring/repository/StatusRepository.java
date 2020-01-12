package com.example.rentalcar.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentalcar.domain.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

	List<Status> findByNameContainingIgnoreCaseOrderByName(String name);
	
	Page<Status> findByNameContainingIgnoreCaseOrderByName(String name, Pageable pegeable);
}
