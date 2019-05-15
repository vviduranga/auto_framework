package com.fortaf.framework.data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.apache.commons.lang3.NotImplementedException;

import com.github.javafaker.*;
import com.github.javafaker.Number;

import java.util.Calendar;
import java.util.Date;

public class RandomData {

	/**
     * Get random number
     * @return
     */
    public static long getRandomNumber(){
        Faker faker = new Faker();
        return faker.number().randomNumber();
    }

    /**
     * Get random number below a max number
     * @param max maximum
     * @return random number
     */
    public static long getRandomNumber(long max){
        Faker faker = new Faker();
        return faker.number().numberBetween(0,max);
    }

    /**
     * Get random number between min & max number
     * @param min minimum
     * @param max maximum
     * @return random number
     */
    public static long getRandomNumber(int min, int max){
        Faker faker = new Faker();
        return faker.number().numberBetween(min,max);
    }

    /**
     * Generate a random string with given length
     * @param length length of the string
     * @return random string
     */
    public static String getRandomText(int length)
    {
        Random rng = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    /**
     * Get paragraph of given sentence count
     * @param sentenceCount no of sentences
     * @return random paragraph
     */
    public static String getParagraph(int sentenceCount)
    {
        Faker faker = new Faker();
        return faker.lorem().paragraph(sentenceCount);
    }

    /**
     * Get current date in given format
     * @param format format
     * 		Eg: - "yyyy/MM/dd HH:mm:ss"
     * @return date string
     */
    public static String getCurrentDate(String format){
        DateFormat dateFormat = new SimpleDateFormat(format);
        //get current date time with Date()
        Date date = new Date();
        return dateFormat.format(date);
    }


    /**
     * Get the future date by a given number of days, months, years
     * @param daysInFuture No of days in the future
     * @param monthsInFuture No of months in the future
     * @param yearsInFuture No of years in the future
     * @param format format
     * 		Eg: - "yyyy/MM/dd HH:mm:ss"
     * @return the future date as string
     */
    public static String getFutureDate(int daysInFuture, int monthsInFuture, int yearsInFuture, String format){
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.DATE, daysInFuture);
    	cal.add(Calendar.MONTH, monthsInFuture);
    	cal.add(Calendar.YEAR, yearsInFuture);
    	
    	Date futureDate = cal.getTime();
    	System.out.println("Future Date is: " + futureDate);
        
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(futureDate);
    }

    /**
     * Get the future date by a given number of days, months, years
     * @param daysInFuture No of days in the future
     * @param monthsInFuture No of months in the future
     * @param yearsInfuture No of years in the future
     * @return the future date
     */
    public static Date getFutureDate(int daysInFuture, int monthsInFuture, int yearsInfuture){
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.DATE, daysInFuture);
    	cal.add(Calendar.MONTH, monthsInFuture);
    	cal.add(Calendar.YEAR, yearsInfuture);
    	
    	Date futureDate = cal.getTime();
    	System.out.println("Future Date is: " + futureDate);
        return futureDate;
    }
    
    /**
     * Get the past date by a given number of days, months, years
     * @param daysInPast No of days in the past
     * @param monthsInPast No of months in the past
     * @param yearsInPast No of years in the past
     * @param format format
     * 		Eg: - "yyyy/MM/dd HH:mm:ss"
     * @return the past date as string
     */
	public static String getPastDate(int daysInPast, int monthsInPast, int yearsInPast, String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -daysInPast);
		cal.add(Calendar.MONTH, -monthsInPast);
		cal.add(Calendar.YEAR, -yearsInPast);

		Date pastDate = cal.getTime();
		System.out.println("Past Date is: " + pastDate);

		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(pastDate);
	}

    // Useful data objects for testing
    public static Address address(){
        Faker faker = new Faker();
        return faker.address();
    }

    public static Company company(){
        Faker faker = new Faker();
        return faker.company();
    }

    public static Number number(){
        Faker faker = new Faker();
        return faker.number();
    }

    public static Color color(){
        Faker faker = new Faker();
        return faker.color();
    }

    public static Internet internet(){
        Faker faker = new Faker();
        return faker.internet();
    }

    public static DateAndTime date(){
        Faker faker = new Faker();
        return faker.date();
    }

    public static Name name(){
        Faker faker = new Faker();
        return faker.name();
    }

    public static PhoneNumber phoneNumber(){
        Faker faker = new Faker();
        return faker.phoneNumber();
    }
    
    public static Code code(){
        Faker faker = new Faker();
        return faker.code();
    }
    
    public static Country country(){
        Faker faker = new Faker();
        return faker.country();
    }
       
    public static Lorem lorem(){
        Faker faker = new Faker();
        return faker.lorem();
    }
    
    
}
