package pages.web.opencart.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.web.BasePage;

public class HomePageFactory extends BasePage {

    @FindBy(xpath = "//i[@class='fa fa-user']") WebElement myAccountDropDown;
    @FindBy(linkText = "Login") WebElement btnLogin;

/*    private final By myAccountDropDown = By.xpath("//i[@class='fa fa-user']");
    private final By btnLogin = By.linkText("Login");*/

    public HomePageFactory(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    public HomePageFactory clickMyAccountDropDown() {
        wait.until(ExpectedConditions.elementToBeClickable(myAccountDropDown)).click();
        return this;
    }

    public LoginPageFactory clickBtnLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
        return new LoginPageFactory(driver, wait);
    }

}
