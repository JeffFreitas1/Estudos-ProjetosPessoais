package br.com.jefffreitas.rest;

import static io.restassured.RestAssured.*;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import jdk.internal.org.xml.sax.SAXParseException;

public class SchemaTest {
	
	@Test
	public void deveValidarSchema () {
		given()
		    .log().all()
		.when()
		    .get("http://restapi.wcaquino.me/usersXML")
		.then()
		    .log().all()
		    .statusCode(200)
		    .body(RestAssuredMatchers.matchesXsdInClasspath("users.xsd"))
		;
		
	}
	
	@Test(expected = SAXParseException.class )
	public void naoDeveValidarSchemaXmlInvalido () {
		given()
		    .log().all()
		.when()
		    .get("http://restapi.wcaquino.me/invalidusersXML")
		.then()
		    .log().all()
		    .statusCode(200)
		    .body(RestAssuredMatchers.matchesXsdInClasspath("users.xsd"))
		;
		
	}
	
	@Test
	public void deveValidarSchemaJson () {
		given()
		    .log().all()
		.when()
		    .get("http://restapi.wcaquino.me/users")
		.then()
		    .log().all()
		    .statusCode(200)
		    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("users.json"))
		;
		
	}


}
