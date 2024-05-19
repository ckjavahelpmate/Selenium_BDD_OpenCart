package org.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-email")
    private WebElement eMailAddressTextField;

    @FindBy(id = "input-password")
    private WebElement passwordTextField;

    @FindBy(xpath = "//a[ text() = 'Forgotten Password']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//input[ @class = 'btn btn-primary']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[ text() = 'Logout' and @class = 'list-group-item']")
    private WebElement logoutButton;

    public WebElement getEMailAddressTextField() {
        return eMailAddressTextField;
    }

    public WebElement getPasswordTextField() {
        return passwordTextField;
    }

    public WebElement getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public void login(String email, String password) {
        eMailAddressTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
        loginButton.click();
    }
}
