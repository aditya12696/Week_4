package smartwarehousemanagement;

// Abstract class representing an item in the warehouse
public abstract class WarehouseItem {
    private String name;
    private double price;

    // Constructor to initialize item details
    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter for item name
    public String getName() {
        return name;
    }

    // Getter for item price
    public double getPrice() {
        return price;
    }

    // Override toString method to return item details
    @Override
    public String toString() {
        return getClass().getSimpleName() + " - Name: " + name + ", Price: $" + price;
    }
}
