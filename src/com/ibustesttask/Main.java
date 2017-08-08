package com.ibustesttask;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    public static void main(String[] args) {

        System.out.println("My test has been started...");

        // Enabling Chrome driver
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // Getting PokerNews page
        driver.get("https://www.pokernews.com/");

        WebElement loginBox = driver.findElement(By.className("dropdownClick"));
        WebElement loginForm = driver.findElement(By.id("loginForm"));

        //System.out.println(errorStatus);

        loginBox.findElement(By.tagName("a")).click();

        WebElement username = driver.findElement(By.name("nick"));
        WebElement password = driver.findElement(By.name("password"));

        // INCORRECT data case

        username.sendKeys("hanna");
        password.sendKeys("123");

        username.submit();

        String errorMessageDisplayValue = loginForm
                .findElement(By.className("error"))
                .getCssValue("display");

        System.out.println("[1] Error message should be displayed " +
                "after form submission with INCORRECT data:");

        if (errorMessageDisplayValue.equals("block")) {
            System.out.println("[1] Status: PASSED");
        } else System.out.println("[1] Status: FAILED");

        username.clear();
        password.clear();

        // EMPTY data case

        username.submit();

        errorMessageDisplayValue = loginForm
                .findElement(By.className("error"))
                .getCssValue("display");

        System.out.println("[2] Error message should be displayed " +
                "after form submission with EMPTY data:");

        if (errorMessageDisplayValue.equals("block")) {
            System.out.println("[2] Status: PASSED");
        } else System.out.println("[2] Status: FAILED");

        username.clear();
        password.clear();

        // SUCCESSFUL LOGIN case

        username.sendKeys("applehouse1996");
        password.sendKeys("applehouse");

        username.submit();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {

                WebElement loginBox = d.findElement(By.className("dropdownClick"));

                loginBox.findElement(By.tagName("a")).click();

                Boolean isLoggedIn = d.findElement(
                        By.className("signout")
                ).getText().startsWith("Sign out");

                System.out.println("[3] 'Sign out' button should be displayed " +
                        "after LOGGING IN:");
                if (isLoggedIn) {
                    System.out.println("[3] Status: PASSED");
                } else {
                    System.out.println("[3] Status: PASSED");
                }
                return isLoggedIn;
            }
        });

        driver.quit();
    }
}
