package practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payloades.Payloades;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;
public class Ramm {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
	Response response=given().log().all().queryParam("key", "qaclick123").header("Conten-Type","application/json")
	.body(Payloades.AddPlace()).when().post("/maps/api/place/add/json")
	.then().log().all().assertThat().statusCode(200).extract().response();
	String responseString = response.asString();
	System.out.println(response);
	JsonPath js= new JsonPath(responseString);
	
	
	//int id = js.getInt("place_id");
	String id = js.getString("place_id");

	
	System.out.println("✅ Place ID: " + id);
		
		
		
		
	}

}
