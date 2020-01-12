package com.example.rentalcar.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rentalcar.dao.BodyTypeDao;
import com.example.rentalcar.domain.BodyType;
import com.example.rentalcar.spring.repository.BodyTypeRepository;

@Service
@Transactional
public class BodyTypeService implements BodyTypeDao{

	@Autowired
	private BodyTypeRepository bodyTypeRepository;

	@Override
	public List<BodyType> getAll() {
		return bodyTypeRepository.findAll();
	}
	
	@Override
	public List<BodyType> getAll(Sort sort) {
		return bodyTypeRepository.findAll(sort);
	}
	
	@Override
	public Page<BodyType> getAll(int pageNumber, int pageSize, String sortField, Direction sortDirection) {
		return bodyTypeRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
	}

	@Override
	public List<BodyType> search(String... searchString) {
		return bodyTypeRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0]);
	}
	
	@Override
	public Page<BodyType> search(int pageNumber, int pageSize, String sortField, Direction sortDirection,
			String... searchString) {
		return bodyTypeRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0], PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
	}

	@Override
	public BodyType get(int id) {
		return bodyTypeRepository.getOne(id);
	}

	@Override
	public BodyType save(BodyType obj) {
		return bodyTypeRepository.save(obj);
	}

	@Override
	public void delete(BodyType object) {
		bodyTypeRepository.delete(object);
		
	}

	@Override
	public void update(BodyType object) {
		// TODO Auto-generated method stub
		
	}

}
