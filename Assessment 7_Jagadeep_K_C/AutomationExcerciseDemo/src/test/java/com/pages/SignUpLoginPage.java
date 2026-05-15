package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpLoginPage extends BasePage {

	public WebDriver driver;

	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
	public WebElement Login_Register;

	// SignUp

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")
	public WebElement registerUsername;

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
	public WebElement registerEmail;

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/button")
	public WebElement registerButton;

	@FindBy(xpath = "//*[@id=\"password\"]")
	public WebElement registerPassword;

	@FindBy(xpath = "//*[@id=\"first_name\"]")
	public WebElement registerFirstName;

	@FindBy(xpath = "//*[@id=\"last_name\"]")
	public WebElement registerLastName;

	@FindBy(xpath = "//*[@id=\"company\"]")
	public WebElement registerCompany;

	@FindBy(xpath = "//*[@id=\"address1\"]")
	public WebElement registerAddress;

	@FindBy(xpath = "//*[@id=\"country\"]")
	public WebElement registerCountry;

	@FindBy(xpath = "//*[@id=\"state\"]")
	public WebElement registerState;

	@FindBy(xpath = "//*[@id=\"city\"]")
	public WebElement registerCity;

	@FindBy(xpath = "//*[@id=\"zipcode\"]")
	public WebElement registerZipcode;

	@FindBy(xpath = "//*[@id=\"mobile_number\"]")
	public WebElement registerMobileNumber;

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/form/button")
	public WebElement registerCompletionButton;

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
	public WebElement registerSuccessMessage;
	
	@FindBy(xpath = "//form[@action='/signup']//p")
	public WebElement signupErrorMessage;

	// Login

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
	public WebElement loginEmail;

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")
	public WebElement loginPassword;

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/button")
	public WebElement loginButton;

	
	@FindBy(xpath = "//a[contains(text(),'Logged in as')]")
	public WebElement loggedInUserLabel;

	@FindBy(xpath = "//form[@action='/login']//p")
	public WebElement loginErrorMessage;
	
	public void signUp(String strRegisterUsername, String strRegisterEmail, String strRegisterPassword,
			String strRegisterFirstName, String strRegisterLastName, String strRegisterCompany,
			String strRegisterAddress, String strRegisterState, String strRegisterCity, String strRegisterZipCode,
			String strRegisterMobileNumber) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


		wait.until(ExpectedConditions.elementToBeClickable(Login_Register)).click();

		wait.until(ExpectedConditions.visibilityOf(registerUsername));

		registerUsername.sendKeys(strRegisterUsername);
		registerEmail.sendKeys(strRegisterEmail);

		wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();


		wait.until(ExpectedConditions.visibilityOf(registerPassword));

		registerPassword.sendKeys(strRegisterPassword);
		registerFirstName.sendKeys(strRegisterFirstName);
		registerLastName.sendKeys(strRegisterLastName);
		registerCompany.sendKeys(strRegisterCompany);
		registerAddress.sendKeys(strRegisterAddress);

		wait.until(ExpectedConditions.visibilityOf(registerState)).sendKeys(strRegisterState);
		registerCity.sendKeys(strRegisterCity);
		registerZipcode.sendKeys(strRegisterZipCode);
		registerMobileNumber.sendKeys(strRegisterMobileNumber);

		wait.until(ExpectedConditions.elementToBeClickable(registerCompletionButton)).click();

		wait.until(ExpectedConditions.visibilityOf(registerSuccessMessage));
	}

	public void logIn(String strLoginEmail, String strLoginPassword) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.elementToBeClickable(Login_Register)).click();

	    wait.until(ExpectedConditions.visibilityOf(loginEmail)).sendKeys(strLoginEmail);
	    loginPassword.sendKeys(strLoginPassword);

	    wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	}

	
	public String getSuccessMessage() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    return wait.until(ExpectedConditions.visibilityOf(registerSuccessMessage)).getText();
	}
	
	public String getSignupErrorMessage() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    return wait.until(ExpectedConditions.visibilityOf(signupErrorMessage)).getText();
	}
	
	public String getLoggedInUserText() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    return wait.until(ExpectedConditions.visibilityOf(loggedInUserLabel)).getText();
	}

	public String getLoginErrorMessage() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    return wait.until(ExpectedConditions.visibilityOf(loginErrorMessage)).getText();
	}
	
	public SignUpLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
