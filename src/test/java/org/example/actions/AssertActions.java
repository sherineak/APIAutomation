package org.example.actions;

import io.restassured.response.Response;

import static org.testng.AssertJUnit.assertEquals;

public class AssertActions {
    public void verifyResponseBody(String actual, String expected, String description){
        assertEquals(actual,expected,description);
    }
    public void verifyResponseBody(float actual, float expected, String description){
        assertEquals(String.valueOf(actual), expected,description);
    }
    public void verifyResponseBody(Integer actual, Integer expected, String description){
        assertEquals(String.valueOf(Integer.valueOf(actual)), expected,description);
    }
 // Method overloading in the polymorphism
    public void verifyStatusCOdeInvalidReq(Response response){
        assertEquals(String.valueOf(String.valueOf(response.statusCode()).startsWith("50")),true,"Values of ststus code is" +response.getStatusCode());
    }

}
