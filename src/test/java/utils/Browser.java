package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    private static WebDriver driverInstance = null;

    public static WebDriver getInstance() {
        if (driverInstance == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--disable-gpu");
            driverInstance = new ChromeDriver(options);
            driverInstance.manage().window().maximize();
        }
        return driverInstance;
    }

    public static void quitDriver(){
        driverInstance.quit();
        driverInstance = null;
    }
}