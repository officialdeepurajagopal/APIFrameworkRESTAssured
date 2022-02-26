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
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utilities;

public class AddPlaceAPI extends Utilities{
	AddPlace p;
	DeletePlace d;
	RequestSpecification reqSpec;
	ResponseSpecification responseSpec;
	RequestSpecification request;
	Response response;
	String res;
	static String place_id;
	TestDataBuild data = new TestDataBuild();
	APIResources resource;
	
	
	@Given("User send {string} Payload with {string} and {string} and {string}")
	public void user_send_payload_with_and_and(String payload, String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		request = given().spec(requestSpecification()).body(data.addPlacePayLoad(name,language,address));
	}
	
	
	@When("User calls {string} API with {string} http request")
	public void user_calls_api_with_http_request(String resourceAPI, String method) {
	    // Write code here that turns the phrase above into concrete actions
		resource = APIResources.valueOf(resourceAPI);
		
		if(method.equals("POST")) {
			response = request
					.when().post(resource.getResourse());
		}
		else if (method.equals("GET")) {
			response = request
					.when().get(resource.getResourse());
		}

	}
	
	@Then("The {string} in response is {int}")
	public void the_in_response_is(String string, int int1) {
	    // Write code here that turns the phrase above into concrete actions
		res = response.asString();
		Assert.assertEquals(response.getStatusCode(), int1);
	}
	
	@Then("The {string} in reponse is {string}")
	public void the_in_reponse_is(String key, String value) {
	    // Write code here that turns the phrase above into concrete actions
		JsonPath js = new JsonPath(res);
		Assert.assertEquals(js.get(key),value);
	}
	
	@Then("User confirms the {string} id present in the response")
	public void user_confirms_the_id_present_in_the_response(String key) {
	    // Write code here that turns the phrase above into concrete actions
		place_id = responseStringFromJson(res, key);
		Assert.assertNotNull(responseStringFromJson(res, key));
		
	}
	
	@Then("verify {string} created for {string} using {string}")
	public void verify_created_for_using(String key, String inputValue, String resourceAPI) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		request = given().spec(requestSpecification()).queryParam("place_id", place_id);
		resource = APIResources.valueOf(resourceAPI);
		
		user_calls_api_with_http_request(resourceAPI, "GET");
		
		String res = response.asString();
		String currentName = responseStringFromJson(res, "name");
		
		Assert.assertEquals(currentName, inputValue);
	    
	}
	
	@Given("Given User send {string} Payload")
	public void given_user_send_payload(String string) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		System.out.println(place_id);
		
	    request = given().spec(requestSpecification()).body(data.deletePlacePayLoad(place_id));
	}
	
}