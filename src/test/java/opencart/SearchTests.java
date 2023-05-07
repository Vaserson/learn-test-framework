package opencart;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest {

    @BeforeMethod
    public void openPage() {
        driver.get("https://naveenautomationlabs.com/opencart/");
    }

    @Test
    public void searchTest() {
        driver.findElement(By.name("search")).sendKeys("IPhone", Keys.ENTER);

        String searchTitle = driver.findElement(By.cssSelector("div[id='content'] h1")).getText();
        System.out.println("searchTitle = " + searchTitle);

        Assert.assertEquals(searchTitle, "Search - IPhone");
    }

}
