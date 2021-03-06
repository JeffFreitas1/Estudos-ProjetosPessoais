package br.com.jefffreitas.rest.tests.refac;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import br.com.jefffreitas.rest.core.BaseTest;
import io.restassured.RestAssured;

public class SaldoTest extends BaseTest{	

	@Test
	public void deveIncluirContaComSucesso() {
		//incluindo a conta
		     given()
		     .body("{ \"nome\": \"Conta inserida\"}")
			.when()
			.post("/contas")
			.then()
			.statusCode(201)
		;
	}
	
	@Test
	public void deveAlterarContaComSucesso() {
		Integer CONTA_ID = getIdContaPeloNome("Conta para alterar");
		
		
		     given()
		     .body("{ \"nome\": \"Conta alterada\"}")
		     .pathParam("id", CONTA_ID)
			.when()
			.put("/contas/{id}")
			.then()
			.statusCode(200)
			.body("nome", is("Conta alterada"))
		; 
	}
	
	@Test
	public void naoDeveInserirContaComMesmoNome() {
		//incluindo a conta
		     given()
		     .body("{ \"nome\": \"Conta mesmo nome\"}")
			.when()
			.post("/contas")
			.then()
			.statusCode(400)
			.body("error", is("J� existe uma conta com esse nome!"))
		;
	}
	
	
	public Integer getIdContaPeloNome (String name) {
		return RestAssured.get("/contas?name="+name).then().extract().path("id[0]");
	}
}
