package com.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.SignUpLoginPage;

public class BaseTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public SignUpLoginPage objSignUpLogin;

    @BeforeMethod
    public void beforeClass() {
        driver.set(new ChromeDriver());
        
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get().get("https://automationexercise.com/");

        objSignUpLogin = new SignUpLoginPage(driver.get());
    }

    @AfterMethod
    public void afterClass() {       
           driver.get().quit();
    
        }
  }
