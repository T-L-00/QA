package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class FirstScriptTest {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tlukovic\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }

    @Test
    public void FirstTest() {

        driver.get("https://www.saucedemo.com");
        Reporter.log("Website opened.");

        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[1]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[2]")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String header = driver.findElement(By.id("header_container")).getText();
        Assert.assertEquals("Products", header);

        boolean Shopping_Cart = driver.findElement(By.className("inventory_container")).isDisplayed();
        Assert.assertTrue(Shopping_Cart);

        boolean BurgerMenu = driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]")).isDisplayed();
        Assert.assertTrue(BurgerMenu);

        String Twitter = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a")).getDomAttribute("href");
        Assert.assertEquals("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a", Twitter);
        String Facebook = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a")).getDomAttribute("href");
        Assert.assertEquals("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a", Facebook);
        String LinkedIn = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a")).getDomAttribute("href");
        Assert.assertEquals("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a", LinkedIn);

        driver.findElement(By.id("menu_button_container")).click();

        String Logout = driver.findElement(By.id("logout_sidebar_link")).getText();
        Assert.assertEquals("Logout", Logout);
    }
}

