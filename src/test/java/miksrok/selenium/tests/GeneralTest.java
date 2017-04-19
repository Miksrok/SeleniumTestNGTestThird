package miksrok.selenium.tests;

import miksrok.selenium.BaseScript;
import miksrok.selenium.pages.AdminPage;
import miksrok.selenium.pages.UserPage;
import miksrok.selenium.util.DataProv;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Залізний Мозок on 17.04.2017.
 */
public class GeneralTest extends BaseScript {
    private AdminPage adminPage;
    private UserPage userPage;

    @Test(dataProvider = "getAuthorizationData", dataProviderClass = DataProv.class)
    public void loginTest(String login, String password){
        loginPage.openLoginPage();
        adminPage = loginPage.login(login, password);
    }

    @Test(dependsOnMethods = "loginTest")
    public void creatNewProductTest(){
        adminPage.clickProductLink();
        adminPage.createNewProduct();
        userPage = adminPage.activateProduct();
    }

    @Test(dependsOnMethods = "creatNewProductTest")
    public void userTest(){
        userPage.openUserPage();
        userPage.showAllProducts();
        Assert.assertTrue(userPage.isNewProductIsPresent());
    }

    @Test(dependsOnMethods = "userTest")
    public void equalsPrice(){
        Assert.assertTrue(userPage.equalsPrice(), "Wrong price!");
    }
    @Test(dependsOnMethods = "userTest")
    public void equalsQty(){
        Assert.assertTrue(userPage.equalsQty(), "Wrong qty!");
    }
    @Test(dependsOnMethods = "userTest")
    public void equalsName(){
        Assert.assertTrue(userPage.equalsName(), "Wrong name!");
    }
}
