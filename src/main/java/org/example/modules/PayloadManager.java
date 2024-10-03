package org.example.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.example.pojos.*;

public class PayloadManager {
Gson gson;
public String createPayloadBookingAsStringPost(){

  // From Pojo class   --here  Convert object to json String (serialization)
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
    //deserialization
    BookingResponse bookingResponse = gson.fromJson(responseString,BookingResponse.class);
    return bookingResponse;

}
public String setAuthPayload(){
    Auth auth = new Auth();
    auth.setUsername("admin");
    auth.setPassword("password123");
    gson = new Gson();

    System.out.println("payload set to " +gson.toJson(auth));
    return gson.toJson(auth);
}
public String getTokenFromJson(String tokenResponse){
// here will do deserialization   -->  Response  (Json String)   to --> Object TokenResponse
    // We have already created a token response class under pojo
    gson = new Gson();
    TokenResponse tokenResponse1 = gson.fromJson(tokenResponse, TokenResponse.class);
//    return tokenResponse1.getTokenResponse();
    System.out.println("Token1" + tokenResponse1.getToken());
    return tokenResponse1.getToken();
}
public Booking getResponseFromJson(String getResponse){
    gson = new Gson();
    //Deserialization
    Booking booking= gson.fromJson(getResponse,Booking.class);
    //
    return booking;
}
}
