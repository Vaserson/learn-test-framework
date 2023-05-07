package mobile.ignitewifi;

import driver.Driver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class FirstMobileTest {

    @Test
    public void testOpenApp() throws MalformedURLException, InterruptedException {
        new Driver().initMobileDriver(
                "android",
                "com.rogers.ignitewifi",
                "com.xfinity.digitalhome.features.launch.splash.SplashActivity"
        );
        Thread.sleep(5000);
    }
}
