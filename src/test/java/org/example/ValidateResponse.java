package org.example;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import org.example.resource.BaseURL;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ValidateResponse extends BaseURL {


    @Test
    public void verifyResponse(){

        RestAssured.baseURI= baseURI;

        given().param("q", "London").
                param("appid", "edc635696646aa008d76304013c0df3f").


                when().
                get("/data/2.5/weather").
                then().assertThat().statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("weather[0].description.", equalTo("overcast clouds") ) .and().
                body("base.", equalTo("stations") ) .and().
                body("sys.country", equalTo("GB")).and().
                body("name", equalTo("London")).and().
                header("server", "openresty");
        System.out.println("Request is executed successfully");

    }
}
