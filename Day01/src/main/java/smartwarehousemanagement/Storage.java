package smartwarehousemanagement;
import java.util.*;

// Generic class to store warehouse items with type safety
public class Storage<T extends WarehouseItem> {
    private List<T> items;

    // Constructor initializes an empty list
    public Storage() {
        this.items = new ArrayList<>();
    }

    // Method to add an item to the storage
    public void addItem(T item) {
        items.add(item);
    }

    // Method to remove an item from the storage
    public void removeItem(T item) {
        items.remove(item);
    }

    // Method to get all items in the storage
    public List<T> getItems() {
        return items;
    }
    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        throw new IndexOutOfBoundsException("Invalid index: " + index);
    }
    public T getItems(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        throw new IndexOutOfBoundsException("Invalid index: " + index);
    }
    // Method to display all items using wildcard
    public static void displayAllItems(List<? extends WarehouseItem> itemList) {
        for (WarehouseItem item : itemList) {
            System.out.println(item.getName());
        }
    }
}
