package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import junit.framework.TestCase;
import lib.ui.WelcomePageObject;
//import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.rotateScreenPortrait();
        this.skipWelcomePageForIOSApp();
    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }

//    protected void rotateScreenPortrait() {
//        driver.rotate(ScreenOrientation.PORTRAIT);
//    }
//
//    protected void rotateScreenLandscape() {
//        driver.rotate(ScreenOrientation.LANDSCAPE);
//    }
//
//    protected void backgroundApp(int seconds) {
//        driver.runAppInBackground(seconds);
//    }

//    protected void rotateScreenPortrait() {
//        if (driver instanceof ScreenOrientation) {
//            ((Rotatable) driver).rotate(ScreenOrientation.PORTRAIT);
//        } else {
//            System.out.println("Rotation is not supported on this driver.");
//        }
//    }
//
//    protected void rotateScreenLandscape() {
//        if (driver instanceof Rotatable) {
//            ((Rotatable) driver).rotate(ScreenOrientation.LANDSCAPE);
//        } else {
//            System.out.println("Rotation is not supported on this driver.");
//        }
//    }

    protected void rotateScreenPortrait() {
        try {
            //driver.setOrientation(ScreenOrientation.PORTRAIT);
        } catch (UnsupportedOperationException e) {
            System.out.println("Rotation is not supported on this driver: " + e.getMessage());
        }
    }

    protected void rotateScreenLandscape() {
        try {
            //driver.setOrientation(ScreenOrientation.LANDSCAPE);
        } catch (UnsupportedOperationException e) {
            System.out.println("Rotation is not supported on this driver: " + e.getMessage());
        }
    }

    protected void backgroundApp(int seconds) {
        if (driver instanceof InteractsWithApps) {
            ((InteractsWithApps) driver).runAppInBackground(Duration.ofSeconds(seconds));
        } else {
            throw new UnsupportedOperationException("The driver does not support running the app in background.");
        }
    }

    private void skipWelcomePageForIOSApp() {
        if (Platform.getInstance().isIOS()) {
            WelcomePageObject welcomePageObject = new WelcomePageObject(driver);
            welcomePageObject.clickSkip();
        }
    }

    protected boolean isPlatformIOS() {
        String platform = System.getenv("PLATFORM");
        return platform != null && platform.equalsIgnoreCase("ios");
    }
}

//package lib;
//
//import io.appium.java_client.AppiumDriver;
//import junit.framework.TestCase;
//import lib.ui.WelcomePageObject;
//
//import java.time.Duration;
//
//public class CoreTestCase extends TestCase {
//
//    protected AppiumDriver driver;
//
//    @Override
//    protected void setUp() throws Exception
//    {
//        super.setUp();
//        driver = Platform.getInstance().getDriver();
//        this.rotateScreenPortrait();
//        this.SkipWelcomePageForIOSApp();
//    }
//
//    @Override
//    protected void tearDown() throws Exception
//    {
//        driver.quit();
//
//        super.tearDown();
//    }
//
//    protected void rotateScreenPortrait()
//    {
//        driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
//    }
//
//    protected void rotateScreenLandscape()
//    {
//        driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
//    }
//
//    protected void backgroundApp(int seconds)
//    {
//        driver.runAppInBackground(Duration.ofSeconds(seconds));;
//    }
//
//    private void SkipWelcomePageForIOSApp()
//    {
//        if (Platform.getInstance().isIOS()) {
//            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
//            WelcomePageObject.clickSkip();
//        }
//    }
//
//    protected boolean isPlatformIOS() {
//        String platform = System.getenv("PLATFORM");
//        return platform != null && platform.equalsIgnoreCase("ios");
//    }
//}
//
