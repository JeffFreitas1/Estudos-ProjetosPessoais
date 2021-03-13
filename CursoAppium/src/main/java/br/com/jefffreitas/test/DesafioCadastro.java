package br.com.jefffreitas.test;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;

public class DesafioCadastro {
	
	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		AndroidDriver<MobileElement> driver = inicializarAppium();
			
			//acessar formulário
			driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
			
			//preencher campos
			MobileElement nomeTextField = driver.findElement(MobileBy.AccessibilityId("nome"));
			String nome = "Jeferson";
			nomeTextField.sendKeys(nome);
			MobileElement checkBox = driver.findElement(MobileBy.AccessibilityId("check"));
			MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
			Assert.assertTrue(checkBox.getAttribute("checked").equals("false"));
			Assert.assertTrue(switc.getAttribute("checked").equals("true"));
			checkBox.click();
			switc.click();
			
			//verifiacao de alterações
			Assert.assertFalse(checkBox.getAttribute("checked").equals("false"));
			Assert.assertFalse(switc.getAttribute("checked").equals("true"));
			
			//salvar
			driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']")).click();
			
			//Validacao Cadastro
			String conteudoNome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Jeferson']")).getText();
			Assert.assertEquals("Nome: " + nome, conteudoNome);
			String console = "xone";
			String conteudoConsole = driver.findElement(By.xpath("//android.widget.TextView[@text='Console: xone']")).getText();
			Assert.assertEquals("Console: " + console, conteudoConsole);
			String statusSwitch = driver.findElement(By.xpath("//android.widget.TextView[@text='Switch: Off']")).getText();
			Assert.assertEquals("Switch: Off", statusSwitch);
			String statusCheckBox = driver.findElement(By.xpath("//android.widget.TextView[@text='Checkbox: Marcado']")).getText();
			Assert.assertEquals("Checkbox: Marcado", statusCheckBox);
			
			
			
			driver.quit();
		}

	private AndroidDriver<MobileElement> inicializarAppium() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); 
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/jefer/OneDrive/Documentos/GitHub/Estudos/CursoAppium/src/main/resources/CTAppium_1_2.apk");
			
		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	}


