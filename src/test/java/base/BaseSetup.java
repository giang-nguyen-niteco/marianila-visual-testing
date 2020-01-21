package base;

import com.applitools.eyes.selenium.Eyes;
import helper.LoadConfigFile;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseSetup {

    private static WebDriver driver;
    private static Eyes eyes;
    private static LoadConfigFile configFile = LoadConfigFile.getInstance();

    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        initiateEyes();
        String domain = configFile.getProperty("domain");
        driver.get(domain);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    private static void initiateEyes() {
        eyes = new Eyes();
        eyes.setApiKey(configFile.getProperty("eyes.api.key"));
    }
}
