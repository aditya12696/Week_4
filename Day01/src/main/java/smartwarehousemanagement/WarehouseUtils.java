package smartwarehousemanagement;

import java.util.List;

// Utility class to perform warehouse-related operations
public class WarehouseUtils {
    // Method to display all warehouse items using wildcards
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}