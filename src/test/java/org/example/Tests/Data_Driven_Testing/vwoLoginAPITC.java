package org.example.Tests.Data_Driven_Testing;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.Utils.UtilsExcel;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;


public class vwoLoginAPITC {
    RequestSpecification r2;
    ValidatableResponse vr2;
    Integer ID;
    Response res2;

    @Test(dataProvider = "getData", dataProviderClass = UtilsExcel.class)
    public void testVWOLogin(String email, String password){
        System.out.println("----Login API Testing----");
        System.out.println(email);
        System.out.println(password);

        // Payload manger class under the folder Modules  using for TCIntegrationFlow class

        // Below is the payload for this VWLogin need to move under payload Manager
        VWOLoginPOJO vwoLoginPO = new VWOLoginPOJO();
        vwoLoginPO.setUsername(email);
        vwoLoginPO.setPassword(password);
        vwoLoginPO.setRecaptchaResponseField("");
        vwoLoginPO.setRemember(false);

        Gson gson = new Gson();
        String payload = gson.toJson(vwoLoginPO);

        // Rest Assured code this can move to Base Test class

        r2 = RestAssured.given();
        r2.baseUri("https://app.vwo.com");
        r2.basePath("/login");
        r2.contentType(ContentType.JSON);
        //r2.body(vwoLoginPO).log().all();

        res2 = r2.when().post();
        vr2 = res2.then();

        String resString = res2.asString();
        System.out.println(resString);

        //Validatable assertion
        vr2.statusCode(401);


    }
}
