package org.example.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.example.pojos.Booking;
import org.example.pojos.BookingDates;
import org.example.pojos.BookingResponse;

public class PayloadManager {
Gson gson;
public String createPayloadBookingAsStringPost(){


    Booking booking = new Booking();
    booking.setFirstname("Jain");

    // to get data dynamicaly can use faker
    Faker faker = new Faker();
    booking.setLastname(faker.name().lastName());

    booking.setTotalprice(120);
    booking.setDepositpaid(true);

    BookingDates bookingdates = new BookingDates();
    bookingdates.setCheckin("2019-01-01");
    bookingdates.setCheckout("2020-01-01");
    booking.setBookingdates(bookingdates);
    booking.setAdditionalneeds("Breakfast");
    gson = new Gson();
    return gson.toJson(booking);
}
    public String createInvalidPayloadBookingAsStringPost(){


        return "{}" ;  //empty
    }
public String FullupdatePayloadAsStringPut (){
    Booking booking = new Booking();
    booking.setFirstname("Sherine");
    booking.setLastname("Antony");
    booking.setTotalprice(120);
    booking.setDepositpaid(true);

    BookingDates bookingdates = new BookingDates();
    bookingdates.setCheckin("2019-01-01");
    bookingdates.setCheckout("2020-01-01");
    booking.setBookingdates(bookingdates);
    booking.setAdditionalneeds("Breakfast");
    gson = new Gson();
    return gson.toJson(booking);

}
public BookingResponse bookingResponseJava(String responseString){
    gson = new Gson();
    BookingResponse bookingResponse = gson.fromJson(responseString,BookingResponse.class);
    return bookingResponse;

}

}
