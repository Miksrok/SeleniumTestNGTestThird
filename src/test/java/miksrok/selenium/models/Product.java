package miksrok.selenium.models;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Random;

/**
 * Created by Залізний Мозок on 17.04.2017.
 */
public class Product {

    private String name;
    private int qty;
    private double price;

    public Product(String name, int qty, double price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public String getPrice() {
        DecimalFormatSymbols separators = new DecimalFormatSymbols();
        separators.setDecimalSeparator(',');
        return new DecimalFormat("#0.00", separators).format(price);
    }

    public static Product generate (){

        Random random = new Random();
        return new Product(
                "new product " + System.currentTimeMillis(),
                random.nextInt(100) + 1,
                (double)Math.round(random.nextInt(100_00) + 1) / 100
        );

    }


}
