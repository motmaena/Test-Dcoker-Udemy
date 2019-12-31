package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTests {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() throws MalformedURLException {

        // BROWSER => chrome / firefox
        // HUB_HOST => localhost / 10.11.12.13 / hostname

        String host = "localhost";
        DesiredCapabilities dc = DesiredCapabilities.chrome();

        if (System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = DesiredCapabilities.firefox();
        }

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

        String completeURL = "http://" + host+ ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeURL), dc);

        // Run Via Local Driver
        /*
            System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\reza.motmaenarani\\Desktop\\Test_Docker\\AutomationTest\\chromedriver_win32\\chromedriver.exe");
        this.driver = new ChromeDriver();
        */
    }


    @AfterTest
    public void quitBrowser(){
        this.driver.quit();
    }
}
