package pages.web.opencart.bpmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.web.BasePage;

public class AccountPageBPMethods extends BasePage {

    private final By linkAccountInfo = By.linkText("Edit your account information");

    public AccountPageBPMethods(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public AccountInfoPageBPMethods clickLinkAccountInfo() {
        click(linkAccountInfo);
        return new AccountInfoPageBPMethods(driver, wait);
    }

}
