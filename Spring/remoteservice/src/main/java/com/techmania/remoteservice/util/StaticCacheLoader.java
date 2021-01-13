package com.techmania.remoteservice.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.techmania.remoteservice.bean.DropDowns;
import com.techmania.remoteservice.bean.KeyAndValue;
import com.techmania.remoteservice.constants.LandingDropDownConstants;

@Component
public class StaticCacheLoader {
	
	private static final Logger logger = LogManager.getLogger(StaticCacheLoader.class);
	
	public void prepareLandingPageDropDowns() {
		logger.info("************StaticCacheLoader prepareLandingPageDropDowns starts*********");
		deleteFileIfExist();
		DropDowns dropDowns = new DropDowns();
		loadLandingPageDropDowns(dropDowns);
		prepareStaticJsonForDropDowns(dropDowns);
		logger.info("************StaticCacheLoader prepareLandingPageDropDowns ends*********");
	}

	private void loadLandingPageDropDowns(DropDowns dropDowns) {	
		logger.info("************StaticCacheLoader loadLandingPageDropDowns starts*********");
		//Page1 Education Level Cache Load
		populateEducationLevelDropDowns(dropDowns);
		
		//Page1 Graduation Year Cache Load
		populateGraducationYearDropDowns(dropDowns);
		
		populateCountryDropDowns(dropDowns);
		
		populateStateDropDowns(dropDowns);
		
		populateClassTimingDropDowns(dropDowns);
		
		populateMilitaryAffiDropDowns(dropDowns);
		
		logger.info("************StaticCacheLoader loadLandingPageDropDowns ends*********");
	}

	private void populateMilitaryAffiDropDowns(DropDowns dropDowns) {
		logger.info("************StaticCacheLoader populateMilitaryAffiDropDowns starts*********");
		List<KeyAndValue> list = new ArrayList<KeyAndValue>();
		populateKeyValueList(list,LandingDropDownConstants.MILITARY_AFFILIATION);		
		dropDowns.setMilitaryTimings(list);		
		logger.info("************StaticCacheLoader populateMilitaryAffiDropDowns ends*********");
	}

	private void populateClassTimingDropDowns(DropDowns dropDowns) {
		logger.info("************StaticCacheLoader populateClassTimingDropDowns starts*********");
		List<KeyAndValue> list = new ArrayList<KeyAndValue>();
		populateKeyValueList(list,LandingDropDownConstants.CLASSTIMING_FILENAME);		
		dropDowns.setClassTimings(list);
		logger.info("************StaticCacheLoader populateClassTimingDropDowns ends*********");
	}

	private void populateStateDropDowns(DropDowns dropDowns) {
		logger.info("************StaticCacheLoader populateStateDropDowns starts*********");
		List<KeyAndValue> list = new ArrayList<KeyAndValue>();
		populateKeyValueList(list,LandingDropDownConstants.STATE_FILENAME);		
		dropDowns.setStates(list);
		logger.info("************StaticCacheLoader populateStateDropDowns ends*********");
	}

	private void populateCountryDropDowns(DropDowns dropDowns) {
		logger.info("************StaticCacheLoader populateCountryDropDowns starts*********");
		List<KeyAndValue> list = new ArrayList<KeyAndValue>();
		populateKeyValueList(list,LandingDropDownConstants.COUNTRY_FILENAME);		
		dropDowns.setCountries(list);
		logger.info("************StaticCacheLoader populateCountryDropDowns ends*********");
	}

	private void populateEducationLevelDropDowns(DropDowns dropDowns) {
		logger.info("************StaticCacheLoader populateEducationLevelDropDowns starts*********");
		List<KeyAndValue> list = new ArrayList<KeyAndValue>();
		populateKeyValueList(list,LandingDropDownConstants.EDUCATION_LEVEL_FILENAME);		
		dropDowns.setEducationLevel(list);
		logger.info("************StaticCacheLoader populateEducationLevelDropDowns ends*********");
	}
	
	private void populateGraducationYearDropDowns(DropDowns dropDowns) {
		logger.info("************StaticCacheLoader populateGraducationYearDropDowns starts*********");
		List<KeyAndValue> list = new ArrayList<KeyAndValue>();
		populateKeyValueList(list,LandingDropDownConstants.GRADUATION_YEAR_FILENAME);		
		dropDowns.setGraduationYear(list);
		logger.info("************StaticCacheLoader populateGraducationYearDropDowns ends*********");
	}

	private void populateKeyValueList(List<KeyAndValue> list,String fileName) {
		logger.info("************StaticCacheLoader prepareStaticJsonForDropDowns starts*********");
		KeyAndValue keyAndValue = null;		
		try(Scanner scanner = new Scanner(new File("src/main/resources/"+fileName+".properties"))) {			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] token= line.split(LandingDropDownConstants.PROPERTY_VALUE_SEPARATOR);
				if(token !=null && token.length > 0) {
					keyAndValue = new KeyAndValue();
				    keyAndValue.setLabel(token[0]);
				    keyAndValue.setValue(token[1]);
				    list.add(keyAndValue);
				}				
			}
		} catch (IOException e) {			
			logger.error("************Exception*********",e);
		}
		logger.info("************StaticCacheLoader prepareStaticJsonForDropDowns ends*********");
	}

	

	private void prepareStaticJsonForDropDowns(Object object) {
		logger.info("************StaticCacheLoader prepareStaticJsonForDropDowns starts*********");
		File file = new File("src/main/resources/"+LandingDropDownConstants.DROP_DOWN_JSON_FILENAME);
		Gson gson = new Gson();
		try(FileWriter writer = new FileWriter(file)) {
			gson.toJson(object, writer);
		} catch (JsonIOException e) {
			logger.error("************Exception*********",e);
		} catch (IOException e) {
			logger.error("************Exception*********",e);
		}
		logger.info("************StaticCacheLoader prepareStaticJsonForDropDowns ends*********");
	}

	private void deleteFileIfExist() {
		logger.info("************StaticCacheLoader deleteFileIfExist starts*********");
		File file = new File("src/main/resources/"+LandingDropDownConstants.DROP_DOWN_JSON_FILENAME);	
		if(file.exists() && file.delete()) {
			System.out.println("File is Successsfully deleted");
			logger.error("************File is Successsfully deleted*********");
		}
		else {
			logger.error("************First time file Creation*********");
		}
		logger.info("************StaticCacheLoader deleteFileIfExist ends*********");
	}
}
