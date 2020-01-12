package com.example.rentalcar.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.rentalcar.dao.impl.ContractService;
import com.example.rentalcar.dao.impl.StatusService;
import com.example.rentalcar.dao.impl.ViewManagerService;
import com.example.rentalcar.domain.Contract;
import com.example.rentalcar.domain.Status;
import com.example.rentalcar.domain.ViewManager;

@Controller
public class ViewManagerController {

	@Autowired
	private ViewManagerService viewManagerService;
	@Autowired
	private ContractService contractService;
	@Autowired
	private StatusService statusService;
	
	@RequestMapping(value = {"/list"}, method = RequestMethod.GET)
	public String viewManager(ModelMap model) {

		List<ViewManager> viewManagers = viewManagerService.getAll();
		model.addAttribute("viewManagers", viewManagers);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewContractsTimes";
	}
	
	@RequestMapping(value = { "/newcontracttime" }, method = RequestMethod.GET)
	public String newContractTime(ModelMap model) {
		ViewManager viewManager = new ViewManager();
		model.addAttribute("viewManager", viewManager);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationContractTime";
	}
	
	
	
	@RequestMapping(value = { "/newcontracttime" }, method = RequestMethod.POST)
	public String saveContractTime(@Valid ViewManager viewManager, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registrationContractTime";
		}

		viewManagerService.save(viewManager);

		model.addAttribute("success", "Contract " + viewManager.getContract() + " registered time successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registrationsuccessContractTime";
	}
	
	@RequestMapping(value = { "/contract-details-{id}" }, method = RequestMethod.GET)
	public String ContractTimeDetails(@PathVariable Integer id, ModelMap model) {
		Contract contract = contractService.get(id);
		model.addAttribute("contract", contract);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewContract";
	}
	
	@RequestMapping(value = { "/edit-contracttime-{id}" }, method = RequestMethod.GET)
	public String editContractTime(@PathVariable Integer id, ModelMap model) {
		ViewManager viewManager = viewManagerService.get(id);
		model.addAttribute("viewManager", viewManager);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationContractTime";
	}
	
	@RequestMapping(value = { "/edit-contracttime-{id}" }, method = RequestMethod.POST)
	public String updateContractTime(@Valid ViewManager viewManager, BindingResult result,
			ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "registrationContractTime";
		}
		viewManagerService.update(viewManager);

		model.addAttribute("success", "Contract time " + viewManager.getContract().getContractNumber() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccessContractTime";
	}
	
	@RequestMapping(value = { "/delete-contracttime-{id}" }, method = RequestMethod.GET)
	public String deleteContractTime(@PathVariable Integer id) {
		viewManagerService.delete(viewManagerService.get(id));
		return "redirect:/list";
	}
	
	@ModelAttribute("contracts")
	public List<Contract> initializeContracts() {
		return contractService.getAll();
	}
	
	@ModelAttribute("statuses")
	public List<Status> initializeStatuses() {
		return statusService.getAll();
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
