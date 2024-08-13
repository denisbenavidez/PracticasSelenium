package API;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.Argument;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.List;


import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestAPI {

    @Test
    public void getTest(){ //obteniendo
        Response response2 = given().get("https://api.restful-api.dev/objects/7");
        JsonPath data = response2.jsonPath();

        System.out.println("CPU model: " + data.get("data['CPU model']"));
        System.out.println("Lanzamiento  " + data.get("data.year"));
    }

    @Test
    public void postTest(){ //agregando
        JSONObject data = new JSONObject();
        data.put("name", "Nokia");
        data.put("price", 99.99);
        data.put("inStock", true);

        given().contentType("application/json").body(data.toString())
                .when().post("https://api.restful-api.dev/objects")
                .then()
                .statusCode(200)
                .body("name", equalTo("Nokia"));
    }

    @Test
    public void putTest() { //actualizando
        JSONObject data = new JSONObject();
        data.put("id", "7");
        data.put("name", "Apple MacBook Pro 16");
        data.put("year", 2019);
        data.put("price", 2049.99);
        data.put("CPU model", "Intel Core i9");
        data.put("Hard disk size", "1 TB");
        data.put("color", "silver");

        given().contentType("application/json").body(data.toString())
                .when().put("https://api.restful-api.dev/objects/7")
                .then()
                .statusCode(200)
                .body("name", equalTo("Apple MacBook Pro 16"));
    }

    @Test
    public void deleteTest() {
        given().delete("https://api.restful-api.dev/objects/6")
                .then()
                .statusCode(200)
                .body("message", equalTo("Object with id = 6, has been deleted."));
    }
}
