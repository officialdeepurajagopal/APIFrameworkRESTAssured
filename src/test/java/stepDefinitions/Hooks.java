package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenarios() throws IOException {
		
		AddPlaceAPI a = new AddPlaceAPI();
		a.user_send_payload_with_and_and("addPlacePayLoad", "Aadi", "Test", "Test");
		a.user_calls_api_with_http_request("AddPlaceAPI", "POST");
        a.the_in_response_is(null, 200);
		a.user_confirms_the_id_present_in_the_response("place_id");
	}

}
