import java.util.ArrayList;
import java.util.List;

public class BookManager extends GenericManager<Book> implements BookManagement {

    public BookManager(){
        this.items = new ArrayList<>();
        this.nextId=1;
    }

    @Override
    public void updateBook(Book book) {
        Book updatedBook = findById(book.getId());
        if(updatedBook != null){
            updatedBook.setTitle(book.getTitle());
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setCategory(book.getCategory());
            updatedBook.setAvailable(book.getAvailable());
        }
    }

    /*public List<Book> findAll() {
        return this.items;
    }*/

    @Override
    public List<Book> findBooksByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for(Book book : items){
            if(book.getTitle().equalsIgnoreCase(title)){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for(Book book : items){
            if(book.getAuthor().equalsIgnoreCase(author)){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public List<Book> findBooksByCategory(String category) {
        List<Book> foundBook = new ArrayList<>();
        for(Book book: items){
            if(book.getCategory().equalsIgnoreCase(category)){
                foundBook.add(book);
            }
        }
        return foundBook;
    }
    @Override
    public void printBooks(List<Book> bookList) {
        if(bookList.isEmpty()){
            System.out.println("No books available");
        } else{
            System.out.println("List of books: ");
            for(Book book : bookList){
                System.out.println(book);
            }
        }
    }

    //List<Book> booksByCategory = bookManager.findBooksByCategory("drama");
    //bookManager.printBooks(booksByCategory);
    //List<Book> booksByAuthor = bookManager.findByAuthor("cansu");
    //bookManager.printBooks(booksByAuthor);
}
