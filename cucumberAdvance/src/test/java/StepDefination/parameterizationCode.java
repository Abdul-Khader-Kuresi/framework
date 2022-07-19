package StepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class parameterizationCode {
	WebDriver driver = null;
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		System.out.println("Inside: User is on login page ");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://example.testproject.io/web/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().window().maximize();
		
	}

	@When("^User enters ([^\"]*) and ([^\"]*)$")
	public void user_enters_username_and_password(String username, String password) {
		System.out.println("Inside: user enters" + username + password);
		driver.findElement(By.id("name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
	}

	@And("clicks on login button")
	public void click_on_loin_page() throws InterruptedException {
		System.out.println("Inside: click on login page");
		driver.findElement(By.id("login")).click();
		Thread.sleep(3000);
	}
	
	

	@Then("^user is navigated to the home ([^\"]*)$")
	public void user_is_navigated_to_the_home_page(String country) throws InterruptedException {
		//select country India from drop down
		System.out.println("Inside: User is navigated to the home page");
		Select dropdown = new Select(driver.findElement(By.id("country")));
		dropdown.selectByVisibleText(country);
		System.out.println(country);
		Thread.sleep(2000);
		
		driver.findElement(By.id("logout")).click();
//		driver.quit();
		
	}
}