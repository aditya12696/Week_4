package dynamicmarketplace;

// Represents a clothing product
public class Clothing extends Product<ClothingCategory> {
    public Clothing(String name, double price) {
        super(name, price, new ClothingCategory());
    }
}

