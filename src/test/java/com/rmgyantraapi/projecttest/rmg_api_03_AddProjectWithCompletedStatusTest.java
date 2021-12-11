package com.rmgyantraapi.projecttest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rmgyantraapi.genericUtility.ApiBaseClass;
import com.rmgyantraapi.genericUtility.IConstants;
import com.rmgyantraapi.genericUtility.IEndpoints;
import com.rmgyantraapi.genericUtility.JavaUtility;
import com.rmgyantraapi.pojo.utility.Project_PojoClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class rmg_api_03_AddProjectWithCompletedStatusTest extends ApiBaseClass {
	@Test
	public void addProjectWithCompletedStatusTest() throws Throwable {
		
		String status="Completed";
		String projectName = "deepak_pro-3"+JavaUtility.getRandomData();
		Project_PojoClass pojo=new Project_PojoClass("arijit", projectName, status, 10);
		Response response = given()
			.contentType(ContentType.JSON)
			.body(pojo)
		.when()
			.post(IConstants.URI+IEndpoints.AddProjectWithCompletedStatusTest_Endpoints);
		response.then()
			.assertThat().statusCode(201).log().all();
		String apiResponseProjName = response.jsonPath().get("projectName");
		
		System.out.println(apiResponseProjName);
		
		String dbProjName = dbLib.executeQueryAndGetDataFromDB("select * from project", 4, apiResponseProjName);
		String dbStatus = dbLib.executeQueryAndGetDataFromDB("select * from project", 5,status );
		Assert.assertEquals(dbProjName, apiResponseProjName);
	}

}
