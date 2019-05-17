package com.fortaf.framework.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.fortaf.framework.common.Priority;

@Retention(RUNTIME)
@Target(TYPE)
public @interface APITest {

	Priority priority() default Priority.MEDIUM;
	String endPointURL() default "";
	
	String[] tags() default "";
	String createdBy() default "";
	String lastModified() default "";	

}