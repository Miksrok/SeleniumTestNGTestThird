package miksrok.selenium.pages;

import miksrok.selenium.models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Залізний Мозок on 17.04.2017.
 */
public class AdminPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Product product;

    private By catalogLink = By.id("subtab-AdminCatalog");
    private By productLink = By.cssSelector("#subtab-AdminProducts");
    private By newProductButton = By.cssSelector("#page-header-desc-configuration-add");
    private By productName = By.cssSelector("#form_step1_name_1");
    private By productQty = By.cssSelector("#form_step1_qty_0_shortcut");
    private By productPrice = By.cssSelector("#form_step1_price_shortcut");
    private By activateProduct = By.cssSelector(".switch-input ");
    private By activateMessage = By.cssSelector("#growls .growl-message");
    private By activateMessageClose = By.cssSelector("#growls .growl-close");
    private By saveButton = By.xpath("//div[@class='product-footer']/div[2]/div/button");

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void clickProductLink(){
        Actions action = new Actions(driver) ;
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.catalogLink));
        WebElement catalogLink = driver.findElement(this.catalogLink);
        WebElement categoryLink = driver.findElement(this.productLink);
        action.moveToElement(catalogLink)
                .moveToElement(categoryLink)
                .click()
                .build()
                .perform();
    }


    public void createNewProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.newProductButton));
        WebElement newProductButton = driver.findElement(this.newProductButton);
        newProductButton.click();
        product = Product.generate();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.productName));
        WebElement productName = driver.findElement(this.productName);
        productName.sendKeys(product.getName());
        WebElement productQty = driver.findElement(this.productQty);
        productQty.sendKeys(Keys.BACK_SPACE);
        productQty.sendKeys(product.getQty()+"");
        WebElement productPrice = driver.findElement(this.productPrice);
        for (int i = 0; i<10 ; i++){
            productPrice.sendKeys(Keys.BACK_SPACE);
        }
        productPrice.sendKeys(product.getPrice());
    }

    public UserPage activateProduct(){
        WebElement activateProduct = driver.findElement(this.activateProduct);
        activateProduct.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.activateMessage));
        WebElement activateMessage = driver.findElement(this.activateMessage);
        WebElement activateMessageClose = driver.findElement(this.activateMessageClose);
        activateMessageClose.click();
        WebElement saveButton = driver.findElement(this.saveButton);
        saveButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.activateMessage));
        WebElement activateMessageSecond = driver.findElement(this.activateMessage);
        WebElement activateMessageCloseSecond = driver.findElement(this.activateMessageClose);
        activateMessageCloseSecond.click();
        return new UserPage(driver, product);
    }

}
