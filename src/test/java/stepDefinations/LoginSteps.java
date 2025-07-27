package stepDefinations;



import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ExcelReader;

public class LoginSteps {

    WebDriver driver;

    @Given("user reads login data from Excel")
    public void read_login_data() {
        ExcelReader.readExcel();
    }

    @When("user logs into Facebook")
    public void user_logs_into_facebook() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys(ExcelReader.email);
        driver.findElement(By.id("pass")).sendKeys(ExcelReader.password);
        driver.findElement(By.name("login")).click();
    }

    @Then("user should see the homepage")
    public void user_should_see_homepage() {
        // Just wait for now or assert something visible after login
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
