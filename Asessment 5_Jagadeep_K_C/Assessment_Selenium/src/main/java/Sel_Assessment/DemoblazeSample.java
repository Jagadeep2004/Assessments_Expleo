package Sel_Assessment;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoblazeSample {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://demoblaze.com/");

        Actions act = new Actions(driver);
        

        driver.findElement(By.id("login2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));

        driver.findElement(By.id("loginusername")).sendKeys("anandkumar@gmail.com");
        driver.findElement(By.id("loginpassword")).sendKeys("Anandkumar@123");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        WebElement login_check = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2")));

        if (login_check.isDisplayed()) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");
        }
        
        

        WebElement laptopsLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Laptops")));
        act.moveToElement(laptopsLink).click().perform();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#tbodyid .card-title a")));
        List<WebElement> laptops = driver.findElements(By.cssSelector("#tbodyid .card-title a"));

        List<String> laptopNames = new ArrayList<>();

        for (WebElement lap : laptops) {
            laptopNames.add(lap.getText());
        }

        Collections.sort(laptopNames);

        Set<String> sortedSet = new LinkedHashSet<>(laptopNames);

        for (String name : sortedSet) {
            System.out.println(name);
        }

        for (WebElement lap : laptops) {
            if (lap.getText().equalsIgnoreCase("MacBook Pro")) {
                js.executeScript("arguments[0].scrollIntoView(true);", lap);
                System.out.println("Found Laptop: " + lap.getText());
                break;
            }
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='MacBook Pro']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='MacBook Pro']")));

        driver.findElement(By.xpath("//a[text()='Add to cart']")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        

        driver.findElement(By.id("cartur")).click();

        WebElement cartTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='MacBook Pro']")));
        WebElement cartPrice = driver.findElement(By.xpath("//td[2]"));

        if (cartTitle.isDisplayed() && cartPrice.isDisplayed()) {
            System.out.println("Product added to cart");
            System.out.println("MacBook Pro added to cart.");
        }
        
        

        driver.findElement(By.xpath("//button[text()='Place Order']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));

        driver.findElement(By.id("name")).sendKeys("Jagadeep");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("city")).sendKeys("Bangalore");
        driver.findElement(By.id("card")).sendKeys("1234567890123456");
        driver.findElement(By.id("month")).sendKeys("04");
        driver.findElement(By.id("year")).sendKeys("2026");

        driver.findElement(By.xpath("//button[text()='Purchase']")).click();

        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sweet-alert")));
        String purchase = confirmation.getText();

        if (purchase.contains("Order Id")) {
            System.out.println("Order is placed successfully");
            System.out.println(purchase);
        } 
        else 
        {
            System.out.println("Order is Unsuccessful");
        }
        
        

        driver.quit();
    }
}