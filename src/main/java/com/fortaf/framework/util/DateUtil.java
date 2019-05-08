package com.fortaf.framework.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.log4j.Logger;

public class DateUtil {

	private static final Logger logger = Logger.getLogger(DateUtil.class);

	/**
	 * Get the current date time in given format
	 * @param format 
	 * Eg:- dd/MM/yyyy HH:mm:ss
	 * @return Current date and time 
	 */
	public static String currentDate(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);  
	    Date date = new Date();
	    return formatter.format(date);  
	}
	
	/**
	 * Get future date
	 * @param noOfDays No of days in the future
	 * @param format format
	 * @return future date
	 */
	public static String futureDate(int noOfDays, String format){
		//TODO: Implement here
		throw new NotImplementedException("Not implemented");	
	}
	
	/**
	 * Get past date
	 * @param noOfDays No of days in the past
	 * @param format format
	 * @return past date
	 */
	public static String pastDate(int noOfDays, String format){
		//TODO: Implement here
		throw new NotImplementedException("Not implemented");
	}
}

/**
 * Reference: https://www.javatpoint.com/java-get-current-date
 *
 **/