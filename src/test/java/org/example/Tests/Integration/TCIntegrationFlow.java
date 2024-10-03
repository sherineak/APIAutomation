package org.example.Tests.Integration;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.example.Base.BaseTest;
import org.example.Utils.PropertyReader;
import org.example.endpoints.APIConstants;
import org.example.pojos.Booking;
import org.example.pojos.BookingResponse;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

public class TCIntegrationFlow extends BaseTest {
    // Create a booking, Create a Token
    //Get Booking
    //Update Booking
    // Delete Booking

    @Test(groups = "integration",priority = 1)
    @Owner("Sherine")
    @Description("Tc#Int1 : Step 1 . verify that the Booking can be created")
    public void testCreateBooking(ITestContext iTestContext){ // to pass id to other functions
        iTestContext.setAttribute("token",getToken());

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
       // Below code is same as testCreateBookingPost expect set Booking Id , which required to validate Get function
        response = RestAssured
                .given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsStringPost()).post();

        validatableResponse = response.then().log().all();
        //Validatable assertion
        validatableResponse.statusCode(200);
        validatableResponse.body("booking.firstname", Matchers.equalTo("Jain"));

        // Deserialize (Deserialize the response Json to Object)
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());

        //need to Import  AssertJ - import static org.assertj.core.api.Assertions.*;
        assertThat(bookingResponse.getBooking()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Jain");
        //can read it from property file given below, there is a error in the below , will see 
        //assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo(PropertyReader.readKey("booking.firstname"));

        //TestNG Assertion, the function from AssertAction custom class
//            assertActions.verifyStatusCode(response);
        assertActions.verifyStatusCode(response,200);

        // Set Booking Id
        iTestContext.setAttribute("bookingid",bookingResponse.getBookingid());



    }
    @Test(groups = "integration", priority = 2)
    @Owner("Sherine")
    @Description("Verify the booking BY ID")
    public void testVerifyBookingId(ITestContext iTestContext){
        System.out.println("Token 3-" + iTestContext.getAttribute("token"));  // To get Token from the first function
         //rest/booking/123
        // Get booking Id
        //String bookingId = iTestContext.getAttribute("bookingid").toString();  booking id is integer, so correct it like below
        Integer bookingId = (Integer) iTestContext.getAttribute("bookingid");

        //Get Req
        String basePathGet= APIConstants.CREATE_UPDATE_BOOKING_URL+"/"+ bookingId;
        System.out.println(basePathGet);

        requestSpecification.basePath(basePathGet);
        response = RestAssured
                .given(requestSpecification)
                .when().get();          // body not required for Get Request

        validatableResponse = response.then().log().all();
        //Validatable assertion
        validatableResponse.statusCode(200);

        // we can further validate the response from the Get request
        // Deserialize (Deserialize the response Json to Object)
        Booking booking = payloadManager.getResponseFromJson(response.asString());

        //need to Import  AssertJ - import static org.assertj.core.api.Assertions.*;

        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo("Jain");
    }

    @Test(groups = "integration" , priority = 3)
    @Owner("Sherine")
    @Description("Verify the Updated Booking By ID")
    public void testUpdateBookingById(ITestContext iTestContext){
        System.out.println("Token 4-" + iTestContext.getAttribute("token"));  // To get Token
        String token =(String) iTestContext.getAttribute("token"); //Store token into String

        //PUT/PATCH
        Integer bookingId = (Integer) iTestContext.getAttribute("bookingid");
        String basePathPutPatch= APIConstants.CREATE_UPDATE_BOOKING_URL+"/"+ bookingId;
        System.out.println(basePathPutPatch);

        requestSpecification.basePath(basePathPutPatch);
        response = RestAssured
                .given(requestSpecification).cookie("token",token)   // we have to add token name for update
                .when().body(payloadManager.FullupdatePayloadAsStringPut()).put();

        validatableResponse = response.then().log().all();
        //Validatable assertion
        validatableResponse.statusCode(200);

        // Deserialize (Deserialize the response Json to Object)
        Booking booking = payloadManager.getResponseFromJson(response.asString());

        //need to Import  AssertJ - import static org.assertj.core.api.Assertions.*;

        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo("Sherine");
        assertThat(booking.getLastname()).isEqualTo("Antony");


    }

    @Test(groups = "Integration" , priority = 4)
    @Owner("Sherine")
    @Description("Verify the deleted Booking By Id")
    public void testDeleteBookingById(ITestContext iTestContext){
        System.out.println("Token 5-" + iTestContext.getAttribute("token"));  // To get Token
        String token =(String) iTestContext.getAttribute("token"); //Store token into String

        Integer bookingId = (Integer) iTestContext.getAttribute("bookingid");
        String baseDelete= APIConstants.CREATE_UPDATE_BOOKING_URL+"/"+ bookingId;
        System.out.println(baseDelete);

        requestSpecification.basePath(baseDelete);
        response = RestAssured
                .given(requestSpecification).cookie("token",token)   // we have to add token name for update
                .when().delete();

        validatableResponse = response.then().log().all();
        //Validatable assertion
        validatableResponse.statusCode(201);


    }


}
