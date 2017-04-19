package miksrok.selenium.pages;

import miksrok.selenium.models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Залізний Мозок on 17.04.2017.
 */
public class UserPage {

    private Product product;
    private WebDriver driver;
    private WebDriverWait wait;

    private String userPage = "http://prestashop-automation.qatestlab.com.ua";
    private By allProductLink = By.cssSelector(".all-product-link");
    private By name = By.xpath("//h1[@itemprop='name']");
    private By qty = By.xpath("//div[@class='product-quantities']");
    private By price = By.xpath("//span[@itemprop='price']");

    public UserPage(WebDriver driver, Product product) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        this.product = product;
    }

    public void openUserPage(){
        driver.navigate().to(userPage);
    }

    public void showAllProducts(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.allProductLink));
        WebElement allProductLink = driver.findElement(this.allProductLink);
        allProductLink.click();
    }

    public boolean isNewProductIsPresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-description']/h1/a[contains(text(),'"+product.getName()+"')]")));
        WebElement prod = driver.findElement(By.xpath("//div[@class='product-description']/h1/a[contains(text(),'"+product.getName()+"')]"));
        prod.click();
        return true;
    }

    public boolean equalsQty(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(this.qty));
        WebElement elem = driver.findElement(By.xpath("//div[@class='product-quantities']/span"));
        String tmp = elem.getText();
        String [] arr = tmp.split(" ");
        return arr[0].equals(product.getQty()+"");

    }
    public boolean equalsName(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(this.name));
        WebElement elem = driver.findElement(this.name);
        String name = elem.getText().toLowerCase();
        return name.equals(product.getName());

    }
    public boolean equalsPrice(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(this.price));
        WebElement price = driver.findElement(this.price);
        String pr = price.getAttribute("content");
        pr = pr.replace('.',',');
        return pr.equals(product.getPrice());

    }

}
