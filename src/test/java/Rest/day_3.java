package Rest;


import jdk.internal.net.http.common.Log;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class day_3 {
	//https://reqres.in/api/users?page=2


	
	@Test
	 void check() {
		// TODO Auto-generated method stub
		 
		 given()
		 .pathParam("mypath", "users")
		 .queryParam("page", 2)
		 
		 
		  .when()
		  .get("https://reqres.in/api/{mypath}")
		 
		 
		 
		 .then()
		 .statusCode(200)
		 .log().all();

	}

}
