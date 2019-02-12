package Compartilhado;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetConfiguracao {
	
	private static WebDriver driver = null;
	public static WebDriverWait waitVar = null;
	
	String gridAddress ="192.168.0.106:4444/";
	
	DesiredCapabilities capability;
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		SetConfiguracao.driver = driver;
	}

	public SetConfiguracao(){
		
	}
	public SetConfiguracao(int browserType) {
	    try {
			driver = getWebDriver(browserType);
		//	waitVar = new WebDriverWait(driver, 30);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void closeBrowser() {
	   // driver.close();
//	    driver.quit();
	}

	public WebDriver getWebDriver(int browserType) throws MalformedURLException {
	    switch (browserType) {
	     case 1:
	    	 FirefoxOptions optionsF = new FirefoxOptions();
	    	 optionsF.addArguments("--start-maximized");
	    	 capability = DesiredCapabilities.firefox();
	    	 capability.setCapability("marionette", true);
	    	  optionsF.merge(capability);
	    	 return new RemoteWebDriver(new URL("http://" + gridAddress + "/wd/hub"), (Capabilities) optionsF);
	 	case 2:
	 		capability = DesiredCapabilities.internetExplorer();
	 		capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
	    	 return new RemoteWebDriver(new URL("http://" + gridAddress + "/wd/hub"), capability);
	    case 3:
	    	 ChromeOptions optionsC = new ChromeOptions();
	    	 optionsC.addArguments("--start-maximized");
	    	 optionsC.addArguments("user-fake-ui-for-media-stream");
	    	 capability = DesiredCapabilities.chrome();
	    	 capability.setBrowserName("chrome");
	    	 capability.setCapability(ChromeOptions.CAPABILITY,optionsC);
	    	 return new RemoteWebDriver(new URL("http://" + gridAddress + "/wd/hub"), capability);
	     default:
	         throw new RuntimeException("Browser Não Suportado!!!!");
	    }
	}

}
