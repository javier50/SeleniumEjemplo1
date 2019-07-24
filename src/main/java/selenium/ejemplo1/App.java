package selenium.ejemplo1;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

	private static final Logger LOG = Logger.getLogger(App.class);
	
	public static String webDriver = "webdriver.chrome.driver";
	public static String pathDriver = "E:/Selenium/chromedriver.exe";
	
	public WebDriver driver;
	public String testURL = "http://primefaces.org/showcase/ui/panel/wizard.xhtml";
	
	public static void main(String[] args) {
		App app = new App();
		System.setProperty(webDriver, pathDriver);
		LOG.info("Empieza: " + new Date());
		app.prueba();
		LOG.info("Termina: " + new Date());
	}

	public void prueba() {
		try {
			driver = new ChromeDriver();
			driver.navigate().to(testURL);
			String pageTitle = driver.getTitle();
			LOG.info("pageTitle: " + pageTitle);
			
			// Firstname
			driver.findElement(By.id("j_idt701:j_idt707")).sendKeys("Selenium");
			
			// Lastname
			driver.findElement(By.id("j_idt701:j_idt709")).sendKeys("Ejemplo1");
			
			// Age
			driver.findElement(By.id("j_idt701:j_idt711")).sendKeys("Edad");
			
			// Skip to last
			driver.findElement(By.name("j_idt701:j_idt713")).sendKeys("checked");
			
			// Next
			driver.findElement(By.id("j_idt701:j_idt702_next")).click();
			
			WebElement messageError = driver.findElement(By.className("ui-messages-error"));
			if(messageError!= null  && messageError.isDisplayed()) {
				LOG.warn("ocurrio un error: " + driver.findElement(By.className("ui-messages-error-summary")).getText());			
			} else {
				LOG.info("paso");
			}
			
		} catch (Exception e) {
			LOG.error("error", e);
		}		
	}
}