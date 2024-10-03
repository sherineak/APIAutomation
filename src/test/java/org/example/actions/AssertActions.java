package org.example.actions;

import io.restassured.response.Response;
import org.testng.Assert;

import static java.lang.String.valueOf;
import static org.testng.AssertJUnit.assertEquals;

public class AssertActions {
    public void verifyResponseBody(String actual, String expected, String description){
        assertEquals(actual,expected,description);
    }
    public void verifyResponseBody(float actual, float expected, String description){
        assertEquals(valueOf(actual), expected,description);
    }
    public void verifyResponseBody(Integer actual, Integer expected, String description){
        assertEquals(valueOf(Integer.valueOf(actual)), expected,description);
    }
 // Method overloading in the polymorphism
    public void verifyStatusCOdeInvalidReq(Response response){
        assertEquals(valueOf(valueOf(response.statusCode()).startsWith("50")),true,"Values of ststus code is" +response.getStatusCode());
    }

//    public void verifyStatusCode(Response response){
//
//     int statusCode = response.getStatusCode();
//     Assert.assertTrue(statusCode >= 200 && statusCode < 300,
//             "Expected status code to be in 2xx range, but got: " + statusCode);
//
//    }   OR
    public void verifyStatusCode(Response response, Integer expected){
        //assertEquals(response.getStatusCode(),expected);
        Assert.assertEquals(response.getStatusCode(), expected);

    }

}
