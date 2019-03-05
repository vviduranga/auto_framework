package com.fortaf.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface TestConfig {

	public enum Priority {
		LOW, MEDIUM, HIGH
	}

	public enum Browser{
		chrome,ie,firefox
	}
	
	Browser browser() default Browser.chrome;
	
	Priority priority() default Priority.MEDIUM;

	String[] tags() default "";

	String createdBy() default "";

	String lastModified() default "";
	
	String baseUrl() default "";
}
