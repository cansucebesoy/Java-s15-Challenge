import java.util.List;

public interface BookManagement {
    void updateBook(Book book);
    List<Book> findBooksByTitle(String title);
    List<Book> findBooksByAuthor(String author);
    List<Book> findBooksByCategory(String category);
    void printBooks(List<Book> bookList);
}
