package com.example.rentalcar.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rentalcar.domain.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByLogin(String login);
	
    @Query("select new com.example.rentalcar.domain.User(u.id, u.login, u.password, u.fio, u.phone, u.address, u.passport_id, u.identificationNumber, u.userRole) from User u where u.userRole.id=:userRole")
    List<User> findByUserRole(@Param("userRole") int userRole);
}
