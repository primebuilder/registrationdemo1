package com.example;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
@Service
@Validated
public class ApplicantServiceImpl implements ApplicantService {

	private static final Logger log = LoggerFactory.getLogger(ApplicantServiceImpl.class);
	private final ApplicantRepository rep;
	
	@Inject
	public ApplicantServiceImpl(final ApplicantRepository  rep) {
		this.rep=rep;
	}
	
	@Override
	@Transactional
	public Applicant save(@NotNull @Valid Applicant app) {
		log.debug("creating",app);
		return rep.save(app);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Applicant> getApplicants() {
		log.debug("getting");
		return rep.findAll();
	}

}
