package com.example.rentalcar.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rentalcar.dao.UserRolesDao;
import com.example.rentalcar.domain.UserRoles;
import com.example.rentalcar.spring.repository.UserRolesRepository;

@Service
@Transactional
public class UserRolesService implements UserRolesDao{

	@Autowired
	private UserRolesRepository userRolesRepository;

	@Override
	public List<UserRoles> getAll() {
		return userRolesRepository.findAll();
	}
	
	@Override
	public List<UserRoles> getAll(Sort sort) {
		return userRolesRepository.findAll(sort);
	}

	@Override
	public Page<UserRoles> getAll(int pageNumber, int pageSize, String sortField, Direction sortDirection) {
		return null;
	}

	@Override
	public Page<UserRoles> search(int pageNumber, int pageSize, String sortField, Direction sortDirection,
			String... searchString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRoles> search(String... searchString) {
		return null;
	}

	@Override
	public UserRoles get(int id) {
		return userRolesRepository.getOne(id);
	}

	@Override
	public UserRoles save(UserRoles obj) {
		return userRolesRepository.save(obj);
	}

	@Override
	public void delete(UserRoles object) {
		userRolesRepository.delete(object);
		
	}

	@Override
	public void update(UserRoles object) {
		// TODO Auto-generated method stub
		
	}
}
