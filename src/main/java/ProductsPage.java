import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getProducts() {
        return driver.findElements(By.className("inventory_item"));
    }

    public WebElement findMostExpensiveProduct() {
        List<WebElement> products = getProducts();
        WebElement mostExpensiveProduct = null;
        double maxPrice = 0;

        for (WebElement product : products) {
            WebElement priceElement = product.findElement(By.className("inventory_item_price"));
            double price = Double.parseDouble(priceElement.getText().replace("$", ""));
            if (price > maxPrice) {
                maxPrice = price;
                mostExpensiveProduct = product;
            }
        }
        return mostExpensiveProduct;
    }

    public void addToCartMostExpensiveProduct() {
        WebElement mostExpensiveProduct = findMostExpensiveProduct();
        if (mostExpensiveProduct != null) {
            WebElement addToCartButton = mostExpensiveProduct.findElement(By.tagName("button"));
            addToCartButton.click();
        } else {
            throw new RuntimeException("No products found.");
        }
    }
}