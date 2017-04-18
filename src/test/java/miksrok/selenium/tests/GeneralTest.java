package miksrok.selenium.tests;

import miksrok.selenium.BaseScript;
import miksrok.selenium.models.Product;
import miksrok.selenium.pages.AdminPage;
import miksrok.selenium.pages.LoginPage;
import miksrok.selenium.pages.UserPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by Залізний Мозок on 17.04.2017.
 */
public class GeneralTest extends BaseScript {
    private LoginPage loginPage;
    private AdminPage adminPage;
    private UserPage userPage;
    private static String defaultBrowser = "firefox";
    private static String chromeBrowser = "chrome";
    private static String login = "webinar.test@gmail.com";
    private static String password = "Xcg7299bnSmMuRLp9ITw";



    /*@Test
    public void user(){
        Product p = Product.generate();
        System.out.println(p.getName());
        System.out.println(p.getPrice());
        System.out.println(p.getQty());
    }*/
    @Test
    public void loginTest(){
        loginPage = new LoginPage(getConfiguredDriver(chromeBrowser));
        loginPage.openLoginPage();
        adminPage = loginPage.login(login, password);
    }

    @Test(dependsOnMethods = "loginTest")
    public void creatNewProductTest(){
        adminPage.clickProductLink();
        userPage = adminPage.createNewProduct();
    }

    @Test(dependsOnMethods = "creatNewProductTest")
    public void userTest(){
       Assert.assertTrue(userPage.openUserPage());
    }

    @Test(dependsOnMethods = "userTest")
    public void nextTest(){
        Assert.assertTrue(userPage.truePrice(), "Wrong price!");
    }
    @Test(dependsOnMethods = "userTest")
    public void nextTest2(){
        Assert.assertTrue(userPage.trueQty(), "Wrong qty!");
    }
    @Test(dependsOnMethods = "userTest")
    public void nextTest3(){
        Assert.assertTrue(userPage.trueName(), "Wrong name!");
    }

}
