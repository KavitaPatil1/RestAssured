package Rest;

import jdk.internal.net.http.common.Log;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;



public class day {

@Test
void getUserlist() 
{
			given()
			
			.when()
			.get("https://reqres.in/api/users?page=2")
					
			
			.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();
			
			

		}
@Test
void createuser()
{
	HashMap data=new HashMap();
	data.put("name", "pavan");
	data.put("job", "trainer");
	
	
	
	given()
	.contentType("application/json")
	.body(data)
	
	.when()
	.post("https://reqres.in/api/users")
	
	.then()
	.statusCode(201)
	.log().all();
	
}



}
