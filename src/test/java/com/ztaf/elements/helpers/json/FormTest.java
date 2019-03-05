package com.ztaf.elements.helpers.json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;
import com.fortaf.annotations.TestConfig.Browser;
import com.fortaf.annotations.TestConfig;
import com.google.gson.Gson;
import com.ztaf.elements.helpers.FormTestObject;

/**
 * Test the form element types.
 */
@TestConfig(browser=Browser.chrome, baseUrl = "http://www.google.com")
public class FormTest {

	static FormTestObject testObject;

	@Test
    public void jsontest() throws InterruptedException, IOException {
		
		String jsonString = new String(Files.readAllBytes(Paths.get("C:\\code\\fortaf\\src\\test\\java\\com\\ztaf\\elements\\helpers\\json\\jsonString.txt"))); 
	    

		
		Student student = new Gson().fromJson(jsonString, Student.class);
		
		System.out.println("ID: " +student.getId());
		System.out.println("Name: " +student.getName());
		System.out.println("Address: " +student.getAddress().getRoad());

		
    }

}
