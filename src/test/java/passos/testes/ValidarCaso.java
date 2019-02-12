package passos.testes;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

import Compartilhado.Passo;
import Compartilhado.SetConfiguracao;
import Compartilhado.VerificarTeste;
import cucumber.api.java.pt.Entao;

public class ValidarCaso {
	WebDriver driver = SetConfiguracao.getDriver();
	VerificarTeste verificarteste;
	Passo passo;
	
	
	@Entao ("^verificar texto (.*), (.*)$")
	public void verificar_texto(String arg1, String arg2){
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		verificarteste = new VerificarTeste (driver);
		verificarteste.imgPg(arg2);
		verificarteste.verifTextoPg(arg1);
	}	
	@Entao ("^verificar alerta (.*), (.*)$")
	public void verificar_alerta(String arg1, String arg2){
		verificarteste = new VerificarTeste (driver);
		verificarteste.verifAlert(arg1);
		verificarteste.imgPg(arg2);
	}	
	@Entao ("^clicar Ok alerta$")
	public void Ok_alerta(){
		verificarteste = new VerificarTeste (driver);
		verificarteste.okAlert();
	}	
	@Entao ("^verificar alerta clicar cancelar (.*), (.*)$")
	public void verificar_alerta_clicar_cancelar(String arg1, String arg2){
		verificarteste = new VerificarTeste (driver);
		verificarteste.verifAlert(arg1);
		verificarteste.imgPg(arg2);
	}
	
}