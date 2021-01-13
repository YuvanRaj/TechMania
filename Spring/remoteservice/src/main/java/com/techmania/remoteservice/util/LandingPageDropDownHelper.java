package com.techmania.remoteservice.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.techmania.remoteservice.bean.DropDowns;
import com.techmania.remoteservice.constants.LandingDropDownConstants;

@Component
public class LandingPageDropDownHelper {
	
	private static final Logger logger = LogManager.getLogger(LandingPageDropDownHelper.class);

	public DropDowns getDropDownValueFromJson() {
		logger.info("**************LandingPageDropDownHelper.getDropDownValueFromJson starts**************");
		Gson gson = new Gson();
		DropDowns dropDowns = new DropDowns();
		try (Reader reader = new FileReader("src/main/resources/"+LandingDropDownConstants.DROP_DOWN_JSON_FILENAME)) {
			dropDowns = gson.fromJson(reader, DropDowns.class);
		} catch (IOException e) {
			logger.error("**************LandingPageDropDownHelper.getDropDownValueFromJson starts**************",e);
		}
		logger.info("**************LandingPageDropDownHelper.getDropDownValueFromJson ends**************");
		return dropDowns;
	}
}
