package com.example.rentalcar.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.rentalcar.dao.impl.AutoService;
import com.example.rentalcar.dao.impl.BodyTypeService;
import com.example.rentalcar.dao.impl.DriveTypeService;
import com.example.rentalcar.dao.impl.TransmissionService;
import com.example.rentalcar.domain.Auto;
import com.example.rentalcar.domain.BodyType;
import com.example.rentalcar.domain.DriveType;
import com.example.rentalcar.domain.Transmission;

@Controller
public class AutoController {
	
	@Autowired
	private AutoService autoService;
	@Autowired
	private TransmissionService transmissionService;
	@Autowired
	private BodyTypeService bodyTypeService;
	@Autowired
	private DriveTypeService driveTypeService;

	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String baseUrlRedirect(ModelMap model) {
		List <Auto> autos = autoService.getAll();
		model.addAttribute("autos", autos);
		return "auto";
	}
	
	@RequestMapping(value = { "/newauto" }, method = RequestMethod.GET)
	public String newAuto(ModelMap model) {
		Auto auto = new Auto();
		model.addAttribute("auto", auto);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationAuto";
	}
	
	@RequestMapping(value = { "/newauto" }, method = RequestMethod.POST)
	public String saveAuto(@Valid Auto auto, BindingResult result,
			ModelMap model, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		
		if (result.hasErrors()) {
			return "registrationAuto";
		}
		
		autoService.save(auto);

		model.addAttribute("success", "Rent " + auto.getNumberAuto() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registrationsuccessAuto";
	}
	
	@ModelAttribute("transmissions")
	public List<Transmission> initializeTransmissions() {
		return transmissionService.getAll();
	}
	
	@ModelAttribute("bodyTypes")
	public List<BodyType> initializeBodyTypes() {
		return bodyTypeService.getAll();
	}
	
	@ModelAttribute("driveTypes")
	public List<DriveType> initializeDriveTypes() {
		return driveTypeService.getAll();
	}
	
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

}
