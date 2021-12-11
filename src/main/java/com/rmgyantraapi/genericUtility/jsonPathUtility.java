package com.rmgyantraapi.genericUtility;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class jsonPathUtility {
	@Test
	public static String getjsonPath(Response response, String jsonXpath) {
		String jsonData = response.jsonPath().get(jsonXpath);
		return jsonData;
		
	}

}
