package shoppingcartsystem;

public class ShoppingCartMain {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        // Adding products to store
        shoppingCart.addProduct("Laptop", 800.0);
        shoppingCart.addProduct("Phone", 500.0);
        shoppingCart.addProduct("Headphones", 150.0);
        shoppingCart.addProduct("Mouse", 30.0);
        shoppingCart.addProduct("Keyboard", 50.0);

        // Adding items to cart
        shoppingCart.addToCart("Laptop", 1);
        shoppingCart.addToCart("Phone", 2);
        shoppingCart.addToCart("Mouse", 1);
        shoppingCart.addToCart("Keyboard", 1);
        shoppingCart.addToCart("Headphones", 1);

        // Display cart in order of addition
        System.out.println("\n=== Shopping Cart Order ===");
        shoppingCart.displayCartInOrder();

        // Display cart sorted by product price
        System.out.println("\n=== Shopping Cart Sorted by Price ===");
        shoppingCart.displayCartSortedByPrice();

        // Display total price
        System.out.println("\n=== Total Price ===");
        System.out.println("Total Cost: $" + shoppingCart.getTotalPrice());
    }
}
