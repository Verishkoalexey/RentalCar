package com.example.rentalcar.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentalcar.domain.BodyType;

@Repository
public interface BodyTypeRepository extends JpaRepository<BodyType, Integer> {

	List<BodyType> findByNameContainingIgnoreCaseOrderByName(String name);
	
	Page<BodyType> findByNameContainingIgnoreCaseOrderByName(String name, Pageable pegeable);
}
