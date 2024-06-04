package Automation.Automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {

	public static WebDriver driver = null;

	public static void main(String[] args) {
		setUP();
		printAllLinks();
		sizeOfLinks();
		clickOnModule("File Download");
		navigateToHomePage();
		clickOnModule("Checkboxes");
		clickOnCheckBox(2-1);
	}

	public static void setUP() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static void printAllLinks() {
		List<WebElement> links = driver.findElements(By.xpath("//ul/li/a"));

		for (WebElement a : links) {
			System.out.println(a.getText());
		}
	}

	public static void sizeOfLinks() {
		List<WebElement> links = driver.findElements(By.xpath("//ul/li/a"));
		System.out.println(links.size());
	}

	public static void clickOnModule(String moduleName) {
		List<WebElement> links = driver.findElements(By.xpath("//ul/li/a"));

		for (WebElement a : links) {
			if (a.getText().contains(moduleName)) {
				a.click();
				break;
			}
		}
	}

	public static void navigateToHomePage() {
		driver.navigate().back();
	}

	public static void clickOnCheckBox(int checkboxNumber) {
		List<WebElement> checkboxes = driver.findElements(By.xpath("//form[@id='checkboxes']/input"));
		for (int i = 0; i <=checkboxes.size(); i++) {
			if (i == checkboxNumber) {
				checkboxes.get(i).click();
			}
		}

	}

}
