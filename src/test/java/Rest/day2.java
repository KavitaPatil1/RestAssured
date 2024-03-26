package Rest;

import jdk.internal.net.http.common.Log;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;
  

public class day2 {
	@Test
	void createjsonLibrary()
	{
	JSONObject data=new JSONObject();
	
	data.put("username", "admin");
	data.put("password", "password123");
	
	
		given()
		.contentType("application/json")
		.body(data.toString())
		
		
		.when()
		.post("https://restful-booker.herokuapp.com/auth ")
				
		.then()
		.statusCode(200)
		.body("token", notNullValue())
		.body("token",equalTo("admin123"))
		.log().all();
		
	}
	void pojojson() {
		
		
		
//		given()
//		
//		.when()
//		
//		
//		//.then()
		
		
		
	}
	

}
