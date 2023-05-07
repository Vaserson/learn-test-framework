package practice;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DriverMethods extends BaseTest {

    @BeforeMethod
    public void openPage() {
        driver.get("https://naveenautomationlabs.com/opencart/");
    }

    @Test
    public void searchTest() throws InterruptedException {
        driver.findElement(By.name("search")).sendKeys("IPhone", Keys.ENTER);

        //TODO WebDriverWait
        Thread.sleep(1000);

        String searchTitle = driver.findElement(By.cssSelector("div[id='content'] h1")).getText();
        System.out.println("searchTitle = " + searchTitle);

        Assert.assertEquals(searchTitle, "Search - IPhone");
    }

    @Test
    public void locatorTests() throws InterruptedException {
        Thread.sleep(1000);

        System.out.println("************ ************ ************");
        System.out.println("************   LOCATORS   ************");
        System.out.println("************ ************ ************");
        System.out.println();

        System.out.println("************ By.linkText(\"MacBook\") ************");
        driver.findElement(By.linkText("MacBook"));
        System.out.println();

        System.out.println("************ By.partialLinkText(\"Book\") ************");
        driver.findElement(By.partialLinkText("Book"));
        System.out.println();

        System.out.println("************ By.className(\"price\") ************");
        driver.findElement(By.className("price"));
        System.out.println();

        System.out.println("************ By.tagName(\"div\") ************");
        driver.findElement(By.tagName("div"));
        System.out.println();

        System.out.println("************ By.id(\"content\") ************");
        driver.findElement(By.id("content"));
        System.out.println();

        System.out.println("************ By.cssSelector(\"div[id='content'] h3\") ************");
        driver.findElement(By.cssSelector("div[id='content'] h3"));
        System.out.println();

        System.out.println("************ By.xpath(\"//img[@title='MacBook']\") ************");
        driver.findElement(By.xpath("//img[@title='MacBook']"));
        System.out.println();

        System.out.println("************ ************ ************");
        System.out.println("************ findElements => List<WebElement> ************");
        System.out.println("************ List<WebElement> prices = driver.findElements(By.className(\"price\")); ************");
        List<WebElement> prices = driver.findElements(By.className("price"));
        System.out.println();

        System.out.println("************ List<WebElement> iterate ************");
        System.out.println("************ prices.forEach(temp -> System.out.println(\"price: \" + temp.getText())); ************");
        prices.forEach(temp -> System.out.println("price: " + temp.getText()));
        System.out.println();
        System.out.println();


        System.out.println("************    ************   ************");
        System.out.println("************  ELEMENT ACTIONS  ************");
        System.out.println("************    ************   ************");
        System.out.println();

        System.out.println("sendKeys: driver.findElement(By.name(\"search\")).sendKeys(\"SomeText\");");
        driver.findElement(By.name("search")).sendKeys("SomeText");
        System.out.println();

        System.out.println("clear text field: driver.findElement(By.name(\"search\")).clear();");
        driver.findElement(By.name("search")).clear();
        System.out.println();

        System.out.println("click: driver.findElement(By.xpath(\"//img[@title='naveenopencart']\")).click();");
        driver.findElement(By.xpath("//img[@title='naveenopencart']")).click();
        Thread.sleep(1000);
        System.out.println();
        System.out.println();


        System.out.println("************    **************    ************");
        System.out.println("************  ELEMENT ATTRIBUTES  ************");
        System.out.println("************    **************    ************");
        System.out.println();


        WebElement book = driver.findElement(By.partialLinkText("Book"));
        WebElement content = driver.findElement(By.id("content"));
        WebElement price = driver.findElement(By.className("price"));
        WebElement heading = driver.findElement(By.cssSelector("div[id='content'] h3"));
        WebElement div = driver.findElement(By.tagName("div"));

        System.out.println("isEnabled: " + book.isEnabled());
        System.out.println("isDisplayed: " + book.isDisplayed());
        System.out.println("isSelected: " + book.isSelected());
        System.out.println("getTagName: " + book.getTagName());
        System.out.println("getAccessibleName: " + book.getAccessibleName());
        System.out.println("getAriaRole: " + book.getAriaRole());
        System.out.println("getAttribute: " + content.getAttribute("class"));
        System.out.println("getDomAttribute: " + content.getDomAttribute("class"));
        System.out.println("getCssValue: " + content.getCssValue("font-family"));
        System.out.println("getDomProperty: " + content.getDomProperty("class"));
        System.out.println("getLocation: " + content.getLocation());
        System.out.println("getRectangle: " + content.getRect());
//        System.out.println("ShadowRoot: " + content.getShadowRoot());
        System.out.println("getSize: " + content.getSize());
        System.out.println("getText: " + price.getText());
        System.out.println();
        System.out.println("No Attribute found: " + heading.getAttribute("class"));
        System.out.println("ManyTags AriaRole: " + div.getAriaRole());


        System.out.println("************    **************    ************");
        System.out.println("************   WebDriver ACTIONS  ************");
        System.out.println("************    **************    ************");
        System.out.println();

        System.out.println("driver.get(\"https://google.com\"); => Opens Google website");
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println();
        System.out.println("driver.getTitle(); => Title is: " + driver.getTitle());
        System.out.println("driver.getCurrentUrl(); => Current URL is: " + driver.getCurrentUrl());

        System.out.println();
        String firstTab = driver.getWindowHandle();
        System.out.println("driver.getWindowHandle(); => Current TAB handler is: " + firstTab);


        System.out.println();
        System.out.println("driver.switchTo().newWindow(WindowType.TAB); => Open new TAB");
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(1000);

        driver.get("https://bing.com");

        System.out.println();
        String secondTab = driver.getWindowHandle();
        System.out.println("driver.getWindowHandle(); => Current (second) TAB handler is: " + secondTab);

        System.out.println();
        System.out.println("driver.switchTo().window(firstTab); => Switches to the first TAB by its handler String: " + firstTab);
        driver.switchTo().window(firstTab);
        Thread.sleep(1000);

        System.out.println();
        System.out.println("driver.switchTo().window(secondTab); => Switches to the second TAB by its handler String: " + secondTab);
        driver.switchTo().window(secondTab);
        Thread.sleep(1000);

        System.out.println();
        System.out.println("driver.close(); => Closes current TAB");
        driver.close();
        driver.switchTo().window(firstTab);
        Thread.sleep(2000);

        System.out.println();
        System.out.println("driver.switchTo().newWindow(WindowType.WINDOW); => Open new WINDOW");
        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get("https://amazon.com");
        Thread.sleep(1000);
        driver.switchTo().window(firstTab);
        Thread.sleep(1000);
        driver.switchTo().newWindow(WindowType.WINDOW);
        Thread.sleep(1000);

        System.out.println();
        System.out.println("driver.manage().window().minimize();");
        System.out.println("driver.manage().window().maximize();");
        System.out.println("driver.manage().window().fullscreen();");
        driver.manage().window().minimize();
        Thread.sleep(1000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.manage().window().fullscreen();
        Thread.sleep(1000);

        System.out.println();
        System.out.println("driver.quit(); => Closes Driver session. No more driver. ");
//        driver.quit();
    }
}
