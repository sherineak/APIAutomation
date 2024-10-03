package org.example.Tests.CrudOp;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import org.example.Base.BaseTest;
import org.example.endpoints.APIConstants;
import org.example.pojos.BookingResponse;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


public class testCreateBookingPost extends BaseTest {

        @Test(groups = "Smoke")   //Allure report
        @Owner("Sherine")
        @Severity(SeverityLevel.NORMAL)
        @Description("TC#1: Verify that the booking can be created")
        public void testCreateBooking(){

            requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

            response = requestSpecification.body(payloadManager.createPayloadBookingAsStringPost()).when().post();

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

            //TestNG Assertion, the function from AssertAction custom class
//            assertActions.verifyStatusCode(response);
            assertActions.verifyStatusCode(response,200);

    }
    @Test(groups = "Smoke")   //Allure report
    @Owner("Sherine")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#2: Verify  the booking Without payload")
    public void testCreateBookingNeg(){

            requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

            response = requestSpecification.body(payloadManager.createInvalidPayloadBookingAsStringPost()).when().post();

            validatableResponse = response.then().log().all();
            //Validatable assertion
            validatableResponse.statusCode(500);

        }
}
