package com.example.rentalcar.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rentalcar.domain.Contract;
import com.example.rentalcar.domain.ViewManager;

@Repository
public interface ViewManagerRepository extends JpaRepository<ViewManager, Integer> {
	@Query("select new com.example.rentalcar.domain.ViewManager(vm.id, vm.contract, vm.startRent, vm.finishRent, vm.statusRent) from ViewManager vm where vm.contract.id=:contractId")
	ViewManager findByContract(@Param("contractId") int contractId);
}
