package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resourceData.APIResource;
import resourceData.TestDataBuild;
import resourceData.Utils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import java.io.IOException;


public class StepDefination extends Utils {
	ResponseSpecification resspec;
	RequestSpecification res;
	Response response; 
	TestDataBuild data= new TestDataBuild();
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		// resspec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		
		res=given().spec(requestSpecification()).body(data.addplacedata(name,language,address)); 
		
	}
	
	
	@When("user calls {string} with {string} HTTP request")
	public void user_calls_with_post_http_request(String string1,String string2) {
	    // Write code here that turns the phrase above into concrete actions
		APIResource resourceAPI=  APIResource.valueOf(string1);
		
		response=res.when().post(resourceAPI.getresource()).then().extract().response();
	
	
	}
	@Then("API call got success with status code {int}")
	public void api_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(),200);
	
	
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string1, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    String respo=response.asString();
	    JsonPath js= new JsonPath(respo);
	    assertEquals(js.get(string1).toString(),string2);
	}
	

	
}
