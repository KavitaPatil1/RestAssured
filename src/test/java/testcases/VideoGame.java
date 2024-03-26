package testcases;

import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;
import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class VideoGame {
	@Test(priority=1)
	public void getAllVideoGames() {
		// TODO Auto-generated method stub
		given()
		.when()
		.get("http://localhost:8080/app/videogames")
		
		.then()
		.statusCode(200);
		

	}
	@Test(priority=2)
	public void addNewVideoGame() {
		// TODO Auto-generated method stub
		HashMap data=new HashMap();
		data.put("id", "100");
		data.put("name", "jon");
		data.put("releaseDate", "2024-03-25T06:05:44.435Z");
		data.put("reviewScore", "5");
		data.put("category", "Adventure");
		data.put("rating", "Universal");
		
		Response res=
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:8080/app/videogames")
		
		.then()
		.statusCode(200)
		.log().body()
		.extract().response();
		String jsonstring=res.toString();
		Assert.assertEquals(jsonstring.contains("Record Added Successfully"), true);
		

	}
	@Test(priority=3)
	public void getvideogame() {
		// TODO Auto-generated method stub
		given()
		.when()
		.get("http://localhost:8080/app/videogames/100")
		.then()
		.statusCode(200)
		.log().body()
		.body("videoGame.id",equalTo("100"))
		.body("videoGame.name",equalTo("jon"));
		

	}
	@Test(priority=4)
	public void putrequest() {
		// TODO Auto-generated method stub
		HashMap data=new HashMap();
		data.put("id", "100");
		data.put("name", "javed");
		data.put("releaseDate", "2024-03-25T06:05:44.435Z");
		data.put("reviewScore", "39");
		data.put("category", "Adventure");
		data.put("rating", "Universal");
		
		given()
		.contentType("application/json")
       
		.body(data)
		
		.when()
		.put("http://localhost:8080/app/videogames/100")
				
		
		.then()
		.statusCode(200)
		.log().body()
		.body("videoGame.id",equalTo("100"))
		.body("videoGame.name",equalTo("javed"))
		.body("videoGame.reviewScore",equalTo("39"));
		
	}

}
