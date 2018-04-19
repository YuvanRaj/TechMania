package com.angular.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.angular.cfc.HousingLoanInfo;
import com.angular.cfc.RequestParam;

/**
 * Controller used to calculate the housing loan for given tenure, principle, interest rate
 * @author Yuvaraj
 *
 */
@Path("/housingloan")
public class HousingLoanController {

	@Path("getHousingLoanInfo")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public static List<HousingLoanInfo> getHousingLoanInfoList(RequestParam requestParam){
		
		Double p = requestParam.getPrinciple();
		Double r = (requestParam.getInterestRate()/100)/12;
		Double n = requestParam.getTenure();
		
		Double numerator = Math.pow(1+r,n);
		Double denominator = numerator -1;
		Double emi = (double) Math.round((p* r * numerator)/denominator);
		
		List<HousingLoanInfo> housingInfoList = new ArrayList<HousingLoanInfo>();
		HousingLoanInfo housingLoanInfo = new HousingLoanInfo();
		
		housingLoanInfo.setEmi(emi);
		housingLoanInfo.setInterest(p*r);
		housingLoanInfo.setPrinciple(emi-(p*r));
		housingLoanInfo.setOpeningBalance(p);
		housingInfoList.add(housingLoanInfo);
		
		for(int i=1;i<n;i++){
			housingLoanInfo = housingInfoList.get(i-1);
			
			Double openBalance = housingLoanInfo.getOpeningBalance();
			Double principle = housingLoanInfo.getPrinciple();
			Double closeBalance = openBalance - principle;
			
			housingLoanInfo = new HousingLoanInfo();
			housingLoanInfo.setInterest(closeBalance*r);
			housingLoanInfo.setEmi(emi);
			housingLoanInfo.setOpeningBalance(closeBalance);
			housingLoanInfo.setPrinciple(emi-(closeBalance*r));
			
			housingInfoList.add(housingLoanInfo);
		}
		
		List<HousingLoanInfo> yearlyInfoList = getYearlyInfoList(housingInfoList);
		
		return yearlyInfoList;
		
	}
	
	private static List<HousingLoanInfo> getYearlyInfoList(List<HousingLoanInfo> housingInfoList) {
		List<HousingLoanInfo> yearlyList = new ArrayList<HousingLoanInfo>(10);
		int counter = 0;
		Double cumulativeInterest = 0.0;
		Double cumulativePrinciple = 0.0;
		Double openingBalance = 0.0;
		Double emi = 0.0;
		HousingLoanInfo yearlyInfo = null;
		int yearCounter = 1;
		for(HousingLoanInfo housingLoanInfo : housingInfoList){
			counter++;
			if(counter%13 == 0){
				yearlyInfo= new HousingLoanInfo();
				yearlyInfo.setInterest((double) Math.round(cumulativeInterest));
				yearlyInfo.setPrinciple((double) Math.round(cumulativePrinciple));
				yearlyInfo.setOpeningBalance((double) Math.round(openingBalance));
				yearlyInfo.setYear(yearCounter);
				yearlyInfo.setEmi(emi*12);
				cumulativeInterest = 0.0;
				cumulativePrinciple = 0.0;
				counter = 0;
				yearCounter++;
				yearlyList.add(yearlyInfo);
			}
			else {
				openingBalance = housingLoanInfo.getOpeningBalance();
				emi = housingLoanInfo.getEmi();
				cumulativeInterest += housingLoanInfo.getInterest();
				cumulativePrinciple += housingLoanInfo.getPrinciple();
			}
		}
		return yearlyList;
	}

	public static void main(String str[]){
		RequestParam reqParam = new RequestParam();
		reqParam.setPrinciple(1000000.00);
		reqParam.setInterestRate(8.4);
		reqParam.setTenure(120.0);
		
		List<HousingLoanInfo> list = getHousingLoanInfoList(reqParam);
		
		for(HousingLoanInfo housingLoanInfo  : list){
			System.out.println("  Opening Balance :: "+"\t"+housingLoanInfo.getOpeningBalance() + "  Principle ::"+"\t"+housingLoanInfo.getPrinciple()+"  Interest ::"+"\t"+housingLoanInfo.getInterest());
		}
	}
}
