package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class practice {

    //TEST PASSED
    @Test
    public void simpleSearch() {
        System.setProperty("webdriver.chrome.driver", "C:\\Webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //dechiderea unui browser
        driver.get("http://testfasttrackit.info/selenium-test/");

        driver.findElement(By.linkText("VIP")).click();
        //driver.findElement(By.cssSelector("dd.odd li")).click();

        //selectarea size-ului in 2 moduri
        //driver.findElement(By.cssSelector("#narrow-by-list > dd:nth-child(14) > ol > li:nth-child(2) > a > span.swatch-label")).click();
        driver.findElement(By.xpath("//a[@href='http://testfasttrackit.info/selenium-test/vip.html?size=79']//span['$0']")).click();

    }

    // TEST FAIL, nu toate produsele de pe pagina contin cuv trousers
    @Test
    public void simpleSearchWithOneKeyword() {
        System.setProperty("webdriver.chrome.driver", "C:\\Webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/");

        driver.findElement(By.id("search")).sendKeys("trousers" + Keys.ENTER);

        System.out.println("Press Enter in search field.");

        List<WebElement> productNames = driver.findElements(By.cssSelector("h2.product-name a"));

        System.out.println("Stored " + productNames.size() + " product names.");

        for (WebElement productName : productNames) {
            assertThat("Some of the products`names do not contain the searched keyword.", productName.getText(), containsString("TROUSERS"));
        }
    }
}
