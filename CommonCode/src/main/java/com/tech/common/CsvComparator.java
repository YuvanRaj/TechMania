package com.tech.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvComparator {

	public static void main(String[] args) throws IOException {
		String path1="C:\\Users\\dell\\Desktop\\Backup\\Desktop-Cleanup\\Feed\\test1.csv";
		String path2="C:\\Users\\dell\\Desktop\\Backup\\Desktop-Cleanup\\Feed\\test2.csv";
		
		writeOutputFile(path1, path2);
	}

	private static void writeOutputFile(String path1, String path2) throws IOException {
		List<String> srcRowList = getCsvFileContent(path1);
		List<String> destRowList = getCsvFileContent(path2);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < srcRowList.size(); i++) {
			String srcRow = srcRowList.get(i);
			String destRow = destRowList.get(i);

			
			
			if (srcRow == null || destRow == null || i ==0)
				continue;

			String[] srcRowToken = srcRow.split(",");
			String[] destRowToken = destRow.split(",");
			boolean isUnMatched = false;
			if (srcRowToken.length == destRowToken.length) {
				builder.append("Row " + i +" Columns ");
				
				for (int j = 0; j < srcRowToken.length; j++) {
					String srcColval = srcRowToken[j];
					String destColval = destRowToken[j];

					if (!srcColval.equals(destColval)) {
						isUnMatched = true;
						builder.append(srcColval);
						builder.append(",");
					}
				}
				
			}
			if(isUnMatched) {
				builder.append(" are UnMatched");
			}
			else {
				builder.append(" are Matched");
			}
			builder.append("\n");
		}
		writeOutPutcsvFile(builder.toString());
		System.out.println("Comparison done successfully");
	}

	private static void writeOutPutcsvFile(String content) {
		try (PrintWriter writer = new PrintWriter(new File("C:\\Users\\dell\\Desktop\\Backup\\Desktop-Cleanup\\Feed\\results.csv"))) {
			writer.write(content);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static List<String> getCsvFileContent(String path) throws IOException {
		String line = "";
		BufferedReader br = null;
		List<String> list = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(path));
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
		}
		return list;
	}
}
