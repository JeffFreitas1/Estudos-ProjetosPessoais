package br.com.jefffreitas.testeweb.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.junit.Assert;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TesteItauWeb {

	@Test
	public void consultaCarros() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.icarros.com.br/principal/index.jsp");
		driver.findElement(By.xpath("//button[contains(@data-id,'sltMake')]")).click();
		driver.findElement(By.xpath("//a[@tabindex='0'][contains(.,'Honda')]")).click();
		driver.findElement(By.xpath("//button[@data-id='sltModel']")).click();
		driver.findElement(By.xpath("//button[@data-id='sltModel']")).sendKeys("Civic");
		driver.findElement(By.xpath("(//span[@class='text'][contains(.,'Civic')])[1]")).click();
		driver.findElement(By.xpath("//button[@data-id='sltYearMin']")).click();
		driver.findElement(By.xpath("//*[@id=\"isView\"]/div[1]/button")).click();
		driver.findElement(By.xpath("//button[@data-id='sltYearMin']")).sendKeys("2008");
		driver.findElement(By.xpath("//a[@tabindex='0'][contains(.,'De 2008')]")).click();
		driver.findElement(By.xpath("//button[@data-id='sltYearMax']")).click();
		driver.findElement(By.xpath("//button[@data-id='sltYearMax']")).sendKeys("2008");
		driver.findElement(By.xpath("//span[contains(.,'Até 2008')]")).click();
		driver.findElement(By.xpath("//button[@data-id='sltPriceMin']")).click();
		driver.findElement(By.xpath("//button[@data-id='sltPriceMin']")).sendKeys("20");
		driver.findElement(By.xpath("//span[contains(.,'De R$ 20 mil')]")).click();
		driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(.,'Preço máx.')]")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("40");
		driver.findElement(By.xpath("//span[contains(.,'Até R$ 40 mil')]")).click();
		driver.findElement(By.xpath("//button[contains(.,'Buscar')]")).click();
		// Validações de Modelo
		String modeloCarro1 = driver
				.findElement(By.xpath("(//h2[contains(.,'Honda New Civic LXS 1.8 16V (Flex)')])[1]")).getText();
		Assert.assertEquals("Honda New Civic LXS 1.8 16V (Flex)", modeloCarro1);
		String modeloCarro2 = driver.findElement(By.xpath("(//h2[contains(.,'Honda New Civic LXS 1.8')])[2]"))
				.getText();
		Assert.assertEquals("Honda New Civic LXS 1.8", modeloCarro2);

		// Validações de Valor
		driver.findElement(By.xpath("(//h2[contains(.,'Honda New Civic LXS 1.8 16V (Flex)')])[1]")).click();
		String valorCarro1 = driver.findElement(By.xpath("//h2[contains(.,'R$ 25.000,00')]")).getText();
		Assert.assertEquals("R$ 25.000,00", valorCarro1);
		// Guardando o Valor e atributos do Carro 1
		String anoCarro1 = driver.findElement(By.xpath("(//span[@class='destaque'])[1]")).getText();
		System.out.println(anoCarro1);
		String kmCarro1 = driver.findElement(By.xpath("(//span[@class='destaque'])[2]")).getText();
		String corCarro1 = driver.findElement(By.xpath("(//span[@class='destaque'])[3]")).getText();
		String cambioCarro1 = driver.findElement(By.xpath("(//span[@class='destaque'])[4]")).getText();
		driver.navigate().back();

		// Guardando o Valor e atributos do Carro 2
		driver.findElement(By.xpath("(//h2[contains(.,'Honda New Civic LXS 1.8')])[2]")).click();
		String valorCarro2 = driver.findElement(By.xpath("//h2[contains(.,'R$ 28.900,00')]")).getText();
		String anoCarro2 = driver.findElement(By.xpath("(//span[@class='destaque'])[1]")).getText();
		String kmCarro2 = driver.findElement(By.xpath("(//span[@class='destaque'])[2]")).getText();
		String corCarro2 = driver.findElement(By.xpath("(//span[@class='destaque'])[3]")).getText();
		String cambioCarro2 = driver.findElement(By.xpath("(//span[@class='destaque'])[4]")).getText();

		Assert.assertEquals("R$ 28.900,00", valorCarro2);
		driver.navigate().back();

		// Criando arquivo com dados dos veiculos (cria o arquivo dentro da pasta do
		// projeto)
		File arquivo = new File("arquivo.txt");

		try {
			FileWriter fileWriter = new FileWriter(arquivo);
			BufferedWriter escrever = new BufferedWriter(fileWriter);
			escrever.write(modeloCarro1 + " " + anoCarro1 + " " + kmCarro1 + " " + corCarro1 + " " + cambioCarro1);
			escrever.newLine();
			escrever.write(modeloCarro2 + " " + anoCarro2 + " " + kmCarro2 + " " + corCarro2 + " " + cambioCarro2);
			escrever.close();
			fileWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Validando Valores e Atributos do carro 1
		Assert.assertEquals("2008 / 2008", anoCarro1);
		Assert.assertEquals("94.236", kmCarro1);
		Assert.assertEquals("Preto", corCarro1);
		Assert.assertEquals("manual", cambioCarro1);

		// Validando Valores e Atributos do carro 2
		Assert.assertEquals("2008 / 2008", anoCarro2);
		Assert.assertEquals("159.000", kmCarro2);
		Assert.assertEquals("Prata", corCarro2);
		Assert.assertEquals("manual", cambioCarro2);
		
		//Finalizando o Teste
		driver.quit();

	}

}
