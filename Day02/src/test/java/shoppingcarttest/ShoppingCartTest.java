package shoppingcarttest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shoppingcartsystem.ShoppingCart;

import java.util.*;

class ShoppingCartTest {
    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCart();
        shoppingCart.addProduct("Laptop", 800.0);
        shoppingCart.addProduct("Phone", 500.0);
        shoppingCart.addProduct("Headphones", 150.0);
        shoppingCart.addProduct("Mouse", 30.0);
        shoppingCart.addProduct("Keyboard", 50.0);
    }

    @Test
    void testAddProduct() {
        shoppingCart.addProduct("Tablet", 300.0);
        shoppingCart.addToCart("Tablet", 1);
        assertEquals(300.0, shoppingCart.getProductPrices().get("Tablet"));
    }

    @Test
    void testAddToCart() {
        shoppingCart.addToCart("Laptop", 1);
        shoppingCart.addToCart("Phone", 2);

        LinkedHashMap<String, Integer> expectedCart = new LinkedHashMap<>();
        expectedCart.put("Laptop", 1);
        expectedCart.put("Phone", 2);

        assertEquals(expectedCart.keySet(), shoppingCart.getCart().keySet());
        assertEquals(expectedCart.values(), shoppingCart.getCart().values());
    }

    @Test
    void testTotalPriceCalculation() {
        shoppingCart.addToCart("Laptop", 1);
        shoppingCart.addToCart("Mouse", 2);
        shoppingCart.addToCart("Keyboard", 1);

        double expectedTotal = (800.0 * 1) + (30.0 * 2) + (50.0 * 1);
        assertEquals(expectedTotal, shoppingCart.getTotalPrice());
    }

    @Test
    void testCartSortedByPrice() {
        shoppingCart.addToCart("Phone", 1);
        shoppingCart.addToCart("Mouse", 1);
        shoppingCart.addToCart("Headphones", 1);

        TreeMap<String, Double> expectedSortedCart = new TreeMap<>(Comparator.comparing(shoppingCart.getProductPrices()::get));
        expectedSortedCart.put("Phone", 500.0);
        expectedSortedCart.put("Mouse", 30.0);
        expectedSortedCart.put("Headphones", 150.0);

        assertEquals(expectedSortedCart.keySet(), shoppingCart.getSortedCart().keySet());
        assertEquals(expectedSortedCart.values(), shoppingCart.getSortedCart().values());
    }
}
