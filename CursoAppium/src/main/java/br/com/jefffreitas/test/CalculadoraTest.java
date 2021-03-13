package br.com.jefffreitas.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculadoraTest {

	@Test
	public void deveSomarDoisValores() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		/*
		 * desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
		 * desiredCapabilities.setCapability("appActivity",
		 * "com.android.calculator2.Calculator");
		 * 
		 * desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
		 */
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"/Users/jefer/OneDrive/Documentos/GitHub/Estudos/CursoAppium/src/main/resources/CTAppium_1_2.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);

		driver.quit();

	}
}
