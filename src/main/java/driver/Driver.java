package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Driver {

    private WebDriver driver;
    private AppiumDriver mobileDriver;

    public WebDriver initDriver(String browser) {
        switch (browser) {
            case "chrome" -> driver = WebDriverManager.chromedriver().create();

            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary("/usr/bin/firefox");

                driver = new FirefoxDriver(firefoxOptions);
            }
        }
        driver.manage().window().maximize();

        return driver;
    }

    public AppiumDriver initMobileDriver(String platform, String appPackage, String appActivity) throws MalformedURLException {
        switch (platform) {
            case "android" -> {
                UiAutomator2Options options = new UiAutomator2Options()
                        .setPlatformName(platform)
                        .setNewCommandTimeout(Duration.ofSeconds(300))
                        .setDeviceName("samsung")
                        .setUdid("ce0817189bb62909057e")
                        .noReset()
                        .setAppPackage(appPackage)
                        .setAppActivity(appActivity);
/*                        .setAppPackage("com.sec.android.app.popupcalculator")
                        .setAppActivity("com.sec.android.app.popupcalculator.Calculator");*/
/*                        .setAppPackage("com.meest.ua/.ui.scenes.home.HomeActivity")
                        .setAppActivity("com.meest.ua.ui.scenes.home.HomeActivity");*/

                mobileDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
            }

            case "ios" -> {
                XCUITestOptions options = new XCUITestOptions()
                        .setDeviceName("iPhone SE (3rd generation)")
                        .setPlatformVersion("16.2")
                        .setBundleId("io.cloudgrey.the-app");
                //.setApp(System.getProperty("user.dir") + "/VodQA.apk")
                mobileDriver = new IOSDriver(new URL("http://0.0.0.0:4723"), options);
            }
        }

        return mobileDriver;
    }
}
