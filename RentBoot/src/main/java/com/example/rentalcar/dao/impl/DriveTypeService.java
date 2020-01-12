package com.example.rentalcar.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rentalcar.dao.DriveTypeDao;
import com.example.rentalcar.domain.DriveType;
import com.example.rentalcar.spring.repository.DriveTypeRepository;

@Service
@Transactional
public class DriveTypeService implements DriveTypeDao {
	
	@Autowired
	private DriveTypeRepository driverTypeRepository;

	@Override
	public List<DriveType> getAll() {
		return driverTypeRepository.findAll();
	}
	
	@Override
	public List<DriveType> getAll(Sort sort) {
		return driverTypeRepository.findAll(sort);
	}

	@Override
	public Page<DriveType> getAll(int pageNumber, int pageSize, String sortField, Direction sortDirection) {
		return driverTypeRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
	}
	
	@Override
	public List<DriveType> search(String... searchString) {
		return driverTypeRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0]);
	}

	@Override
	public Page<DriveType> search(int pageNumber, int pageSize, String sortField, Direction sortDirection,
			String... searchString) {
		return driverTypeRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0], PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
	}

	@Override
	public DriveType get(int id) {
		return driverTypeRepository.getOne(id);
	}

	@Override
	public DriveType save(DriveType obj) {
		return driverTypeRepository.save(obj);
	}

	@Override
	public void delete(DriveType object) {
		driverTypeRepository.delete(object);
	}

	@Override
	public void update(DriveType object) {
		// TODO Auto-generated method stub
		
	}



}
