package com.example.rentalcar.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rentalcar.dao.ContractDao;
import com.example.rentalcar.domain.Contract;
import com.example.rentalcar.spring.repository.ContractRepository;

@Service
@Transactional
public class ContractService implements ContractDao{
	
	@Autowired
	private ContractRepository contractRepository;

	@Override
	public List<Contract> getAll() {
		return contractRepository.findAll();
	}

	@Override
	public List<Contract> getAll(Sort sort) {
		return contractRepository.findAll(sort);
	}

	@Override
	public Page<Contract> getAll(int pageNumber, int pageSize, String sortField, Direction sortDirection) {
		return null;
	}

	@Override
	public Page<Contract> search(int pageNumber, int pageSize, String sortField, Direction sortDirection,
			String... searchString) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Contract> search(String... searchString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contract get(int id) {
		return contractRepository.getOne(id);
	}

	@Override
	public Contract save(Contract obj) {
		return contractRepository.save(obj);
	}

	@Override
	public void delete(Contract object) {
		contractRepository.delete(object);
	}

	@Override
	public void update(Contract object) {
		Contract entity = contractRepository.getOne(object.getId());
		if(entity!=null) {
			entity.setId(object.getId());
			entity.setContractNumber(object.getContractNumber());
			entity.setManager(object.getManager());
			entity.setAuto(object.getAuto());
			entity.setClient(object.getClient());
		}
		
	}


	
	

}
