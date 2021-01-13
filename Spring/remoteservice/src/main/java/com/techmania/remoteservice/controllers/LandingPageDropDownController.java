package com.techmania.remoteservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techmania.common.GenUtil;
import com.techmania.remoteservice.bean.DropDowns;
import com.techmania.remoteservice.bean.HousingLoanResponse;
import com.techmania.remoteservice.bean.RequestParam;
import com.techmania.remoteservice.service.impl.RestServiceImpl;
import com.techmania.remoteservice.util.LandingPageDropDownHelper;

@RestController
public class LandingPageDropDownController {
	
	private static final Logger logger = LogManager.getLogger(LandingPageDropDownController.class);

	@Autowired
	private LandingPageDropDownHelper landingPageDropDownHelper;
	
	@Autowired
	private RestServiceImpl restServiceImpl;
	
	@RequestMapping("/")
	public String index() throws Exception {
		logger.info("**************LandingPageDropDownController.index**************");
		List<String> test = new ArrayList<String>();
		String value ="FALSE";
		
		if(GenUtil.isEmpty(test)) {
			value ="TRUE";
		}
		
		
		
		return "Greetings from Spring Boot!"+value;
	}
	
	@GetMapping("/landingPageDropDowns")
	public DropDowns getLandingPageDropDowns() {
		logger.info("**************LandingPageDropDownController.getLandingPageDropDowns**************");
	    return landingPageDropDownHelper.getDropDownValueFromJson();
	}
	
	@GetMapping("/getHousingLoanInfo")
	public HousingLoanResponse getHousingLoanResponse(){
		RequestParam requestParam = new RequestParam();
		requestParam.setInterestRate(8.5);
		requestParam.setPrinciple(1000000.00);
		requestParam.setTenure(10.0);
		
		HousingLoanResponse response=null;
		try {
			response = restServiceImpl.postCall(requestParam.getClass(), "https://housingloancalcultor.herokuapp.com/services/housingloan/getHousingLoanInfo", HousingLoanResponse.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return response;
	}

}
