package dynamicmarketplace;

// Represents a book product
public class Book extends Product<BookCategory> {
    public Book(String name, double price) {
        super(name, price, new BookCategory());
    }
}
