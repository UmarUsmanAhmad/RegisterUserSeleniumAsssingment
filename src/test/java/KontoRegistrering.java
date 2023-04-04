import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


public class KontoRegistrering {

    WebDriver driver;
    WebDriverWait wait;
    int time = 500;

    @After
    public void after() {
        driver.close();
        driver.quit();

    }

    @Given("Open the Website{string}")
    public void openTheWebsiteWebsiteMainPage(String browser) throws InterruptedException {


        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("web-driver.Chrome.driver", "C:/Selenium/chromedriver_win32/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("web-driver.Edge.driver", "C:/Selenium/Edgedriver/msedgedriver.exe");
            driver = new EdgeDriver();
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://login.mailchimp.com/signup/");
        Thread.sleep(time);
        driver.manage().window().maximize();
        Thread.sleep(time);
        driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click();
        Thread.sleep(time);
    }


    @And("Write Email{string}")
    public void writeEmail(String Email) throws InterruptedException {

        driver.findElement(By.id("email")).sendKeys(Email);
        Thread.sleep(time);

    }

    @And("Choose UserName{string}")
    public void chooseUserName(String Username) throws InterruptedException {


        WebElement sendingkeys = driver.findElement(By.id("new_username"));
        sendingkeys.click();
        sendingkeys.clear();
        sendingkeys.sendKeys(Username);

        Thread.sleep(time);

    }


    @And("Write Password{string}")
    public void writePassword(String Password) throws InterruptedException {
        driver.findElement(By.cssSelector("#new_password")).sendKeys(Password);
        Thread.sleep(time);
    }

    @And("Click on accept privacy and terms")
    public void clickOnAcceptPrivacyAndTerms() throws InterruptedException {
        driver.findElement(By.id("marketing_newsletter")).click();
        Thread.sleep(time);
    }

    @When("click on {string}")
    public void clickOnSignUp(String Signup) throws InterruptedException {

        WebElement signup = driver.findElement(By.cssSelector("#create-account-enabled"));
        signup.click();
        Thread.sleep(14000);

    }

    @Then("User will be Registered{string}")
    public void userWillBeRegisteredResult(String Created) {
        //WebElement LoginStatus = driver.findElement(By.cssSelector("#signup-content > div > div.content.line.section > section > div > h1"));
        // WebElement LoginStatusFail = driver.findElement(By.cssSelector("#av-flash-errors > ul > li"));

        boolean actual = true;
        boolean expected = true;

        if (Created.equalsIgnoreCase("Yes")) {
            expected = true;
        } else {
            expected = false;
        }
        if ((Created.equalsIgnoreCase("Yes")) && (driver.findElement(By.cssSelector("#signup-success > div > div.content.line.section > section > div > h1")).isDisplayed())) {
            actual = true;
        } else if ((Created.equalsIgnoreCase("No")) && (driver.findElement(By.cssSelector("#av-flash-errors > ul")).isDisplayed())) {
            actual = false;
        } else if ((Created.equalsIgnoreCase("Yes")) && (driver.findElement(By.cssSelector("#signup-success > div > div.content.line.section > section > div > h1")).isDisplayed())) {
            actual = true;
        } else if ((Created.equalsIgnoreCase("No")) && (driver.findElement(By.cssSelector("#av-flash-errors > ul")).isDisplayed())) {
            actual = false;
        } else if ((Created.equalsIgnoreCase("No")) && (driver.findElement(By.cssSelector("#signup-form > fieldset > div:nth-child(2) > div > span")).isDisplayed())) {
            actual = false;
            assertEquals(actual, expected);
        } else if ((Created.equalsIgnoreCase("No")) && (driver.findElement(By.cssSelector("#signup-form > fieldset > div:nth-child(2) > div > span")).isDisplayed())) {
            actual = false;
            assertEquals(actual, expected);
        }

    }

    @Then("User without Email Cannot be Registered{string}")
    public void userWithoutEmailCannotBeRegistered(String Created) {
        boolean actual = true;
        boolean expected = true;

        if (Created.equalsIgnoreCase("No")) {
            expected = true;
        } else {
            expected = false;
        }
        if ((Created.equalsIgnoreCase("No")) && (driver.findElement(By.cssSelector("#signup-form > fieldset > div:nth-child(1) > div > span")).isDisplayed())) {
            actual = true;
        } else {
            actual = false;
        }
        assertEquals(actual, expected);


    }
}
