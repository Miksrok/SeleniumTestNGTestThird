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

    public UserPage(WebDriver driver, Product product) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        this.product = product;
    }

    public boolean openUserPage(){
        driver.navigate().to(userPage);
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.allProductLink));
        WebElement allProductLink = driver.findElement(this.allProductLink);
        allProductLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-description']/h1/a[contains(text(),'"+product.getName().toLowerCase()+"')]")));
        WebElement prod = driver.findElement(By.xpath("//div[@class='product-description']/h1/a[contains(text(),'"+product.getName().toLowerCase()+"')]"));
        prod.click();
        return true;
    }
    public boolean trueQty(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-quantities']")));
        WebElement elem = driver.findElement(By.xpath("//div[@class='product-quantities']/span"));
        String tmp = elem.getText();
        String [] arr = tmp.split(" ");
        System.out.println(arr[0]);
        System.err.println(product.getQty());
        return arr[0].equals(product.getQty()+"");

    }
    public boolean trueName(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@itemprop='name']")));
        WebElement elem = driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String name = elem.getText().toLowerCase();
        System.out.println(name);
        return name.equals(product.getName());

    }
    public boolean truePrice(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@itemprop='price']")));
        WebElement price = driver.findElement(By.xpath("//span[@itemprop='price']"));
        String pr = price.getAttribute("content");
        pr = pr.replace('.',',');
        System.out.println(pr);
        System.err.println(product.getPrice());
        return pr.equals(product.getPrice());

    }

}
