package Compartilhado;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class VerificarTeste{
	WebDriver driver;
	public VerificarTeste (WebDriver driver){
		this.driver = driver;
	}
	public VerificarTeste verifAlert(String arg){
		try{
		Alert alert = driver.switchTo().alert();
		String testValor = alert.getText();
		alert.accept();
//		System.err.println(testValor);
		boolean validText = testValor.equals(arg);
		assertEquals(true,validText); 
		}catch(Exception e){
			imgPg("ev_erro "+arg);
		}
		return new VerificarTeste(driver);
	}
	public VerificarTeste okAlert(){
		try{
			Thread.sleep(500);
		Alert alert = driver.switchTo().alert();
		alert.accept(); 
		}catch(Exception e){}
		return new VerificarTeste(driver);
	}
	public VerificarTeste verifAlertCancelar(String arg){
		try{
		Alert alert = driver.switchTo().alert();
		String testValor = alert.getText();
		alert.dismiss();
		boolean validText = testValor.equals(arg);
		assertEquals(true,validText); 
		}catch(Exception e){
			imgPg("ev_erro "+arg);
		}
		return new VerificarTeste(driver);
	}
	public VerificarTeste verifTextoPg(String arg1){
		try{
			Thread.sleep(500);
			driver.switchTo().defaultContent();
			boolean validText = driver.getPageSource().contains(arg1);
			assertEquals(true,validText); 
		}catch(Exception e){

		}
		return new VerificarTeste(driver);
	}
	public void imgPg(String caso){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
				e1.printStackTrace();
		}
		try {
		Date now = new Date();
		DateFormat diaf = new SimpleDateFormat("dd");
		DateFormat mesf = new SimpleDateFormat("MM");
		DateFormat anof = new SimpleDateFormat("yyyy");
		String diaF = diaf.format(now);
		String mesF = mesf.format(now);
		String anoF = anof.format(now);
		String dataPasta = diaF + "_" + mesF + "_" + anoF;
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			new File("target/"+dataPasta + "/").mkdir();
			FileUtils.copyFile(scrFile, new File("target/"+dataPasta + "/" + caso + ".jpg"));

		} catch (Exception e) {
			new File("target/"+dataPasta + "/").mkdir();
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("target/"+dataPasta + "/" + caso + ".jpg"));
		}
	} catch (Exception e) {
		System.out.println(e);
	}
}
}
