package stepDefinitions;

import static io.restassured.RestAssured.given;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import pojo.*;
import resources.TestDataBuild;
import resources.Utilities;

public class AddPlaceAPI extends Utilities{
	AddPlace p;
	RequestSpecification reqSpec;
	ResponseSpecification responseSpec;
	RequestSpecification request;
	Response response;
	TestDataBuild data = new TestDataBuild();
	
	
//	@Given("User send \"AddPlace\" Payload")
//	public void user_send_add_place_payload() throws IOException {
//	    // Write code here that turns the phrase above into concrete action
//		
//		request = given().spec(requestSpecification()).body(data.addPlacePayLoad());
//	}
	
	@Given("User send {string} Payload with {string} and {string} and {string}")
	public void user_send_payload_with_and_and(String payload, String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		request = given().spec(requestSpecification()).body(data.addPlacePayLoad(name,language,address));
	}
	
	@When("User calls {string} API with Post http request")
	public void user_calls_api_with_post_http_request(String string) {
	    // Write code here that turns the phrase above into concrete actions
		response = request
				.when().post("maps/api/place/add/json")
				.then().log().all().spec(responseSpecification()).extract().response();
	}
	
	@Then("The {string} in response is {int}")
	public void the_in_response_is(String string, int int1) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(response.getStatusCode(), int1);
	}
	
	@Then("The {string} in reponse is {string}")
	public void the_in_reponse_is(String key, String value) {
	    // Write code here that turns the phrase above into concrete actions
		String res = response.asString();
		JsonPath js = new JsonPath(res);
		Assert.assertEquals(js.get(key),value);
	}
	
}