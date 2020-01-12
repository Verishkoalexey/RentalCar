package com.example.rentalcar.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentalcar.domain.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer>{
}
