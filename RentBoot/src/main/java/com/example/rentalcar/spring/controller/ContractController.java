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

import com.example.rentalcar.dao.impl.AutoService;
import com.example.rentalcar.dao.impl.ContractService;
import com.example.rentalcar.dao.impl.StatusService;
import com.example.rentalcar.dao.impl.UserService;
import com.example.rentalcar.dao.impl.ViewManagerService;
import com.example.rentalcar.domain.Auto;
import com.example.rentalcar.domain.Contract;
import com.example.rentalcar.domain.Status;
import com.example.rentalcar.domain.User;
import com.example.rentalcar.domain.UserRoles;
import com.example.rentalcar.domain.ViewManager;
import com.example.rentalcar.spring.repository.ContractRepository;
import com.example.rentalcar.spring.repository.ViewManagerRepository;

@Controller
public class ContractController {

	@Autowired
	private ContractService contractService;
	@Autowired
	private StatusService statusService;
	@Autowired
	private ViewManagerService viewManagerService;
	@Autowired
	private UserService userService;
	@Autowired
	private AutoService autoService;
	
	@RequestMapping(value = {"/contracts"}, method = RequestMethod.GET)
	public String viewContracts(ModelMap model) {

		List<Contract> viewContracts = contractService.getAll();
		model.addAttribute("viewContracts", viewContracts);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewContracts";
	}
	
	@RequestMapping(value = { "/newcontract" }, method = RequestMethod.GET)
	public String newContract(ModelMap model) {
		Contract contract = new Contract();
		model.addAttribute("contract", contract);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationContract";
	}
	
	@RequestMapping(value = { "/newcontract" }, method = RequestMethod.POST)
	public String saveContract(@Valid Contract contract, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registrationContract";
		}
		
		contractService.save(contract);

		model.addAttribute("success", "Contract " + contract.getContractNumber() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registrationsuccessContract";
	}
	
	
	@RequestMapping(value = { "/contract-{id}" }, method = RequestMethod.GET)
	public String ContractTimeDetails(@PathVariable Integer id, ModelMap model) {
		ViewManager viewManager = viewManagerService.findByContract(id);
		model.addAttribute("viewManager", viewManager);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "viewContractTime";
	}
	
	@RequestMapping(value = { "/edit-contract-{id}" }, method = RequestMethod.GET)
	public String editContract(@PathVariable Integer id, ModelMap model) {
		Contract contract = contractService.get(id);
		model.addAttribute("contract", contract);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationContract";
	}
	
	@RequestMapping(value = { "/edit-contract-{id}" }, method = RequestMethod.POST)
	public String updateContract(@Valid Contract contract, BindingResult result,
			ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "registrationContract";
		}

		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/


		contractService.update(contract);

		model.addAttribute("success", "Contract " + contract.getContractNumber() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccessContract";
	}
	
	@RequestMapping(value = { "/delete-contract-{id}" }, method = RequestMethod.GET)
	public String deleteContract(@PathVariable Integer id) {
		contractService.delete(contractService.get(id));
		return "redirect:/list";
	}
	
	@ModelAttribute("contracts")
	public List<Contract> initializeContracts() {
		return contractService.getAll();
	}
	
	@ModelAttribute("statuses")
	public List<Status> initializeStatuses(){
		return statusService.getAll();
	}
	
	
	@ModelAttribute("managers")
	public List<User> initializeManagers() {
		return userService.findByUserRole(3);
	}
	
	@ModelAttribute("autos")
	public List<Auto> initializeAutos() {
		return autoService.getAll();
	}
	
	@ModelAttribute("clients")
	public List<User> initializeClients() {
		return userService.findByUserRole(2);
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
