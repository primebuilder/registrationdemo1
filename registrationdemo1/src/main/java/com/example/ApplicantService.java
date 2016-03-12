package com.example;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

public interface ApplicantService {

	
	Applicant save(Applicant app);
	List<Applicant> getApplicants();
	
}
