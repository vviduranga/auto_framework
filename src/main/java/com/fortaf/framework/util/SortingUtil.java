package com.fortaf.framework.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RasithaE
 */
public class SortingUtil {

	/**
	 * Check if the string list is sorted
	 * @param list
	 * @return true if the data is sorted
	 */
    public boolean isSorted(List<String> list) {
        boolean sorted = true;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i - 1).compareTo(list.get(i)) > 0)
				sorted = false;
		}
        return sorted;
    }

    /**
     * Check if the integer list is sorted
     * @param list
     * @return true if the data is sorted
     */
    public boolean isSorted(ArrayList<Integer> list) {
        boolean sorted = true;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i - 1).compareTo(list.get(i)) > 0)
				sorted = false;
		}
        return sorted;
    }

    /**
     * Check if the integer array is sorted
     * @param data
     * @return true if the data is sorted
     */
    public static boolean isSorted(int[] data){
    	boolean sorted = true;
        for(int i = 1; i < data.length; i++){
            if(data[i-1] > data[i]){
            	sorted = false;
            }
        }
        return sorted;
    }

    /**
     * Check if the double list is sorted
     * @param data
     * @return true if the data is sorted
     */
    public static boolean isSorted(double[] data){
    	boolean sorted = true;
        for(int i = 1; i < data.length; i++){
            if(data[i-1] > data[i]){
            	sorted = false;
            }
        }
        return sorted;
    }


}