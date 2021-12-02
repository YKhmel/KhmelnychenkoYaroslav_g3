package ApiTests;

import api.assertions.AssertableResponce;
import api.extentions.TestLoggingListener;
import api.services.Utils;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static api.conditions.Conditions.body;
import static api.conditions.Conditions.statusCode;
import static org.hamcrest.Matchers.is;

@Listeners(TestLoggingListener.class)
public class HumanTests extends BaseTest{

    @Test
    void testGetUserName(){
        peopleApiServices
                .getPeople()
                .shouldHave(statusCode(200))
                .shouldHave(body("name", is("Luke Skywalker")));
        Utils.resetSession();
    }

    @Test
    void testGetUser(){
        AssertableResponce r = peopleApiServices.getPeople();
        Assert.assertEquals(200, r.response.extract().statusCode());
        Assert.assertEquals("application/json", r.response.extract().contentType());
    }
}