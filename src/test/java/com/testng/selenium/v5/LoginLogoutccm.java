

package com.testng.selenium.v5;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginLogoutccm {
    WebDriver driver;
    String baseUrl = "https://www.instagram.com/";
    String username = "testuser";
    String password = "testpassword";

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\naman.mishra\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test(priority = 1)
    public void loginTest() {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
        String expectedTitle = "Welcome to Instagram.com";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 2)
    public void logoutTest() {
        driver.findElement(By.id("logoutButton")).click();
        String expectedTitle = "Login | Instagram.com";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

 //   @AfterTest
  //  public void teardown() {
    //    driver.quit();
    }
