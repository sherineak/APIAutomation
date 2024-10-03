package org.example.Tests.Integration.Sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TCIntegration_Template extends BaseTest {

    // This template class should not present in our official repository , its template for future
    // Create a booking, Create a Token
    //Get Booking
    //Update Booking
    // Delete Booking

    @Test(groups = "integration",priority = 1)
    @Owner("Sherine")
    @Description("Tc#Int1 : Step 1 . verify that the Booking can be created")
    public void testCreateBooking(){

    }
    @Test(groups = "integration", priority = 2)
    @Owner("Sherine")
    @Description("Verify the booking BY ID")
    public void testVerifyBookingId(){
        Assert.assertTrue(true);
    }

    @Test(groups = "integration" , priority = 3)
    @Owner("Sherine")
    @Description("Verify the Updated Booking By ID")
    public void testUpdateBookingById(){

    }

    @Test(groups = "Integration" , priority = 4)
    @Owner("Sherine")
    @Description("Verify the deleted Booking By Id")
    public void testDeleteBookingById(){

    }


}
