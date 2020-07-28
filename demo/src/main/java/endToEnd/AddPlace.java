package endToEnd;

import File.Payload;
import groovy.json.JsonBuilder;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddPlace {
    public static void main(String[] args) {
        Payload a = new Payload();
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all().queryParam("key", "qaclick123")
                .body(a.addPlace()).when()
                .post("maps/api/place/add/json")
                .then()
                .statusCode(200).body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.18 (Ubuntu)").extract().asString();
        System.out.println(response);
        //output is in json format so we need to parse it.
        JsonPath json = new JsonPath(response);
        String placeId = json.getString("place_id");
        System.out.println(placeId);
    } 
}
