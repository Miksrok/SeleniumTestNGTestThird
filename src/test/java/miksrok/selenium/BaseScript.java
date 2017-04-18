package miksrok.selenium;

import miksrok.selenium.pages.LoginPage;
import miksrok.selenium.util.EventHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

/**
 * Created by Залізний Мозок on 14.04.2017.
 */
public abstract class BaseScript {

    private final static String CHROME_PATH = "src\\test\\resources\\chromedriver.exe";
    private final static String FIREFOX_PATH = "src\\main\\resources\\geckodriver.exe";

    private static WebDriver getDriver(String browser) {

        switch (browser){
            case "chrome":{
                System.setProperty("webdriver.chrome.driver", CHROME_PATH);
                return new ChromeDriver();
            }
            default:{
                System.setProperty("webdriver.gecko.driver", FIREFOX_PATH);
                return new FirefoxDriver();
            }
        }
    }
    public static EventFiringWebDriver getConfiguredDriver(String browser) {
        WebDriver driver = getDriver(browser);
        driver.manage().window().maximize();
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(new EventHandler());
        return eventFiringWebDriver;
    }

    //================================================================================

    /*protected EventFiringWebDriver driver;
    protected LoginPage actions;

    *//**
     *
     * @param browser Driver type to use in tests.
     *
     * @return New instance of {@link WebDriver} object.
     *//*
    private WebDriver getDriver(String browser) {
        switch (browser) {
            case "firefox":
                System.setProperty(
                        "webdriver.gecko.driver",
                        getResource("/geckodriver.exe"));
                return new FirefoxDriver();
            case "ie":
            case "internet explorer":
                System.setProperty(
                        "webdriver.ie.driver",
                        getResource("/IEDriverServer.exe"));
                return new InternetExplorerDriver();
            case "chrome":
            default:
                System.setProperty(
                        "webdriver.chrome.driver",
                        getResource("/chromedriver.exe"));
                return new ChromeDriver();
        }
    }

    *//**
     * @param resourceName The name of the resource
     * @return Path to resource
     *//*
    private String getResource(String resourceName) {
        try {
            return Paths.get(BaseTest.class.getResource(resourceName).toURI()).toFile().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return resourceName;
    }

    *//**
     * Prepares {@link WebDriver} instance with timeout and browser window configurations.
     *
     * Driver type is based on passed parameters to the automation project,
     * creates {@link ChromeDriver} instance by default.
     *
     *//*
    @BeforeClass
    // TODO use parameters from pom.xml to pass required browser type
    public void setUp(String browser ) {
        driver = new EventFiringWebDriver(getDriver(browser));
        driver.register(new EventHandler());

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        actions = new LoginPage(driver);
    }

    *//**
     * Closes driver instance after test class execution.
     *//*
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }*/

//=======================================================================================
    /*private final static String CHROME_PATH = "src\\main\\resources\\chromedriver.exe";
    private final static String FIREFOX_PATH = "src\\main\\resources\\geckodriver.exe";

    private static WebDriver getDriver(String browser) {

        switch (browser){
            case "chrome":{
                System.setProperty("webdriver.chrome.driver", CHROME_PATH);
                return new ChromeDriver();
            }
            default:{
                System.setProperty("webdriver.gecko.driver", FIREFOX_PATH);
                return new FirefoxDriver();
            }
        }
    }*/

}
