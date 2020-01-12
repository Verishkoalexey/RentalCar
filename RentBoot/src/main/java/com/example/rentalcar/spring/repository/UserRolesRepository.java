package com.example.rentalcar.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentalcar.domain.UserRoles;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Integer> {

	List<UserRoles> findByRoleContainingIgnoreCaseOrderByRole(String role);
	
	Page<UserRoles> findByRoleContainingIgnoreCaseOrderByRole(String role, Pageable pegeable);
}
