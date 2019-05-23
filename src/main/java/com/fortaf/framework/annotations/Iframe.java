package com.fortaf.framework.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({FIELD,TYPE})
public @interface Iframe {

	String[] xpath() default "";
	String name() default "";
	int index() default 0;
	
}