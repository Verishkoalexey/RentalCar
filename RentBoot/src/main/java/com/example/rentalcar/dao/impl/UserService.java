package com.example.rentalcar.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rentalcar.dao.UserDao;
import com.example.rentalcar.domain.User;
import com.example.rentalcar.spring.repository.UserRepository;

@Service
@Transactional
public class UserService implements UserDao{

	@Autowired
	private UserRepository userRepository;
	

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	@Override
	public List<User> getAll(Sort sort) {
		return userRepository.findAll(sort);
	}

	@Override
	public Page<User> getAll(int pageNumber, int pageSize, String sortField, Direction sortDirection) {
		return userRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
	}

	@Override
	public Page<User> search(int pageNumber, int pageSize, String sortField, Direction sortDirection,
			String... searchString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> search(String... searchString) {
		return null;
	}

	@Override
	public User get(int id) {
		return userRepository.getOne(id);
	}

	@Override
	public User save(User obj) {
		return userRepository.save(obj);
	}

	@Override
	public void delete(User object) {
		userRepository.delete(object);
	}

	@Override
	public List<User> findByUserRole(int userRoleId) {
		return userRepository.findByUserRole(userRoleId);
	}
	
	@Override
	public User findByLogin(String login) {
		return userRepository.findByLogin(login);
	}

	@Override
	public void update(User object) {
		// TODO Auto-generated method stub
		
	}
	
}
