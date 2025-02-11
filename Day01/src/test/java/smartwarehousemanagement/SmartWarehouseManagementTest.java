package smartwarehousemanagement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class SmartWarehouseManagementTest extends SmartWarehouseManagement{
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
    void testItemCreation() {
        Electronics laptop = new Electronics("Laptop", 1200.50);
        assertEquals("Laptop", laptop.getName());
        assertEquals(1200.50, laptop.getPrice());

        Groceries milk = new Groceries("Milk", 3.50);
        assertEquals("Milk", milk.getName());
        assertEquals(3.50, milk.getPrice());

        Furniture chair = new Furniture("Chair", 150.00);
        assertEquals("Chair", chair.getName());
        assertEquals(150.00, chair.getPrice());
    }

    @Test
    void testStorageOperations() {
        Electronics smartphone = new Electronics("Smartphone", 799.99);
        Groceries bread = new Groceries("Bread", 2.00);
        Furniture table = new Furniture("Table", 300.00);

        electronicsStorage.addItem(smartphone);
        groceriesStorage.addItem(bread);
        furnitureStorage.addItem(table);

        assertEquals(1, electronicsStorage.getItems().size());
        assertEquals(1, groceriesStorage.getItems().size());
        assertEquals(1, furnitureStorage.getItems().size());

        electronicsStorage.removeItem(smartphone);
        groceriesStorage.removeItem(bread);
        furnitureStorage.removeItem(table);

        assertEquals(0, electronicsStorage.getItems().size());
        assertEquals(0, groceriesStorage.getItems().size());
        assertEquals(0, furnitureStorage.getItems().size());
    }

    @Test
    void testWarehouseUtilsDisplay() {
        Electronics laptop = new Electronics("Laptop", 1200.50);
        Electronics smartphone = new Electronics("Smartphone", 799.99);
        electronicsStorage.addItem(laptop);
        electronicsStorage.addItem(smartphone);

        List<Electronics> electronicsList = electronicsStorage.getItems();
        assertEquals(2, electronicsList.size());

        // Capture output using a PrintStream (for advanced testing)
        System.out.println("\nElectronics in Storage:");
        WarehouseUtils.displayItems(electronicsList);
    }
}
