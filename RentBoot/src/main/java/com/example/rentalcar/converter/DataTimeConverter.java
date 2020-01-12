//package com.example.rentalcar.converter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//import com.example.rentalcar.dao.impl.ViewManagerService;
//import com.example.rentalcar.domain.ViewManager;
//
//@Component
//public class DataTimeConverter implements Converter<Object, ViewManager> {
//
//	@Autowired
//	ViewManagerService viewManagerService;
//	
//	@Override
//	public ViewManager convert(Object source) {
//		ViewManager viewManager = null;
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//		viewManager.setStartRent(LocalDateTime.parse((String) source, formatter));
//		viewManager.setFinishRent(LocalDateTime.parse((String) source, formatter));
//		viewManagerService.save(viewManager);
//		return viewManager;
//	}
//	
//}
