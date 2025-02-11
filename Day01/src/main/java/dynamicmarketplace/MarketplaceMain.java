package dynamicmarketplace;

// Main class to demonstrate the Online Marketplace
public class MarketplaceMain {
    public static void main(String[] args) {
        // Creating product catalogs
        ProductCatalog<Book> bookCatalog = new ProductCatalog<>();
        ProductCatalog<Clothing> clothingCatalog = new ProductCatalog<>();
        ProductCatalog<Gadget> gadgetCatalog = new ProductCatalog<>();

        // Adding books to the catalog
        Book book1 = new Book("The Alchemist", 15.99);
        Book book2 = new Book("Clean Code", 39.99);
        bookCatalog.addProduct(book1);
        bookCatalog.addProduct(book2);

        // Adding clothing items to the catalog
        Clothing clothing1 = new Clothing("T-Shirt", 25.00);
        Clothing clothing2 = new Clothing("Jeans", 49.99);
        clothingCatalog.addProduct(clothing1);
        clothingCatalog.addProduct(clothing2);

        // Adding gadgets to the catalog
        Gadget gadget1 = new Gadget("Smartphone", 699.99);
        Gadget gadget2 = new Gadget("Laptop", 1199.99);
        gadgetCatalog.addProduct(gadget1);
        gadgetCatalog.addProduct(gadget2);

        // Display products before discount
        System.out.println("Books in Catalog:");
        for (Book book : bookCatalog.getProducts()) {
            System.out.println(book);
        }

        System.out.println("\nClothing in Catalog:");
        for (Clothing clothing : clothingCatalog.getProducts()) {
            System.out.println(clothing);
        }

        System.out.println("\nGadgets in Catalog:");
        for (Gadget gadget : gadgetCatalog.getProducts()) {
            System.out.println(gadget);
        }

        // Applying discounts
        System.out.println("\nApplying Discounts:");
        MarketplaceUtils.applyDiscount(book1, 10);
        MarketplaceUtils.applyDiscount(clothing1, 15);
        MarketplaceUtils.applyDiscount(gadget1, 20);
    }
}

