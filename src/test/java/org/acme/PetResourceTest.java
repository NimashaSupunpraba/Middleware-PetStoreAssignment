package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.allOf;

@QuarkusTest
public class PetResourceTest {

    @Test
    public void testPetEndpoint() {
        given()
                .when().get("/v1/pets/getpets")
                .then()
                .statusCode(200);
//             .body(hasItem(
// 		            allOf(
//    		                hasEntry("pet_id", "1"),
//    		                hasEntry("pet_type", "Dog"),
//    		                hasEntry("pet_name", "Boola"),
//    		                hasEntry("pet_age", "3")
//    		            )
//    		      )
//    		 );
    }

//    @Test
//    public void testPetAddEndpoint(){
//        given()
//                .header("Content-Type","application/json")
//                .body("{\r\n    \"petName\":\"rocky\",\r\n  \"petAge\":7,\r\n   \"petType\":\"Dog\"\r\n}")
//                .when().post("/v1/pets/createpet")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .body("petId",notNullValue())
//                .body("petAge",equalTo(7))
//                .body("petName",equalTo("rocky"))
//                .body("petType",equalTo("Dog"));
//    }
//
    @Test
    void testDeletePet()
    {
        given()
                .header( "Content-Type", "application/json" )
                .pathParam( "id", 2)
                .when().delete( "/v1/pets/deletepet/{id}" )
                .then()
                .assertThat()
                .statusCode( 200 );

    }

//    @Test
//    public void testPetAddEndpoint(){
//        given()
//                .header("Content-Type","application/json")
//                .body("{\r\n    \"petName\":\"rocky\",\r\n  \"petAge\":8,\r\n   \"petType\":\"Dog\"\r\n}")
//                .when().post("/v1/pets/createpet")
//                .then()
//                .statusCode(200)
//                .body("petId",notNullValue())
//                .body("petAge",equalTo(8))
//                .body("petName",equalTo("Columbidae"))
//                .body("petType",equalTo("Bird"));
//    }


}