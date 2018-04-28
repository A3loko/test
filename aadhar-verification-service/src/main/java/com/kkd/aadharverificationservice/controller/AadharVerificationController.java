package com.kkd.aadharverificationservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kkd.aadharverificationservice.model.AadharBean;
import com.kkd.aadharverificationservice.repository.AadharVerificationRepository;

@RestController
@RequestMapping("/user")
public class AadharVerificationController {
	
	//creating instance of aadharVerificationRepository
	@Autowired
	private AadharVerificationRepository aadharVerification;
	
	@PostMapping("/new/add")
	public String newUser(@RequestBody AadharBean aadharBean)
	{
		aadharVerification.save(aadharBean);
		return "drg";
	}
	
	@GetMapping("/new/{aadharNo}")
	public String addAadhar(@PathVariable String aadharNo) {
		System.out.println(aadharNo+"*****************");
		AadharBean aad = aadharVerification.findById(aadharNo).orElse(null);
		System.out.println(aad+"*****************");
		
		if(aad.getAadharNo().equals(aadharNo)) {
			return aad.getMobileNo();	
		}
		
		return "Invalid Aadhar Number";
		
	}
	
	

}