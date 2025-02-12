package shoppingcartsystem;
import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices;      // Stores product prices
    private LinkedHashMap<String, Integer> cart;    // Maintains insertion order
    private Map<String, Double> sortedCart;         // TreeMap to sort by price

    public ShoppingCart() {
        productPrices = new HashMap<>();
        cart = new LinkedHashMap<>();
        sortedCart = new TreeMap<>(Comparator.comparing(productPrices::get));
    }

    // Add product and price to store
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    // Add product to cart
    public void addToCart(String product, int quantity) {
        if (!productPrices.containsKey(product)) {
            System.out.println("Product not available!");
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
        updateSortedCart();
    }

    // Display cart in order of items added
    public void displayCartInOrder() {
        System.out.println("Cart (Order of Addition):");
        cart.forEach((product, quantity) ->
                System.out.println(product + " -> " + quantity + " units"));
    }

    // Display cart sorted by product price
    public void displayCartSortedByPrice() {
        System.out.println("Cart (Sorted by Price):");
        sortedCart.forEach((product, price) ->
                System.out.println(product + " -> $" + price));
    }

    // Calculate total price
    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }

    // Update sorted cart when items are added
    private void updateSortedCart() {
        sortedCart.clear();
        for (String product : cart.keySet()) {
            sortedCart.put(product, productPrices.get(product));
        }
    }
    public Map<String, Double> getProductPrices() {
        return new HashMap<>(productPrices);
    }

    public LinkedHashMap<String, Integer> getCart() {
        return new LinkedHashMap<>(cart);
    }

    public TreeMap<String, Double> getSortedCart() {
        return new TreeMap<>(sortedCart);
    }
}
