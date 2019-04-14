package pageObjects;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class BaseUtil {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    private static List<WebDriver> storedDrivers = new ArrayList<>();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                storedDrivers.stream().forEach(WebDriver::quit);
            }
        });
    }

    protected BaseUtil() {
    }

    public static WebDriver getDriver() {
        return drivers.get();
    }

    public static void addDriver(WebDriver driver) {
        storedDrivers.add(driver);
        drivers.set(driver);
    }

    public static void removeDriver() {
        storedDrivers.remove(drivers.get());
        drivers.remove();
    }
}
