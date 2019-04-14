package pageObjects;

import org.openqa.selenium.WebDriver;


import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage extends BaseUtil {

    WebDriver.Timeouts wait;

    public BasePage() {

        wait = getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }

    public static String accessingProperties(String key) {
        Properties prop = new Properties();
        try {
            InputStream input = new FileInputStream("commons.properties");
            prop.load(input);
            return prop.getProperty(key);
        } catch (IOException io) {
            io.printStackTrace();
        }
        return prop.getProperty(key);
    }
}
