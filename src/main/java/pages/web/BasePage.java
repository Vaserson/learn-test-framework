package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public WebElement getClickableElement(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement getClickableElement(WebElement e) {
        return wait.until(ExpectedConditions.elementToBeClickable(e));
    }

    public WebElement getPresentElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement getPresentElement(WebElement e) {
        return wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void click(By by) {
        getClickableElement(by).click();
    }

    public void click(WebElement e) {
        getClickableElement(e).click();
    }

    public void fill(By by, String text) {
        WebElement e = getPresentElement(by);
        e.clear();
        e.sendKeys(text);
    }

    public void fill(WebElement element, String text) {
        WebElement e = getPresentElement(element);
        e.clear();
        e.sendKeys(text);
    }

    public String getElementAttribute(By by, String attribute) {
        return getPresentElement(by).getAttribute(attribute);
    }

    public String getElementAttribute(WebElement e, String attribute) {
        return getPresentElement(e).getAttribute(attribute);
    }

}
