package dynamicmarketplace;

import java.util.ArrayList;
import java.util.List;

// Generic class representing a product catalog
public class ProductCatalog<T extends Product<?>> {
    private List<T> products;

    // Constructor initializes an empty product list
    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    // Method to add a product to the catalog
    public void addProduct(T product) {
        products.add(product);
    }

    // Method to remove a product from the catalog
    public void removeProduct(T product) {
        products.remove(product);
    }

    // Method to get all products in the catalog
    public List<T> getProducts() {
        return products;
    }
}

