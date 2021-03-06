package br.com.jefffreitas.rest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;

public class FileTest {
	
	@Test
	public void deveObrigarEnvioArquivo() {
		
		given()
		    .log().all()
		.when()
		    .post("http://restapi.wcaquino.me/upload")
		.then()
		    .log().all()
		    .statusCode(404) //deveria ser 400
		    .body("error", is("Arquivo n�o enviado"));
		;
		
	}
	
	@Test
	public void deveFazerUploadArquivo() {
		given()
		    .log().all()
		    .multiPart("arquivo", new File("src/main/resources/users.pdf"))
		.when()
		    .post("http://restapi.wcaquino.me/upload")
		.then()
		    .log().all()
		    .statusCode(200)
		    .body("name", is("users.pdf"))
		;
		
	}
	
	@Test
	public void naoDeveFazerUploadArquivo() {
		given()
		    .log().all()
		    .multiPart("arquivo", new File("src/main/resources/descent_journeys_in_regras_por_hbsl_1196.pdf"))
		.when()
		    .post("http://restapi.wcaquino.me/upload")
		.then()
		    .log().all()
		    .time(lessThan(5000L))
		    .statusCode(413)
		;
		
	}
	
	@Test
	public void deveBaixarArquivo() throws IOException {
		byte[] image = given()
		    .log().all()
		.when()
		    .get("http://restapi.wcaquino.me/download")
		.then()
		 //   .log().all()
		    .statusCode(200)
		    .extract().asByteArray()
		;
		File imagem = new File("src/main/resources/file.jpg");
		OutputStream out = new FileOutputStream(imagem);
		out.write(image);
		out.close();
		
		System.out.println(imagem.length());

}
}
