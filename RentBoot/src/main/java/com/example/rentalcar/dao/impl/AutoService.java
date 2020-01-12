package com.example.rentalcar.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rentalcar.dao.AutoDao;
import com.example.rentalcar.domain.Auto;
import com.example.rentalcar.spring.repository.AutoRepository;

@Service
@Transactional
public class AutoService implements AutoDao{
	
	@Autowired
	private AutoRepository autoRepository;

	@Override
	public List<Auto> getAll() {
		return autoRepository.findAll();
	}
	
	@Override
	public List<Auto> getAll(Sort sort) {
		return autoRepository.findAll(sort);
	}

	@Override
	public Page<Auto> getAll(int pageNumber, int pageSize, String sortField, Direction sortDirection) {
		return autoRepository.findAllWithoutContent(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
	}

	@Override
	public Page<Auto> search(int pageNumber, int pageSize, String sortField, Direction sortDirection,
			String... searchString) {
		return autoRepository.findByMarkContainingIgnoreCaseOrModelContainingIgnoreCaseOrderByMark(searchString[0], searchString[0], PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
	}

	@Override
	public List<Auto> search(String... searchString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Auto get(int id) {
		return autoRepository.getOne(id);
	}

	@Override
	public Auto save(Auto obj) {
		return autoRepository.save(obj);
	}

	@Override
	public void delete(Auto object) {
		autoRepository.delete(object);
		
	}

	@Override
	public List<Auto> findTopAutos(int limit) {
		return autoRepository.findTopAutos(PageRequest.of(0, limit, Sort.by(Sort.Direction.DESC, "viewCount")));
	}

	@Override
	public Page<Auto> findByBodyType(int pageNumber, int pageSize, String sortField, Direction sortDirection,
			int bodyTypeId) {
		return autoRepository.findByBodyType(bodyTypeId, PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
	}

	@Override
	public void update(Auto object) {
		// TODO Auto-generated method stub
		
	}


}
