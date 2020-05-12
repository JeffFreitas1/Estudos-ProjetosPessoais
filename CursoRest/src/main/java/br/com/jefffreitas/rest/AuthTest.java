package br.com.jefffreitas.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;

public class AuthTest {
	
	@Test
	public void deveAcessarPokemonApi() {
		given()
		    .log().all()
		.when()
		    .get("https://pokeapi.co/api/v2/pokemon/132/")
		.then()
		    .statusCode(200)
		    .log().all()
		    .body("name", is("ditto"))
		;
	}
	
	@Test
	public void deveObterClima() {
		given()
	        .log().all()
	        .queryParam("q", "Fortaleza,BR")
	        .queryParam("appid", "1f31e4a03573b365025ac6ace77efc95")
	        .queryParam("units", "metric")
	    .when()
	        .get("http://api.openweathermap.org/data/2.5/weather")
	    .then()
	       .statusCode(200)
	       .log().all()
	       .body("name", is("Fortaleza"))
	       .body("coord.lon", is(-38.52f))
	       .body("main.temp", greaterThan(25f))
	;
	}
	
	@Test
	public void naoDeveAcessarSemSenha() {
		given()
		    .log().all()
		.when()
		    .get("http://restapi.wcaquino.me/basicauth")
		.then()
		    .statusCode(401)
		
		;
	}

	@Test
	public void DeveAcessarComSenha() {
		given()
		    .log().all()
		.when()
		    .get("http://admin:senha@restapi.wcaquino.me/basicauth")
		.then()
		    .statusCode(200)
		
		;
	}
	
	@Test
	public void DeveAcessarComSenha2() {
		given()
		    .log().all()
		    .auth().basic("admin", "senha")
		.when()
		    .get("http://restapi.wcaquino.me/basicauth")
		.then()
		    .statusCode(200)
		
		;
	}
	

	@Test
	public void DeveAcessarComSenha3() {
		given()
		    .log().all()
		    .auth().preemptive().basic("admin", "senha")
		.when()
		    .get("http://restapi.wcaquino.me/basicauth2")
		.then()
		    .statusCode(200)
		
		;
	}
	
	@Test
	public void deveFazerAutenticacaoComToken() {
		given()
	    .log().all()
	.when()
	    .get("http://barrigarest.wcaquino.me/contas")
	.then()
	    .statusCode(200)
	
	;
}
	}
