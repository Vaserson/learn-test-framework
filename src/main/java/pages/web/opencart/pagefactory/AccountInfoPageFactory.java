package pages.web.opencart.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.web.BasePage;

public class AccountInfoPageFactory extends BasePage {

    @FindBy(id = "input-email") WebElement fldEmail;

//    private final By fldEmail = By.id("input-email");


    public AccountInfoPageFactory(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    public String getEmailFldValue() {
        return getElementAttribute(fldEmail, "value");
    }

}
