package RestAPI;
import files.ReusableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class FirstPrograme {

    public static void main(String[] args) {
        // validate if Add Place API is working as expected

        // given - all input details
        // when - Submit  the API -resource, http method
        // Then - v
        // alidate the response

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        // Output generated
        String responce = given().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(payload.AddPlace())
                .when()
                .post("maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .extract().response().asString();

        System.out.println(responce);



        JsonPath js = ReusableMethods.rawToJson(responce);  //for parsing json
        String placeID = js.getString("place_id");
        System.out.println(placeID);

        String newAddress = "70 Summer walk, USA";
        given().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\"place_id\":\"" + placeID + "\",\n" +
                        "\"address\":\"" + newAddress + "\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n")
                .when().put("maps/api/place/update/json")
                .then().assertThat().statusCode(200)
                .body("msg", equalTo("Address successfully updated"));

        String getPlaceRespone = given()
                .queryParam("key", "qaclick123")
                .queryParam("place_id", "" + placeID + "")
                .when().get("maps/api/place/get/json")
                .then().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath js1 = ReusableMethods.rawToJson(getPlaceRespone);
        String actualAddress = js1.getString("address");
        System.out.println(actualAddress);
        Assert.assertEquals(newAddress, actualAddress);

    }
}

