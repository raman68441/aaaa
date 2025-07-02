package stepDefinations;

import io.cucumber.java.en.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;

public class StepDefinitions extends Utils {

    RequestSpecification reqSpec;
    Response response;
    static String place_id;
    TestDataBuild data = new TestDataBuild();

    @Given("Add Place Payload")
    public void add_place_payload() throws IOException {
        reqSpec = given().spec(requestSpecification()).body(data.addPlacePayload());
    }

    @Given("Update Place Payload with {string}")
    public void update_place_payload_with(String newAddress) throws IOException {
        reqSpec = given().spec(requestSpecification()).body(data.updatePlacePayload(place_id, newAddress));
    }

    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {
        APIResources apiResource = APIResources.valueOf(resource);

        switch (method.toUpperCase()) {
            case "POST":
                response = reqSpec.when().post(apiResource.getResource());
                break;
            case "GET":
                response = reqSpec.when().get(apiResource.getResource());
                break;
            case "PUT":
                response = reqSpec.when().put(apiResource.getResource());
                break;
            case "DELETE":
                response = reqSpec.when().delete(apiResource.getResource());
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method: " + method);
        }
    }

    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("{string} in response body is {string}")
    public void something_in_response_body_is_something(String key, String value) {
        assert getJsonPath(response, key).equals(value);
    }

    @Then("verify place_id created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
        place_id = getJsonPath(response, "place_id");
        reqSpec = given().spec(requestSpecification()).queryParam("place_id", place_id);
        user_calls_with_http_request(resource, "GET");
        String actualName = getJsonPath(response, "name");
        assert actualName.equals(expectedName);
    }
}
