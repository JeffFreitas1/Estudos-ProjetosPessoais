package br.com.jefffreitas.rest.tests.refac.suite;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import br.com.jefffreitas.rest.core.BaseTest;
import br.com.jefffreitas.rest.tests.refac.AuthTest;
import br.com.jefffreitas.rest.tests.refac.ContasTest;
import br.com.jefffreitas.rest.tests.refac.SaldoTest;
import io.restassured.RestAssured;

@RunWith(org.junit.runners.Suite.class)
@SuiteClasses({
	ContasTest.class,
	SaldoTest.class,
	AuthTest.class
})

public class Suite extends BaseTest {
	@BeforeClass
	public static void login () {
		Map<String, String> login = new HashMap<>();
		login.put("email", "jeferson_dent@hotmail.com");
		login.put("senha", "jeff1337");
		
		//fazendo o login
	String TOKEN = given()
		    .body(login)
		.when()
		    .post("/signin")
		.then()
		    .statusCode(200)
		    .extract().path("token");
		RestAssured.requestSpecification.header("Authorization", "JWT " + TOKEN);
		
		RestAssured.get("/reset").then().statusCode(200);
	}

}
