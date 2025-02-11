package smartwarehousemanagement;

// Main class to demonstrate the Smart Warehouse Management System
public class SmartWarehouseManagement {
    public static void main(String[] args) {
        // Creating storage for different item types
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Adding electronics to storage
        electronicsStorage.addItem(new Electronics("Laptop", 1200.50));
        electronicsStorage.addItem(new Electronics("Smartphone", 799.99));

        // Adding groceries to storage
        groceriesStorage.addItem(new Groceries("Milk", 3.50));
        groceriesStorage.addItem(new Groceries("Bread", 2.00));

        // Adding furniture to storage
        furnitureStorage.addItem(new Furniture("Chair", 150.00));
        furnitureStorage.addItem(new Furniture("Table", 300.00));

        // Displaying items using wildcard method
        System.out.println("Electronics in Storage:");
        WarehouseUtils.displayItems(electronicsStorage.getItems());

        System.out.println("\nGroceries in Storage:");
        WarehouseUtils.displayItems(groceriesStorage.getItems());

        System.out.println("\nFurniture in Storage:");
        WarehouseUtils.displayItems(furnitureStorage.getItems());
    }
}

