package com.rmgyantraapi.genericUtility;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ApiBaseClass {
	
	
	public DataBaseUtility dbLib=new DataBaseUtility();
	@BeforeSuite
	public void configureBeforeSuite() throws Throwable {
		//Base_URI = "http://localhost:8084";
		dbLib.connectToDB();
		
	}
	
	@AfterSuite
	public void configureAfterSuite() throws Throwable {
		dbLib.closeDB();
		
	}

}
