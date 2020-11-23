package org.example;

import io.restassured.RestAssured;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.resource.BaseURL;
import org.example.resource.utills.PayloadGenerator;
import org.testng.annotations.Test;

import java.net.URI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRequest extends BaseURL {
    private static Logger log = LogManager.getLogger(PayloadGenerator.class.getName());





    @Test
    public void verifyResponse(){
        log.info("Inside PayloadConverter function");

        RestAssured.baseURI= baseURI;

        given().param("key", "edc635696646aa008d76304013c0df3f").body(
                PayloadGenerator.generatePayLoadString("payload")).


        when().
                post("/data/2.5/weather").

                then().assertThat().statusCode(200).and().body("status", equalTo("OK"));


}
}
