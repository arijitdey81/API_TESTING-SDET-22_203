package com.rmgyantraapi.genericUtility;

import java.util.Date;
import java.util.Random;
/**
 * 
 * @author ARIJIT
 *
 */
public class JavaUtility {
	/**
	 * This method is generate random number to avoid duplicates
	 * @return
	 */
	public static String getRandomData() {
		Random random=new Random();
		int ran=random.nextInt(1000);
		return ""+ran;
		
	}
	
	/**
	 * 
	 * This method is 
	 * @return
	 */
	
	public static String getCurrentDate() {
		Date date=new Date();
		String currentdate=date.toString().replace(" ", "_").replace(":", "_");
		return currentdate;
	}


}
