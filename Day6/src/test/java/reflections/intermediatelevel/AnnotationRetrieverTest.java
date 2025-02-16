package reflections.intermediatelevel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import reflections.intermediatelevel.retrieveannotation.Author;
import reflections.intermediatelevel.retrieveannotation.Book;

class AnnotationRetrieverTest {

    @Test
    void testAuthorAnnotation() {

        Class<Book> bookClass = Book.class;


        assertTrue(bookClass.isAnnotationPresent(Author.class), "Book class should have @Author annotation");


        Author author = bookClass.getAnnotation(Author.class);


        assertEquals("Johan", author.name(), "Author name should be 'Anand'");
    }
}
