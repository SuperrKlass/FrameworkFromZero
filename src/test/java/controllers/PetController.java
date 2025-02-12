package controllers;

import io.restassured.specification.RequestSpecification;

import static constants.CommonConstants.BASE_URL;
import io.restassured.response.Response;
import models.pet.Pet;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;


public class PetController {
    RequestSpecification requestSpecification;
    private static final String PET_ENDPOINT = "pet";

    public PetController() {
        this.requestSpecification = given()
                .accept(JSON)
                .contentType(JSON)
                .baseUri(BASE_URL);
    }

    public Response createPet() {
        return given(this.requestSpecification)
                    .body("")
                .when()
                    .post(PET_ENDPOINT)
                    .andReturn();
    }

    public Response updatePet(Pet pet) {
        return given(this.requestSpecification)
                    .body(pet)
                .when()
                    .put(PET_ENDPOINT + "/" + pet.getName())
                    .andReturn();
    }
}
