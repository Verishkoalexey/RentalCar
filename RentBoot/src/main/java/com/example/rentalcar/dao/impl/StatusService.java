package com.example.rentalcar.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rentalcar.dao.StatusDao;
import com.example.rentalcar.domain.Status;
import com.example.rentalcar.spring.repository.StatusRepository;

@Service
@Transactional
public class StatusService implements StatusDao {

	@Autowired
	private StatusRepository statusRepository;

	@Override
	public List<Status> getAll() {
		return statusRepository.findAll();
	}
	
	@Override
	public List<Status> getAll(Sort sort) {
		return statusRepository.findAll(sort);
	}

	@Override
	public Page<Status> getAll(int pageNumber, int pageSize, String sortField, Direction sortDirection) {
		return statusRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
	}
	
	@Override
	public List<Status> search(String... searchString) {
		return statusRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0]);
	}

	@Override
	public Page<Status> search(int pageNumber, int pageSize, String sortField, Direction sortDirection,
			String... searchString) {
		return statusRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0], PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
	}

	@Override
	public Status get(int id) {
		return statusRepository.getOne(id);
	}

	@Override
	public Status save(Status obj) {
		return statusRepository.save(obj);
	}

	@Override
	public void delete(Status object) {
		statusRepository.delete(object);
	}

	@Override
	public void update(Status object) {
		// TODO Auto-generated method stub
		
	}
}
