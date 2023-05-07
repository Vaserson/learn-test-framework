package pages.web.opencart.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.web.BasePage;

public class AccountPageFactory extends BasePage {

    @FindBy(linkText = "Edit your account information") WebElement linkAccountInfo;

//    private final By linkAccountInfo = By.linkText("Edit your account information");


    public AccountPageFactory(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    public AccountInfoPageFactory clickLinkAccountInfo() {
        click(linkAccountInfo);
        return new AccountInfoPageFactory(driver, wait);
    }

}
