import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage {
    private WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCart() {
        WebElement shoppingCart = driver.findElement(By.id("shopping_cart_container"));
        shoppingCart.click();
    }

    public List<WebElement> getCartItems() {
        WebElement cartList = driver.findElement(By.className("cart_list"));
        return cartList.findElements(By.className("cart_item"));
    }

    public boolean isProductInCart() {
        return !getCartItems().isEmpty();
    }
}