package com.example;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ApplicantController {

	
	private final ApplicantService appservice;
	
	@Inject
	public ApplicantController(final ApplicantService app)
	{
		this.appservice=app;
	}

	@RequestMapping(value="/Applicants", method=RequestMethod.GET)
	public List<Applicant> listall()
	{
		return appservice.getApplicants();
	}
	
	@RequestMapping(value="/addApplicant", method = RequestMethod.POST)
	public ModelAndView addApplicant(@RequestParam(value="name",required=true) String name,
			@RequestParam(value="email",required=true)String email,
			@RequestParam(value="topic",required=true)String topic ,
			@RequestParam(value="year",required=false)int year)
	{
		Applicant app = new Applicant(name,email,topic,year);
		appservice.save(app);
		return new ModelAndView("redirect:Welcome.html");
	}
	
	@RequestMapping(value="/show", method=RequestMethod.GET)
	public ModelAndView listallApp()
	{
		ModelAndView model = new ModelAndView("NewFile");
		model.addObject("lists", appservice.getApplicants());
		return model;
	}
}
