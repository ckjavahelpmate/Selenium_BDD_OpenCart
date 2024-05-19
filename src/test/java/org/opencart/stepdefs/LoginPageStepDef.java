package org.opencart.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.opencart.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginPageStepDef {
    public WebDriver driver;
    public LoginPage loginPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am on the OpenCart login page")
    public void i_am_on_the_open_cart_login_page() {
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        loginPage = new LoginPage(driver);
    }

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        loginPage.getEMailAddressTextField().sendKeys("qatestertest@gmail.com");
        loginPage.getPasswordTextField().sendKeys("Test@123");
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.getLoginButton().click();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertTrue(loginPage.getLogoutButton().isDisplayed());
    }

    @Given("I have entered a invalid {string} and {string}")
    public void i_have_entered_a_invalid_and(String email, String password) {
        loginPage.getEMailAddressTextField().sendKeys(email);
        loginPage.getPasswordTextField().sendKeys(password);
    }

    @Then("I should see error message indicating {string}")
    public void i_should_see_error_message_indicating(String errorMessage) {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
    }

    @When("I click on forgot password link")
    public void i_click_on_forgot_password_link() {
        loginPage.getForgotPasswordLink().click();
    }

    @Then("I should be redirected to password reset page")
    public void i_should_be_redirected_to_password_reset_page() {
        Assert.assertEquals(driver.getTitle(), "Forgot Your Password?");
    }
}
