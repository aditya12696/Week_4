package dynamicmarketplace;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import smartwarehousemanagement.Electronics;
import smartwarehousemanagement.Furniture;
import smartwarehousemanagement.Groceries;
import smartwarehousemanagement.Storage;

import java.util.List;

class WarehouseTest extends MarketplaceMain {
    private Storage<Electronics> electronicsStorage;
    private Storage<Groceries> groceriesStorage;
    private Storage<Furniture> furnitureStorage;

    @BeforeEach
    void setUp() {
        electronicsStorage = new Storage<>();
        groceriesStorage = new Storage<>();
        furnitureStorage = new Storage<>();
    }

    @Test
    void testWarehouseItemProperties() {
        Electronics laptop = new Electronics("Laptop", 1200.50);
        assertEquals("Laptop", laptop.getName());
        assertEquals(1200.50, laptop.getPrice());
        assertEquals("Electronics - Name: Laptop, Price: $1200.5", laptop.toString());

        Groceries milk = new Groceries("Milk", 3.50);
        assertEquals("Milk", milk.getName());
        assertEquals(3.50, milk.getPrice());
        assertEquals("Groceries - Name: Milk, Price: $3.5", milk.toString());

        Furniture chair = new Furniture("Chair", 150.00);
        assertEquals("Chair", chair.getName());
        assertEquals(150.00, chair.getPrice());
        assertEquals("Furniture - Name: Chair, Price: $150.0", chair.toString());
    }

    @Test
    void testStorageOperations() {
        Electronics laptop = new Electronics("Laptop", 1200.50);
        electronicsStorage.addItem(laptop);
        assertEquals(1, electronicsStorage.getItems().size());
        assertTrue(electronicsStorage.getItems().contains(laptop));

        electronicsStorage.removeItem(laptop);
        assertEquals(0, electronicsStorage.getItems().size());
    }

    @Test
    void testWarehouseUtilsDisplayItems() {
        Electronics laptop = new Electronics("Laptop", 1200.50);
        Electronics smartphone = new Electronics("Smartphone", 799.99);
        electronicsStorage.addItem(laptop);
        electronicsStorage.addItem(smartphone);

        List<Electronics> items = electronicsStorage.getItems();
        assertEquals(2, items.size());
        assertEquals("Laptop", items.get(0).getName());
        assertEquals("Smartphone", items.get(1).getName());
    }
}
