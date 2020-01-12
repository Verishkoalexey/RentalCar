package com.example.rentalcar.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.example.rentalcar.domain.User;

public interface UserDao extends GeneralDAO<User>{
	User findByLogin(String login);
	List<User> findByUserRole(int userRoleId);
}
