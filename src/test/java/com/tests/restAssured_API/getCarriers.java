/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tests.restAssured_API;

import com.driver.BrowserFactrory;
import com.properties.ConfigLoadeer;
import com.properties.TestDataLoader;
import com.properties_api.properties.TestDataLoader_api;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class getCarriers {



    public RequestSpecification httpRequest;

    public Response response;

    public ResponseBody responseBody;

    public JsonPath jsonPath;
    String  accessToken;



    @BeforeClass
      public void setup(){
          RestAssured.useRelaxedHTTPSValidation();

          RestAssured.baseURI= TestDataLoader_api.getInstance().getAPI_URI();

          httpRequest = RestAssured.given().header("Content-Type","application/json");


        String payload = String.format(
                "{\n" +
                        "  \"userName\": \"%s\",\n" +
                        "  \"password\": \"%s\"\n" +
                        "}",
                TestDataLoader_api.getInstance().getAPI_username(),
                TestDataLoader_api.getInstance().getAPI_password()
        );
          response = httpRequest.body(payload).post("/Account/Authenticate");
          responseBody = response.getBody();
          String responseValue = responseBody.asString();
          jsonPath = responseBody.jsonPath();
          String ac1 = jsonPath.get("accessToken");

          accessToken = "Bearer "+ac1;


     }

     @Test
    public void getCarriers(){

         RestAssured.baseURI="https://uatmetashipapi.metaoptionllc.com/MetashipAPI/api/v1";
         httpRequest = RestAssured.given().header("Content-Type","application/json").header("Authorization",accessToken);
         response = httpRequest.get("/Shipping/GetCarriers");
         responseBody = response.getBody();
         String reponseValue = responseBody.asString();

         int statusCode = response.getStatusCode();
         System.out.println(statusCode);
         System.out.println(reponseValue);
     }


}
