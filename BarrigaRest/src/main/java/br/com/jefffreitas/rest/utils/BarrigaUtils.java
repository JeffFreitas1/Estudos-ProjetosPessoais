package br.com.jefffreitas.rest.utils;

import io.restassured.RestAssured;

public class BarrigaUtils {
	
	public static Integer getIdContaPeloNome (String name) {
		return RestAssured.get("/contas?name="+name).then().extract().path("id[0]");
	}

}
