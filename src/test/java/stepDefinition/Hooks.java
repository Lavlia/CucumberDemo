package stepDefinition;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helper.LoggerHelper;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.BaseUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import static pageObjects.BasePage.accessingProperties;

public class Hooks extends BaseUtil {

    Logger log = LoggerHelper.getLogger(Hooks.class);

    @Before
    public void initDriver() {
        if (accessingProperties("driverType").equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            addDriver(new ChromeDriver());
            log.info("Chrome browser is opened");
        } else {
            WebDriverManager.firefoxdriver().setup();
            addDriver(new FirefoxDriver());
            log.info("Firefox browser is opened");

        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
                String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
                String name = scenario.getName();
                Files.copy(screenshot.toPath(),
                        new File("src/target/reports" + name + timestamp + "screenshot.png").toPath());
            } catch (IOException io) {
                io.printStackTrace();
            }
            removeDriver();
            getDriver().close();
            getDriver().quit();
        }
    }
}

