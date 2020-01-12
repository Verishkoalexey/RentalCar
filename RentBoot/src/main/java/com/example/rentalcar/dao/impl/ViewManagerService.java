package com.example.rentalcar.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rentalcar.dao.ViewManagerDao;
import com.example.rentalcar.domain.Contract;
import com.example.rentalcar.domain.ViewManager;
import com.example.rentalcar.spring.repository.ViewManagerRepository;
@Service
@Transactional
public class ViewManagerService implements ViewManagerDao {

	@Autowired
	private ViewManagerRepository viewManagerRepository;

	@Override
	public List<ViewManager> getAll() {
		return viewManagerRepository.findAll();
	}
	
	@Override
	public List<ViewManager> getAll(Sort sort) {
		return viewManagerRepository.findAll(sort);
	}

	@Override
	public Page<ViewManager> getAll(int pageNumber, int pageSize, String sortField, Direction sortDirection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ViewManager> search(int pageNumber, int pageSize, String sortField, Direction sortDirection,
			String... searchString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ViewManager> search(String... searchString) {
		return null;
	}

	@Override
	public ViewManager get(int id) {
		return viewManagerRepository.getOne(id);
	}

	@Override
	public ViewManager save(ViewManager obj) {
		return viewManagerRepository.save(obj);
	}

	@Override
	public void delete(ViewManager object) {
		viewManagerRepository.delete(object);
	}

	@Override
	public void update(ViewManager object) {
		ViewManager entity = viewManagerRepository.getOne(object.getId());
		if(entity!=null) {
			entity.setId(object.getId());
			entity.setContract(object.getContract());
			entity.setStartRent(object.getStartRent());
			entity.setFinishRent(object.getFinishRent());
			entity.setStatusRent(object.getStatusRent());
		}
		
	}

	@Override
	public ViewManager findByContract(int contractId) {
		return viewManagerRepository.findByContract(contractId);
	}

}
