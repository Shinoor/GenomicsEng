package org.example.resource.utills;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.resource.BaseURL;
import org.example.resource.utills.PayloadGenerator;
public class RestCalls {

    private static Logger log = LogManager.getLogger(PayloadGenerator.class.getName());


    public Response verifyResponse(String uRI, String strJSON){




        log.info("Inside POSTRequest call");
        RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.post(uRI);
        log.debug(requestSpecification.log().all());
        return response;

    }
}
