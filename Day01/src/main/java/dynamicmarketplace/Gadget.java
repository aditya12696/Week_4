package dynamicmarketplace;

// Represents a gadget product
public class Gadget extends Product<GadgetCategory> {
    public Gadget(String name, double price) {
        super(name, price, new GadgetCategory());
    }
}

