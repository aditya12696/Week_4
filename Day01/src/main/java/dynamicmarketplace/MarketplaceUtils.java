package dynamicmarketplace;

// Utility class to apply discounts to products
public class MarketplaceUtils {
    // Generic method to apply a discount
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
        System.out.println("Discount applied! New price of " + product.getName() + " is $" + product.getPrice());
    }
}
