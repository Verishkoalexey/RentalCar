package com.example.rentalcar.dao;

import com.example.rentalcar.domain.Contract;
import com.example.rentalcar.domain.ViewManager;

public interface ViewManagerDao extends GeneralDAO<ViewManager> {
	ViewManager findByContract(int contractId);
}
