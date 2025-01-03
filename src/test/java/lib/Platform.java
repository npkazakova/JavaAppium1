package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Platform
{
    private static final String PLATFORM_ANDROID = "android";
    private static final String PLATFORM_IOS = "ios";
    //private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub"; //Android
    private static final String APPIUM_URL = "http://127.0.0.1:4723"; //iOS

    private static Platform instance;

    private Platform() {}

    public static Platform getInstance()
    {
        if (instance == null) {
            instance = new Platform();
        }
        return instance;
    }

    public AppiumDriver getDriver() throws Exception
    {
        URL URL = new URL(APPIUM_URL);
        if (this.isAndroid()) {
            return new AndroidDriver(URL, this.getAndroidDesiredCapabilities());
        } else if (this.isIOS()) {
            return new IOSDriver(URL, this.getIOSDesiredCapabilities());
        } else {
            throw new Exception("Cannot detect type of the Driver. Platform value: " + this.getPlatformVar());
        }
    }

    public boolean isAndroid()
    {
        return isPlatform(PLATFORM_ANDROID);
    }

    public boolean isIOS()
    {
        return isPlatform(PLATFORM_IOS);
    }

    private DesiredCapabilities getAndroidDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", "andnew");
        //capabilities.setCapability("appium:deviceName", "and80");
        capabilities.setCapability("appium:platformVersion", "8.1");
        //capabilities.setCapability("appium:platformVersion","8.0");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:appPackage", "org.wikipedia");
        capabilities.setCapability("appium:appActivity", ".main.MainActivity");
        capabilities.setCapability("appium:app","/Users/natalia/Desktop/Wikipedia.apk");
        //capabilities.setCapability("appium:app", "D:/Репозитории/JavaAppiumAutomation/apks/org.wikipedia.apk");
        return capabilities;
    }

    private DesiredCapabilities getIOSDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("appium:platformVersion", "18.1");
        capabilities.setCapability("appium:deviceName", "iPhone 16 Plus");
        capabilities.setCapability("appium:app", "/Users/natalia/Desktop/Wikipedia.app");
        capabilities.setCapability("appium:automationName", "XCUITest");
        return capabilities;
    }

    public boolean isPlatform(String my_platform)
    {
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);
    }

//    private String getPlatformVar()
    public String getPlatformVar()
    {
        return System.getenv("PLATFORM");
    }
}
