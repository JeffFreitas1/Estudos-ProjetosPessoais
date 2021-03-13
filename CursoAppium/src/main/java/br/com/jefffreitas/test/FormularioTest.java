package br.com.jefffreitas.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.jefffreitas.appium.core.BaseTest;
import br.com.jefffreitas.appium.core.DriverFactory;
import br.com.jefffreitas.page.FormularioPage;
import br.com.jefffreitas.page.MenuPage;

public class FormularioTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();

	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		page.escreverNome("Jeferson");
		assertEquals("Jeferson", page.obterNome());
	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		page.selecionarCombo("Nintendo Switch");
		Assert.assertEquals("Nintendo Switch", page.obterValorCombo());
	}

	@Test
	public void deveInteragirSwitchCheckbox() throws MalformedURLException {
		Assert.assertFalse(page.isCheckMarcado());
		Assert.assertTrue((page.isSwitchMarcado()));
		page.clicarCheck();
		page.clicarSwitch();

		// verificar estados alterados
		Assert.assertTrue(page.isCheckMarcado());
		Assert.assertFalse(page.isSwitchMarcado());

	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException {

		// preencher campos
		page.escreverNome("Jeferson");
		page.clicarCheck();
		page.clicarSwitch();
		page.selecionarCombo("Nintendo Switch");

		// salvar
		page.clicarSalvar();

		// Validacao Cadastro
		Assert.assertEquals("Nome: Jeferson", page.obterNomeCadastrado());
		Assert.assertEquals("Console: switch", page.obterConsoleCadastrado());
		Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Off"));
		Assert.assertTrue(page.obterCheckCadastrado().endsWith("Marcado"));

	}

	@Test
	public void deveRealizarCadastroDemorado() throws MalformedURLException {
		page.escreverNome("Jeferson");
		page.clicarSalvarDemorado();
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Jeferson']")));
		Assert.assertEquals("Nome: Jeferson", page.obterNomeCadastrado());

	}

}
