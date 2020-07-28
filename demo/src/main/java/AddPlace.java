import File.Payload;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddPlace {
    public static void main(String[] args) {
        Payload a = new Payload();
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all().queryParam("key", "qaclick123")
                .body(a.addPlace()).when()
                .post("maps/api/place/add/json").then().log().all()
                .statusCode(200).body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.18 (Ubuntu)");
    }
}
