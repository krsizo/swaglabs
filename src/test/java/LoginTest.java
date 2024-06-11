import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginAndShoppingCart() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        // Проверяем URL страницы после входа
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/inventory.html", currentUrl, "Incorrect page URL");

        // Добавляем самый дорогой продукт в корзину
        productsPage.addToCartMostExpensiveProduct();

        // Открываем корзину и проверяем, что продукт добавлен
        shoppingCartPage.openCart();
        assertTrue(shoppingCartPage.isProductInCart(), "Product is not in the cart.");
    }
}