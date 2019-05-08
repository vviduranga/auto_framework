package com.fortaf.framework.data;

import org.apache.commons.lang3.NotImplementedException;

public class TestDataHandler {

	/**
	 * Get the property file
	 * @param dataFolder Data folder
	 * @param dataFile 
	 * @return
	 */
	public static PropertyFileData getPropertyFile(String dataFolder, String dataFile){	
		PropertyFileData pfData = new PropertyFileData(dataFolder, dataFile);		
		return pfData;
	}
	
	/**
	 * Get the CSV file
	 * @param dataFolder
	 * @param dataFile
	 * @return
	 */
	public static CSVData getCSVFile(String dataFolder, String dataFile){	
		throw new NotImplementedException("Not Implemented");
	}
	
	/**
	 * Get the Excel file
	 * @param dataFolder
	 * @param dataFile
	 * @return
	 */
	public static ExcelData getExcelFile(String dataFolder, String dataFile){	
		throw new NotImplementedException("Not Implemented");
	}
}
