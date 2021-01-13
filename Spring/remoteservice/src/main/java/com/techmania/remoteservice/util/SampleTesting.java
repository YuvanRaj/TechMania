package com.techmania.remoteservice.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class SampleTesting {
	
	public static void main(String[] str) throws Exception {
		SampleTesting sampleTesting = new SampleTesting();
		Map<String,List<String[]>> testMap = readCsv();
		Map<String,List<String[]>> filteredMap = filteredMap(testMap);
	//	Map<String,List<String[]>> testMap = new HashMap<String,List<String[]>>();
		sampleTesting.writeDataAtOnce(filteredMap);
	}

	

	private static Map<String, List<String[]>> filteredMap(Map<String, List<String[]>> testMap) {
		Map<String, List<String[]>> filteredMap = new HashMap<String, List<String[]>>();
		StringBuilder builder = new StringBuilder();
		long count =0;
		for(Entry<String, List<String[]>>  entry: testMap.entrySet()) {
			List<String[]> list = entry.getValue();
			if(list.size() <7) {
				builder.append(entry.getKey());
				builder.append("\n");
				count++;
			}
			else {
				filteredMap.put(entry.getKey(), entry.getValue());
			}
		}
		System.out.println("Excluded Product Count"+count);
		System.out.println("filteredMap size"+filteredMap.size());
		return filteredMap;
	}



	private static Map<String, List<String[]>> readCsv() throws IOException {
		Map<String,List<String[]>> testMap = new HashMap<String,List<String[]>>();
		
		FileReader filereader = new FileReader("C:\\Users\\dell\\Downloads\\new_Data.csv"); 
		  
        
        CSVReader csvReader = new CSVReader(filereader); 
        String[] nextRecord; 
  
        // we are going to read data line by line 
        List<String[]> list = new ArrayList<String[]>();
        
        while ((nextRecord = csvReader.readNext()) != null) {       	
        	String product=nextRecord[1];
        	
        	if(product.equalsIgnoreCase("product")) {
        		continue;
        	}
        	
        	if(testMap.get(product) != null) {
        		List<String[]> l = testMap.get(product);
        		l.add(nextRecord);
        		testMap.put(product, l);
        	}
        	else {
        		list = new ArrayList<String[]>();
        		list.add(nextRecord);
        		testMap.put(product, list);
        	}
        } 
        System.out.println("Reading done"); 
        csvReader.close();
        System.out.println("Unique_Product"+testMap.size());
		return testMap;
	}

	public static void writeDataAtOnce(Map<String,List<String[]>> testMap) throws Exception {

		// first create file object for file placed at location
		// specified by filepath		
		int value=3500;
		FileWriter fileWriter1 = new FileWriter(new File("C:\\Users\\dell\\Desktop\\Feed\\new_file1.csv"));
		FileWriter fileWriter2 = new FileWriter(new File("C:\\Users\\dell\\Desktop\\Feed\\new_file2.csv"));
		FileWriter fileWriter3 = new FileWriter(new File("C:\\Users\\dell\\Desktop\\Feed\\new_file3.csv"));
		FileWriter fileWriter4 = new FileWriter(new File("C:\\Users\\dell\\Desktop\\Feed\\new_file4.csv"));
		FileWriter fileWriter5 = new FileWriter(new File("C:\\Users\\dell\\Desktop\\Feed\\new_file5.csv"));
		FileWriter fileWriter6 = new FileWriter(new File("C:\\Users\\dell\\Desktop\\Feed\\new_file6.csv"));
		FileWriter fileWriter7 = new FileWriter(new File("C:\\Users\\dell\\Desktop\\Feed\\new_file7.csv"));
		
		
		CSVWriter writer1  = new CSVWriter(fileWriter1);
		CSVWriter writer2  = new CSVWriter(fileWriter2);
		CSVWriter writer3  = new CSVWriter(fileWriter3);
		CSVWriter writer4  = new CSVWriter(fileWriter4);
		CSVWriter writer5  = new CSVWriter(fileWriter5);
		CSVWriter writer6  = new CSVWriter(fileWriter6);
		CSVWriter writer7  = new CSVWriter(fileWriter7);
		try {
			
			int count =0;
			List<List<String[]>> list =new ArrayList<List<String[]>>();
			
			long size=0;
			long filteredCount =0;
			StringBuilder builder = new StringBuilder();
			for(Entry<String, List<String[]>>  entry: testMap.entrySet()) {
				
				/*if(entry.getValue().size() < 7) {
					filteredCount++;
					builder.append(entry.getKey());
					builder.append("\n");
					continue;
				}*/
				
				count++;
				
				if(count <= 3500) {
					size +=entry.getValue().size();
					
					
					writer1.writeAll(entry.getValue());
					
					if(count== 3500) {
						System.out.println("First Set Unique Record Count"+size);
						size =0;
					}
					
				}
				else if(count > 3500 && count <= 7000) {
					size +=entry.getValue().size();
					
					writer2.writeAll(entry.getValue());
					
					if(count== 3500*2) {
						System.out.println("Second Set Unique Record Count"+size);
						size =0;
					}
				}
				else if(count > 7000 && count <= 10500) {
					size +=entry.getValue().size();
					
					writer3.writeAll(entry.getValue());
					
					if(count== 3500*3) {
						System.out.println("3rd Set Unique Record Count"+size);
						size =0;
					}
				}
				else if(count > 10500 && count <= 14000) {
					size +=entry.getValue().size();
					
					writer4.writeAll(entry.getValue());
					
					if(count== 3500*4) {
						System.out.println("4th Set Unique Record Count"+size);
						size =0;
					}
				}
				else if(count > 14000 && count <= 17500) {
					size +=entry.getValue().size();
					
					writer5.writeAll(entry.getValue());
					
					if(count== 3500*5) {
						System.out.println("5th Set Unique Record Count"+size);
						size =0;
					}
				}
				else if(count > 17500 && count <= 21000) {
					size +=entry.getValue().size();
					
					writer6.writeAll(entry.getValue());
					
					if(count== 3500*6) {
						System.out.println("6th Set Unique Record Count"+size);
						size =0;
					}
				}
				else if(count > 21000) {
					
					writer7.writeAll(entry.getValue());
					
					size +=entry.getValue().size();
					
					
						
				}
			
			}
			
			 FileWriter fw=new FileWriter("C:\\Users\\dell\\Desktop\\Feed\\Product_Filtered.txt");    
	         fw.write(builder.toString());    
	         fw.close(); 
			System.out.println("7th Set Unique Record Count"+size);
			System.out.println("Total Count"+count);
			System.out.println("filteredCount Count"+filteredCount);
			
			// create FileWriter object with file as parameter
			

			// create CSVWriter object filewriter object as parameter
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		finally{
			System.out.println("Finally");
			   if (writer1!=null){
				   writer1.flush();
				   writer1.close();
			   }
			   if (writer2!=null){
				   writer2.flush();
				   writer2.close();
			   }
			   if (writer3!=null){
				   writer3.flush();
				   writer3.close();
			   }
			   if (writer4!=null){
				   writer4.flush();
				   writer4.close();
			   }
			   if (writer5!=null){
				   writer5.flush();
				   writer5.close();
			   }
			   if (writer6!=null){
				   writer6.flush();
				   writer6.close();
			   }
			   if (writer7!=null){
				   writer7.flush();
				   writer7.close();
			   }
			}
	}

	public static void writeCSV(CSVWriter writer,FileWriter fileWriter,List<String[]> list) throws IOException {
		System.out.println("Successfully started");
		
		 
		writer.writeAll(list);
		
		System.out.println("Loop Completed");
		

		
		

		// closing writer connection
		
		System.out.println("Successfully Completed");
	}
	
	
}
