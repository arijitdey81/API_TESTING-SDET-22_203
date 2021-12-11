package com.rmgyantraapi.endtoendtest;

import org.testng.annotations.Test;

import com.rmgyantraapi.genericUtility.IConstants;
import com.rmgyantraapi.genericUtility.IEndpoints;
import com.rmgyantraapi.genericUtility.JavaUtility;
import com.rmgyantraapi.genericUtility.jsonPathUtility;
import com.rmgyantraapi.pojo.utility.Employee_PojoClass;
import com.rmgyantraapi.pojo.utility.Project_PojoClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class createProject_and_Allocate_USER_Test {
	@Test
	public void createproject_and_Allocate_User() {
		String status="Completed";
		String projectName = "Airtel"+JavaUtility.getRandomData();
		Project_PojoClass pojo=new Project_PojoClass("arijit",projectName ,status, 12);
		//execute API 
		Response response = given()
			.contentType(ContentType.JSON)
			.body(pojo)
		.when()
			.post(IConstants.URI+IEndpoints.AddProjectWithCreatedStatusTest_Endpoints);
		response.then()
			.assertThat().statusCode(201).log().all();
		//String apiResponseProjName = response.jsonPath().get("projectName");
		
		String apiResponseProjName=jsonPathUtility.getjsonPath(response, "projectName");
		Employee_PojoClass emp_pojo=new Employee_PojoClass("SDET", "08/01/1993", "my.arijit52@gmail.com", "arijit_dey", 4.2,"7797781581", apiResponseProjName, "ROLE_ADMIN", "arijit_d");
			given()
				.contentType(ContentType.JSON)
				.body(pojo)
			.when()
				.post(IConstants.URI+IEndpoints.createproject_and_Allocate_User_Endpoints);
			response.then()
				.assertThat().statusCode(201).log().all();
	}

}
