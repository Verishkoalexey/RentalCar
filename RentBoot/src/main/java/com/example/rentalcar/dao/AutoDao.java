package com.example.rentalcar.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.example.rentalcar.domain.Auto;

public interface AutoDao extends GeneralDAO<Auto> {
	
	List<Auto> findTopAutos(int limit);
	
	Page<Auto> findByBodyType(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, int bodyTypeId);
}
