package org.example.Base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.checkerframework.checker.units.qual.A;
import org.example.actions.AssertActions;
import org.example.endpoints.APIConstants;
import org.example.modules.PayloadManager;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    //BaseTest - Father --> testcase --Son --> Single Inheritance
    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;

    @BeforeTest
    public void setConfig(){
        System.out.println("Before Test");
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
//        requestSpecification = new RequestSpecBuilder()
//                .setBaseUri(APIConstants.Base_URL)
//                .addHeader("Content- Type","application/json")
//                .build().log().all();
        requestSpecification = RestAssured.given().baseUri(APIConstants.Base_URL)
    .contentType(ContentType.JSON).log().all();


    }

    public String getToken(){
        return null;
    }
}
