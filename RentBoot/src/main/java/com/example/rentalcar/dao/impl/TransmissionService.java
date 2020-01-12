package com.example.rentalcar.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rentalcar.dao.TransmissionDao;
import com.example.rentalcar.domain.Transmission;
import com.example.rentalcar.spring.repository.TransmissionRepository;

@Service
@Transactional
public class TransmissionService implements TransmissionDao{
	
	@Autowired
	private TransmissionRepository transmissionRepository;

	@Override
	public List<Transmission> getAll() {
		return transmissionRepository.findAll();
	}
	
	@Override
	public List<Transmission> getAll(Sort sort) {
		return transmissionRepository.findAll(sort);
	}

	@Override
	public Page<Transmission> getAll(int pageNumber, int pageSize, String sortField, Direction sortDirection) {
		return transmissionRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
	}
	
	@Override
	public List<Transmission> search(String... searchString) {
		return transmissionRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0]);
	}

	@Override
	public Page<Transmission> search(int pageNumber, int pageSize, String sortField, Direction sortDirection,
			String... searchString) {
		return transmissionRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0], PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
	}

	@Override
	public Transmission get(int id) {
		return transmissionRepository.getOne(id);
	}

	@Override
	public Transmission save(Transmission obj) {
		return transmissionRepository.save(obj);
	}

	@Override
	public void delete(Transmission object) {
		transmissionRepository.delete(object);
	}

	@Override
	public void update(Transmission object) {
		// TODO Auto-generated method stub
		
	}

}
