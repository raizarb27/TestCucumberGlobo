package passos.paginas;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Compartilhado.Passo;

public class PassosNewsLetter {

	
	WebDriver driver;
	Passo passo;

	public PassosNewsLetter(WebDriver driver) {
		this.driver = driver;
		passo = new Passo(driver);
	}

	public PassosNewsLetter AcessaPagina(String arg) {
		driver.switchTo().defaultContent();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.navigate().to(arg);
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		return new PassosNewsLetter(driver);
	}

	public PassosNewsLetter edicaopreferencia(String argPg) {
		By edicaopreferencia = By
				.xpath("(.//*[normalize-space(text()) and normalize-space(.)='"+argPg+"'])[1]/span[1]");
		passo.clicar(edicaopreferencia);
		return new PassosNewsLetter(driver);
	}

	public PassosNewsLetter campoEmail(String argPg) {
		By campoEmail = By.name("Email Address");
		passo.digitar(campoEmail, argPg);
		return new PassosNewsLetter(driver);
	}

	public PassosNewsLetter campoEmailConfirme(String argPg) {
		By campoEmailConfirme = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Confirmar seu e-mail'])[1]/following::input[1]");
		passo.digitar(campoEmailConfirme, argPg);
		return new PassosNewsLetter(driver);
	}

	public PassosNewsLetter campoCaptcha(String argPg) {
		By campoCaptcha = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Confirmar seu e-mail'])[1]/following::input[2]");
		passo.digitar(campoCaptcha, argPg);
		return new PassosNewsLetter(driver);
	}

	public PassosNewsLetter btnInscrevese() {
		By btnInscrevese = By.xpath("//a[contains(text(),'Inscreva-se')]");
		passo.clicar(btnInscrevese);
		return new PassosNewsLetter(driver);
	}
}
