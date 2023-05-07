package mobile.calculator;

import driver.Driver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class FirstCalculatorTest {

    @Test
    public void testOpenApp() throws MalformedURLException, InterruptedException {
        new Driver().initMobileDriver(
                "android",
                "com.sec.android.app.popupcalculator",
                "com.sec.android.app.popupcalculator.Calculator"
        );

        Thread.sleep(5000);


        new Driver().initMobileDriver(
                "android",
                "com.rogers.ignitewifi",
                "com.xfinity.digitalhome.features.launch.splash.SplashActivity"
        );

        Thread.sleep(5000);

/*                        .setAppPackage("com.sec.android.app.popupcalculator")
                        .setAppActivity("com.sec.android.app.popupcalculator.Calculator");*/
    }
}
