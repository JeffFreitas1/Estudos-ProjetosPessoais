package br.com.jefffreitas.testeapi.tests;

import static io.restassured.RestAssured.given;

import org.junit.Test;


public class ItauTestsApi{
	
	@Test
		public void t_01deveIncluirUsuarioAna() {				
		     given()
		     .log().all()
		     .body("{\"id\": 0,\"username\": \"AnaMaia\",\"firstName\": \"Ana\",\"lastName\": \"Maia\",\"email\": \"anamaia@teste.com\",\"password\": \"12345\",\"phone\": \"37832836\",\"userStatus\": 0}")
			.when()
			.post("http://petstore.swagger.io/v2/user")
			.then()
			.log().all()
			.statusCode(200)
		;
	}
	
	@Test
	public void t_02deveIncluirUsuarioRodrigo() {				
	     given()
	     .log().all()
	     .body("{\"id\": 1,\"username\": \"RodriMende\",\"firstName\": \"Rodrigo\",\"lastName\": \"Mendes\",\"email\": \"rodrimende@teste.com\",\"password\": \"123456\",\"phone\": \"37832837\",\"userStatus\": 1}")
		.when()
		.post("http://petstore.swagger.io/v2/user")
		.then()
		.statusCode(200)
	;
}
	@Test
	public void t_03deveIncluirUsuarioTatiana() {				
	     given()
	     .log().all()
	     .body("{\"id\": 2,\"username\": \"TatiVasc\",\"firstName\": \"Tatiana\",\"lastName\": \"Vasconcelos\",\"email\": \"tativasc@teste.com\",\"password\": \"1234567\",\"phone\": \"37832838\",\"userStatus\": 2}")
		.when()
		.post("http://petstore.swagger.io/v2/user")
		.then()
		.statusCode(200)
	;
}
	@Test
	public void t_04deveIncluirPetSnoopy() {				
	     given()
	     .log().all()
	     .body("{\"id\": 1,\"category\": {\"id\": 1,\"name\": \"Cachorros\"},\"name\": \"Snoopy\",\"photoUrls\": [\"https://i.imgur.com/tmvJEmi.jpg\"],\"tags\": [{\"id\": 1,\"name\": \"Snoopy\"}],\"status\": \"available\"}")
		.when()
		.post("http://petstore.swagger.io/v2/pet")
		.then()
		.statusCode(200)
	;
}
	@Test
	public void t_05deveIncluirPetBichento() {				
	     given()
	     .log().all()
	     .body("{\"id\": 2,\"category\": {\"id\": 2,\"name\": \"Gatos\"},\"name\": \"Bichento\",\"photoUrls\": [\"https://i.imgur.com/6PbTSXL.jpg\"],\"tags\": [{\"id\": 2,\"name\": \"Bichento\"}],\"status\": \"available\"}")
		.when()
		.post("http://petstore.swagger.io/v2/pet")
		.then()
		.statusCode(200)
	;
}
	
	@Test
	public void t_06deveIncluirPetPerry() {				
	     given()
	     .log().all()
	     .body("{\"id\": 3,\"category\": {\"id\": 3,\"name\": \"Ornitorrinco\"},\"name\": \"Perry\",\"photoUrls\": [\"https://i.imgur.com/zk4Ivge.jpg\"],\"tags\": [{\"id\": 3,\"name\": \"Perry\"}],\"status\": \"available\"}")
		.when()
		.post("http://petstore.swagger.io/v2/pet")
		.then()
		.statusCode(200)
	;
}
	@Test
	public void t_07venderPerryParaAnaMaria() {				
	     given()
	     .log().all()
	     .body("{\"id\": 3,\"petId\": 3,\"quantity\": 1,\"shipDate\": \"2020-07-18T14:32:21.283Z\",\"status\": \"placed\",\"complete\": true}")
		.when()
		.post("http://petstore.swagger.io/v2/store/order")
		.then()
		.statusCode(200)
	;
}
	
	@Test
	public void t_08venderSnoopyParaRodrigoMendes() {				
	     given()
	     .log().all()
	     .body("{\"id\": 2,\"petId\": 1,\"quantity\": 1,\"shipDate\": \"2020-07-18T14:32:21.283Z\",\"status\": \"placed\",\"complete\": true}")
		.when()
		.post("http://petstore.swagger.io/v2/store/order")
		.then()
		.statusCode(200)
	;
	}
	
	@Test
	public void t_09venderBichentoParaTatiana() {				
	     given()
	     .log().all()
	     .body("{\"id\": 2,\"petId\": 2,\"quantity\": 1,\"shipDate\": \"2020-07-18T14:32:21.283Z\",\"status\": \"placed\",\"complete\": true}")
		.when()
		.post("http://petstore.swagger.io/v2/store/order")
		.then()
		.statusCode(200)
	;
	}
	
	@Test
	public void t_10alterarStatusSnoopy() {				
	 	     given()
	 	     .log().all()
	 	     .body("{\"id\": 1,\"category\": {\"id\": 1,\"name\": \"Cachorros\"},\"name\": \"Snoopy\",\"photoUrls\": [\"string\"],\"tags\": [{\"id\": 1,\"name\": \"Snoopy\"}],\"status\": \"approved\"}")
	 		.when()
	 		.put("http://petstore.swagger.io/v2/pet")
	 		.then()
	 		.statusCode(200)
	 	;
	    }
	
	@Test
	public void t_11alterarStatusPerry() {				
	 	     given()
	 	     .log().all()
	 	     .body("{\"id\": 3,\"category\": {\"id\": 3,\"name\": \"Ornitorrinco\"},\"name\": \"Perry\",\"photoUrls\": [\"string\"],\"tags\": [{\"id\": 3,\"name\": \"Perry\"}],\"status\": \"approved\"}")
	 		.when()
	 		.put("http://petstore.swagger.io/v2/pet")
	 		.then()
	 		.statusCode(200)
	 	;
	    }
	
	@Test
	public void t_12alterarStatusBichento() {				
	 	     given()
	 	     .log().all()
	 	     .body("{\"id\": 2,\"category\": {\"id\": 2,\"name\": \"Gatos\"},\"name\": \"Bichento\",\"photoUrls\": [\"string\"],\"tags\": [{\"id\": 2,\"name\": \"Bichento\"}],\"status\": \"delivered\"}")
	 		.when()
	 		.put("http://petstore.swagger.io/v2/pet")
	 		.then()
	 		.statusCode(200)
	 	;
	    }
	
	@Test
	public void t_13consultarOrdemPerry() {				
	 	     given()
	 		.when()
	 		.get("http://petstore.swagger.io/v2/store/order/3")
	 		.then()
	 		 .log().all()
	 		.statusCode(200)
	 	;
	    }
	@Test
	public void t_14consultarOrdemSnoopy() {				
	 	     given()
	 		.when()
	 		.get("http://petstore.swagger.io/v2/store/order/2")
	 		.then()
	 		.statusCode(200)
	 		.log().all()
	 	;
	    }
	     

		
}


