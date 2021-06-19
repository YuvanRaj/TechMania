package com.tech.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * File util class
 * 
 * @author Yuvaraj
 *
 */
public class FileIOUtil {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private static void writeOutPutcsvFile(String content, String filePath) {
		try (PrintWriter writer = new PrintWriter(new File(filePath))) {
			writer.write(content);
		} catch (FileNotFoundException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
	}
}
