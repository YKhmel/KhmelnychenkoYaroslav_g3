package ApiTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SwapDevTests {

    private Logger logger = Logger.getLogger(getClass());
    private String endPointPeople = "https://swapi.dev/api/people/1/";
    private String endPointPlanets = "https://swapi.dev/api/planets/1/";

    @Test
    void getNameIfCharacter(){
        Response r = given()
                .contentType(ContentType.JSON)
                .when()
                .get(endPointPeople)
                .then()
                .assertThat().statusCode(200)
                .extract().response();
        String name = r.jsonPath().get("name").toString();
        String homeWorld = r.jsonPath().get("homeworld").toString();
        logger.info("\n" + name + "\n" + homeWorld);
    }

    @Test
    void getNamePlanetAndPopulation(){
        Response r = given()
                .contentType(ContentType.JSON)
                .when()
                .get(endPointPlanets)
                .then()
                .assertThat().statusCode(200)
                .extract().response();
        String namePlanet = r.jsonPath().get("name");
        String populationPlanet = r.jsonPath().get("population").toString();
        String nameFilm = r.jsonPath().get("films[0]").toString();
        String residentsName = r.jsonPath().get("residents[0]").toString();
        logger.info("\n" + namePlanet + "\n" + populationPlanet + "\n" + nameFilm + "\n" + residentsName);
        Assert.assertEquals(residentsName, endPointPeople);
    }
}