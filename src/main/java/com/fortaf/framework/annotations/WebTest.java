package com.fortaf.framework.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.fortaf.framework.common.Browser;
import com.fortaf.framework.common.Priority;

@Retention(RUNTIME)
@Target(TYPE)
public @interface WebTest {
	
	Browser browser() default Browser.chrome;	
	Priority priority() default Priority.MEDIUM;
	String baseUrl() default "";

	String[] tags() default "";
	String createdBy() default "";
	String lastModified() default "";	

}