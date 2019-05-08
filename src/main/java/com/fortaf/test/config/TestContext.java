package com.fortaf.test.config;

import java.util.Map;

public class TestContext {


	//private static Map<String, String> TESTPLAN_PARAMETERS = new HashMap<String, String>();

	protected static final ThreadLocal<Map<String, Object>> automationCache = new ThreadLocal<>();

	
	/**
	 * Get value from Test Context
	 * @param key context key
	 * @return value
	 */
	@SuppressWarnings("unchecked")
	public static final <o> o get(String key){
		Map<String, Object> cache = automationCache.get();
		if(!isNull()){
			return (o) cache.get(key);
		}
		return null;
	}
	
	/**
	 * Set a value in the Test Context
	 * @param key context key
	 * @param value value
	 */
	public static final void set(String key, Object value){
		Map<String, Object> cache = automationCache.get();
		cache.put(key, value);
	}
	
	/**
	 * Set a value in the Test Context if it's not existing already
	 * @param key context key
	 * @param value value
	 */
	public static final void setIfNotExist(String key, Object value){
		if (!isExist(key))
			set(key, value);
	}
	
	/**
	 * Remove the value of a particular key form the Test Context
	 * @param key context key
	 */
	public static final void remove(String key){
		Map<String, Object> cache = automationCache.get();
		cache.remove(key);
	}
	
	/**
	 * Check if the context is null
	 * @return true if not null
	 */
	public static final boolean isNull(){
		boolean status = false;
		if(automationCache.get() != null){
			status = true;
		}
		return status;
	}
	
	/**
	 * Check if a value is already present for a given key
	 * @param key context key
	 * @return true if present
	 */
	public static final boolean isExist(String key){
		boolean status = false;
		Map<String, Object> cache = automationCache.get();
		if(!isNull() && cache.containsKey(key) && get(key)!=null){
			status =true;
		}
		return status;
	}
	
	
}
