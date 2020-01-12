package com.example.rentalcar.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface GeneralDAO<T> {
	
	List<T> getAll();
	
	List<T> search(String... searchString);
	
	T get(int id);
	T save(T obj);
	void update(T object);
	void delete(T object);
	
	List<T> getAll(Sort sort);
	
	Page<T> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection);
	
	Page<T> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString);
	
}
