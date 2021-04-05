package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchSteps {
	WebDriver driver;
	@Given ("the user is in index page")
	public void TheUserIsInIndexPage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("http://automationpractice.com/index.php");
		driver.navigate().to("http://automationpractice.com/index.php");
		//driver.get("https://www.http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	@When ("the user enters (.*) in the search bar")
	public void TheUserEntersDessesInTheSearchBar(String article) throws InterruptedException {
		driver.findElement(By.id("search_query_top")).sendKeys(article);
		Thread.sleep(2000);
	}
	
	//este es el And en cucumber pero en la realidad se usa como When
	@When ("the user clicks the search button")
	public void UserClicksTheSearchButton () throws InterruptedException {
		driver.findElement(By.name("submit_search")).click();
		Thread.sleep(2000);
	}
	
	
	// Then es donde van a vivir los asserts
	@Then ("the (.*) page appears")
	public void DressePage(String article) throws InterruptedException {
		String title = driver.findElement(By.className("lighter")).getText();
		Assert.assertEquals("\""+article.toUpperCase()+"\"", title);
		Thread.sleep(2000);
		driver.close();
		
		//Esta es ptra forma sin declarar una variable.
		//Assert.assertEquals(driver.findElement(By.className("lighter")).getText(),"\"DRESSES\"");
	}

}
