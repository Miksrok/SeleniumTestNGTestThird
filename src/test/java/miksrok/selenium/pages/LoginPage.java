package miksrok.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Залізний Мозок on 17.04.2017.
 */
public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private String loginPage = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0";
    private By login = By.id("email");
    private By password = By.id("passwd");
    private By submitLoginButton = By.name("submitLogin");

    public LoginPage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void openLoginPage(){
        driver.get(loginPage);
    }

    public AdminPage login(String login, String password){
        driver.findElement(this.login).sendKeys(login);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.submitLoginButton).click();
        return new AdminPage(driver);
    }

}
