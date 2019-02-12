package passos.testes;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Compartilhado.SetConfiguracao;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;
import passos.paginas.PassosNewsLetter;

public class PaginaNewsLetter {

	SetConfiguracao setConfiguracao;
	PassosNewsLetter passosnewsletter;

	@Before("@Firefox")
	public void beforeScenario() {
		setConfiguracao = new SetConfiguracao(1);
	}
	@Before("@Chrome")
	public void beforeScenario1() {
		setConfiguracao = new SetConfiguracao(3);
	}
	@Before("@IE")
	public void beforeScenario2() {
		setConfiguracao = new SetConfiguracao(2);
	}
	
	@After
	public void FechaNavegador(Scenario scenario) {
		
		if (scenario.isFailed()){
			scenario.write("FAILURE >> "+scenario.getName()+" > "+scenario.getStatus());
			byte[] screenshot = ((TakesScreenshot)SetConfiguracao.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}else{
			scenario.write("SUCCESS >> "+scenario.getName()+" > "+scenario.getStatus());
			byte[] screenshot = ((TakesScreenshot)SetConfiguracao.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		
		setConfiguracao.closeBrowser();
	}
	
	@Dado("^o usuario acessa a pagina do newsletter a url (.*)$")
	public void o_usuario_acessa_a_pagina_do_newsletter_a_url(String argPg) {
		passosnewsletter = new PassosNewsLetter(SetConfiguracao.getDriver());
		passosnewsletter.AcessaPagina(argPg);
	}

	@Quando("^selecionar na tela Newsletters O Globo as edições de sua preferência (.*)$")
	public void selecionar_na_tela_Newsletters_O_Globo_as_edições_de_sua_preferência (String argPg) {
		passosnewsletter = new PassosNewsLetter(SetConfiguracao.getDriver());
		passosnewsletter.edicaopreferencia(argPg);
	}

	@Quando("^o usuario digitar na tela de login no campo Endereço de e-mail (.*)$")
	public void o_usuario_digitar_na_tela_de_login_no_campo_Endereço_de_e_mail(String argPg) {
		passosnewsletter = new PassosNewsLetter(SetConfiguracao.getDriver());
		passosnewsletter.campoEmail(argPg);
	}

	@Quando("^o usuario digitar na tela de login no campo Confirmar seu e-mail (.*)$")
	public void o_usuario_digitar_na_tela_de_login_no_campo_Confirmar_seu_e_mail(String argPg) {
		passosnewsletter = new PassosNewsLetter(SetConfiguracao.getDriver());
		passosnewsletter.campoEmailConfirme(argPg);
	}

	@Quando("^digitar na tela Newsletters O Globo em Informe seu e-mail para recebimento da newsletter no campo (.*)$")
	public void digitar_na_tela_Newsletters_O_Globo_em_Informe_seu_e_mail_para_recebimento_da_newsletter_no_campo(
			String argPg) {
		passosnewsletter = new PassosNewsLetter(SetConfiguracao.getDriver());
		passosnewsletter.campoCaptcha(argPg);
	}

	@Quando("^clicar na tela Newsletters O Globo no botão increva-se$")
	public void clicar_na_tela_Newsletters_O_Globo_no_botão_increva_se() {
		passosnewsletter = new PassosNewsLetter(SetConfiguracao.getDriver());
		passosnewsletter.btnInscrevese();
	}

}
