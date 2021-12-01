package api.services;

import api.assertions.AssertableResponce;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;

import static io.restassured.RestAssured.basePath;

@Slf4j
public class PeopleApiServices {

    private Logger logger = Logger.getLogger(getClass());

    RequestSpecification requestSpec;
    private static PeopleApiServices apiUtilsIstance = null;
    public final String defaultContentType = "application/json";

    public PeopleApiServices(String basePath){
        this.requestSpec = RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(defaultContentType)
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .basePath(basePath);
    }

    public static PeopleApiServices getInstance(){
        if (apiUtilsIstance ==null)
            apiUtilsIstance = new PeopleApiServices(basePath);
        return apiUtilsIstance;
    }

    public RequestSpecification getRequestSpec(){
        return requestSpec;
    }

    public void resetRestAssured(){
        apiUtilsIstance = null;
    }

    @Step("Get people")
    public AssertableResponce getPeople(){
        log.info("Get people - /people/1");
        return new AssertableResponce(
                requestSpec.when()
                        .get("/people/1")
                        .then());
    }
}