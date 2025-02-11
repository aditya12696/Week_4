package dynamicmarketplace;

// Generic base class representing a product in the marketplace
public class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    // Constructor to initialize product details
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Getter for product name
    public String getName() {
        return name;
    }

    // Getter for product price
    public double getPrice() {
        return price;
    }

    // Setter for product price
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter for product category
    public T getCategory() {
        return category;
    }

    // Override toString method to return product details
    @Override
    public String toString() {
        return name + " (" + category.getCategoryName() + ") - $" + price;
    }
}
