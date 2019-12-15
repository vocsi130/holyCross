package com.cs425.holyCross.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cs425.holyCross.model.Patient;
import com.cs425.holyCross.service.IPatientService;

@Controller
public class PatientController {

	@Autowired
	private IPatientService patientService;
	
	
	@RequestMapping(value="/patients", method = RequestMethod.GET)
	public ModelAndView products(){
		List<Patient> patients = (List<Patient>) patientService.getAllPatients();	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("patients", patients);
		modelAndView.setViewName("patient/listPatient");
		return modelAndView;
	}
	@RequestMapping(value="/elderlyPatients", method = RequestMethod.GET)
	public ModelAndView primes(){
		List<Patient> patients = (List<Patient>) patientService.getAllElderPatients();	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("patients", patients);
		modelAndView.setViewName("patient/elderlyPatient");
		return modelAndView;
	}
	
	@RequestMapping(value="/patient", method = RequestMethod.GET)
	public String create(Model model){			
		model.addAttribute("patient", new Patient());
		return "patient/new";
	}
	
		@RequestMapping(value = "/patient", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("product") Patient patient, 
			BindingResult result, Model model)  {

		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "patient/new";
		}
		patient = patientService.addNewPatient(patient);
		return "redirect:/patients";
	}	
	
	
	
}
