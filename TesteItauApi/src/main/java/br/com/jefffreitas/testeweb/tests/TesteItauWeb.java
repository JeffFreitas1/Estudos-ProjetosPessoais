package br.com.jefffreitas.testeweb.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TesteItauWeb {
	WebDriver driver;
	
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
		//Validações de Modelo
		String modeloCarro1 = driver.findElement(By.xpath("(//h2[contains(.,'Honda New Civic LXS 1.8 16V (Flex)')])[1]")).getText();
		Assert.assertEquals("Honda New Civic LXS 1.8 16V (Flex)", modeloCarro1);
		String modeloCarro2 = driver.findElement(By.xpath("(//h2[contains(.,'Honda New Civic LXS 1.8')])[2]")).getText();
		Assert.assertEquals("Honda New Civic LXS 1.8", modeloCarro2);
		//Validações de Valor
		driver.findElement(By.xpath("(//h2[contains(.,'Honda New Civic LXS 1.8 16V (Flex)')])[1]")).click();
		String valorCarro1 = driver.findElement(By.xpath("//h2[contains(.,'R$ 25.000,00')]")).getText();
		driver.navigate().back();
		driver.findElement(By.xpath("(//h2[contains(.,'Honda New Civic LXS 1.8')])[2]")).click();
		String valorCarro2 = driver.findElement(By.xpath("//h2[contains(.,'R$ 28.900,00')]")).getText();
		driver.navigate().back();
		Assert.assertEquals("R$ 25.000,00", valorCarro1);
		Assert.assertEquals("R$ 28.900,00", valorCarro2);
		
	
		
		
		driver.quit();
		

	}	

}
