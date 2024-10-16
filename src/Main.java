import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//5 6 ve 7. methodlar calismiyo
public class Main {
    public static void main(String[] args) {

        /*fillBooks(bookManager);
        fillUsers(userManager);
        userManager.findUserById(1);

        User user = userManager.findUserById(1);
        Book book =bookManager.findBookById(1);
        Book book1 =bookManager.findBookById(2);
        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book1);

        loanManager.loanBook(user, books);
        bookManager.findAll();

        loanManager.returnBook(user, List.of(book, book1));
        loanManager.loanBook(user, List.of(bookManager.findBookById(3)));*/

        BookManager bookManager = new BookManager();
        UserManager userManager = new UserManager();
        InvoiceManager invoiceManager = new InvoiceManager();
        LoanManager loanManager = new LoanManager(invoiceManager, bookManager);
        Scanner scanner = new Scanner(System.in);


        bookManager.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", Category.DRAMA.getDisplayName()));
        bookManager.add(new Book("Dune", "Frank Herbert", Category.SCIENCEFICTION.getDisplayName()));
        bookManager.add(new Book("It", "Stephen King", Category.HORROR.getDisplayName()));
        bookManager.add(new Book("The Hobbit", "J.R.R. Tolkien", Category.FANTASY.getDisplayName()));
        bookManager.add(new Book("Pride and Prejudice", "Jane Austen", Category.ROMANCE.getDisplayName()));
        bookManager.add(new Book("The Girl with the Dragon Tattoo", "Stieg Larsson", Category.CRIMEFICTION.getDisplayName()));
        bookManager.add(new Book("Java Programming", "John Doe", Category.DRAMA.getDisplayName())); // Mevcut bir kategori
        bookManager.add(new Book("Effective Java", "Joshua Bloch", Category.DRAMA.getDisplayName())); // Mevcut bir kategori
        bookManager.add(new Book("Design Patterns", "Erich Gamma", Category.DRAMA.getDisplayName())); // Mevcut bir kategori
        bookManager.add(new Book("Clean Code", "Robert C. Martin", Category.DRAMA.getDisplayName())); // Mevcut bir kategori
        bookManager.add(new Book("The Pragmatic Programmer", "Andrew Hunt", Category.DRAMA.getDisplayName())); // Mevcut bir kategori
        bookManager.add(new Book("Introduction to Algorithms", "Thomas H. Cormen", Category.DRAMA.getDisplayName())); // Mevcut bir kategori
        bookManager.add(new Book("You Don't Know JS", "Kyle Simpson", Category.DRAMA.getDisplayName())); // Mevcut bir kategori
        bookManager.add(new Book("The Mythical Man-Month", "Frederick P. Brooks Jr.", Category.DRAMA.getDisplayName())); // Mevcut bir kategori
        bookManager.add(new Book("Code Complete", "Steve McConnell", Category.DRAMA.getDisplayName())); // Mevcut bir kategori
        bookManager.add(new Book("The Art of Computer Programming", "Donald Knuth", Category.DRAMA.getDisplayName())); // Mevcut bir kategori
        bookManager.add(new Book("Artificial Intelligence: A Modern Approach", "Stuart Russell", Category.DRAMA.getDisplayName())); // Mevcut bir kategori
        bookManager.add(new Book("Python Crash Course", "Eric Matthes", Category.DRAMA.getDisplayName())); // Mevcut bir kategori
        bookManager.add(new Book("Learning React", "Alex Banks", Category.DRAMA.getDisplayName())); // Mevcut bir kategori
        bookManager.add(new Book("JavaScript: The Good Parts", "Douglas Crockford", Category.DRAMA.getDisplayName())); // Mevcut bir kategori
        bookManager.add(new Book("cansu", "cansu", Category.DRAMA.getDisplayName())); // Mevcut bir kategori



        userManager.add(new User("Alice", "Smith", 50.0));
        userManager.add(new User("Bob", "Johnson", 30.0));
        userManager.add(new User("Charlie", "Brown", 20.0));
        userManager.add(new User("David", "Williams", 15.0));
        userManager.add(new User("Eva", "Jones", 25.0));



        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Update Book Information");
            System.out.println("4. Search Book by ID");
            System.out.println("5. Search Book by Title");
            System.out.println("6. List All Books by Author");
            System.out.println("7. List All Books in Category");
            System.out.println("8. List All Books");
            System.out.println("9. Borrow Book");
            System.out.println("10. Return Book");
            System.out.println("11. View User Information");
            System.out.println("12. Add User");
            System.out.println("13. Remove User");
            System.out.println("14. Find User by ID");
            System.out.println("15. Update User Information");
            System.out.println("16. Exit");
            System.out.print("Make your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer
            switch(choice){
                case 1: //Add Book
                    System.out.println("Book Title: ");
                    String title = scanner.nextLine();
                    System.out.println("Author: ");
                    String author = scanner.nextLine();
                    System.out.println("Category:");
                    String category = scanner.nextLine();
                    Book book = new Book(title, author, category);
                    bookManager.add(book);
                    System.out.println("Book added succesfully.");
                    break;

                case 2: //Remove Book
                    System.out.println("Enter the ID of the book to remove: ");
                    int removeId= scanner.nextInt();
                    Book bookToRemove = bookManager.findById(removeId);
                    if(bookToRemove != null){
                        bookManager.remove(bookToRemove);
                        System.out.println("Book removed successfully." + bookToRemove);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;


                case 3: //Update Book Information
                    System.out.print("Enter the ID of the book to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    Book updateBook = bookManager.findById(updateId);
                    if(updateBook != null){
                        System.out.print("New Title: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("New Author: ");
                        String newAuthor = scanner.nextLine();
                        System.out.print("New Category: ");
                        String newCategory = scanner.nextLine();
                        updateBook.setTitle(newTitle);
                        updateBook.setAuthor(newAuthor);
                        updateBook.setCategory(newCategory);
                        System.out.println("Book updated successfully.");
                    }else{
                        System.out.println("Book not found.");
                    }
                    break;

                case 4: //Search book by id
                    System.out.print("Enter the id of the book to search: ");
                    int searchId = scanner.nextInt();
                    Book searchedBook = bookManager.findById(searchId);
                    if(searchedBook != null){
                        System.out.println(searchedBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5: // Search Book by Title
                    System.out.print("Enter the title of the book to search: ");
                    String searchTitle = scanner.nextLine();
                    List<Book> booksByTitle = bookManager.findBooksByTitle(searchTitle);
                    bookManager.printBooks(booksByTitle);
                    break;

                case 6: // List All Books by Author
                    System.out.print("Enter the author's name: ");
                    String searchAuthor = scanner.nextLine();
                    List<Book> booksByAuthor = bookManager.findBooksByAuthor(searchAuthor);
                    bookManager.printBooks(booksByAuthor);
                    break;

                case 7: // List All Books in Category
                    System.out.print("Enter the category: ");
                    String searchCategory = scanner.nextLine();
                    List<Book> booksByCategory = bookManager.findBooksByCategory(searchCategory);
                    bookManager.printBooks(booksByCategory);
                    break;

                case 8: // List All Books
                    List<Book> allBooks = bookManager.findAll();
                    bookManager.printBooks(allBooks);
                    break;

                case 9: // Borrow Book (Loan Book)
                    System.out.print("Enter user ID to borrow books: ");
                    int userIdForLoan = scanner.nextInt();
                    scanner.nextLine();  // consume newline

                    User userForLoan = userManager.findById(userIdForLoan);
                    if (userForLoan == null) {
                        System.out.println("User not found.");
                        break;
                    }

                    System.out.print("Enter the number of books to borrow: ");
                    int numBooksToBorrow = scanner.nextInt();
                    scanner.nextLine();  // consume newline

                    List<Book> booksToBorrow = new ArrayList<>();
                    for (int i = 0; i < numBooksToBorrow; i++) {
                        System.out.print("Enter the ID of book " + (i + 1) + ": ");
                        int bookId = scanner.nextInt();
                        scanner.nextLine();  // consume newline
                        Book idWithBook = bookManager.findById(bookId);
                        if (idWithBook != null && idWithBook.getAvailable()) {
                            booksToBorrow.add(idWithBook);
                        } else {
                            System.out.println("Book with ID " + bookId + " is not available for loan.");
                        }
                    }

                    Invoice invoice = loanManager.loanBook(userForLoan, booksToBorrow);
                    if (invoice == null) {
                        System.out.println("Could not loan books. Check user's balance or book availability.");
                    } else {
                        System.out.println("Books successfully loaned. Invoice: " + invoice);
                    }
                    break;

                case 10: // Return Book
                    System.out.print("Enter user ID to return books: ");
                    int userIdForReturn = scanner.nextInt();
                    scanner.nextLine();  // consume newline

                    User userForReturn = userManager.findById(userIdForReturn);
                    if (userForReturn == null) {
                        System.out.println("User not found.");
                        break;
                    }
                    System.out.print("Enter the number of books to return: ");
                    int numBooksToReturn = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    List<Book> booksToReturn = new ArrayList<>();
                    for (int i = 0; i < numBooksToReturn; i++) {
                        System.out.print("Enter the ID of book " + (i + 1) + ": ");
                        int bookId = scanner.nextInt();
                        scanner.nextLine();  // consume newline
                        Book foundBook = bookManager.findById(bookId); // book değişkenini foundBook olarak değiştir
                        if (foundBook != null && !foundBook.getAvailable()) {
                            booksToReturn.add(foundBook);
                        } else {
                            System.out.println("Book with ID " + bookId + " is not loaned out.");
                        }
                    }
                    loanManager.returnBook(userForReturn, booksToReturn);
                    System.out.println("Books successfully returned. " + booksToReturn);
                    break;


                case 11: // View User Information
                    System.out.print("Enter User ID: ");
                    int viewUserId = scanner.nextInt();
                    User user = userManager.findById(viewUserId);
                    if (user != null) {
                        System.out.println(user);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 12:
                    // Add User
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.next();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.next();
                    System.out.print("Enter Balance: ");
                    Double balance = scanner.nextDouble();

                    User newUser = new User(firstName, lastName, balance);
                    userManager.add(newUser);
                    System.out.println("User added: " + newUser);
                    break;


                case 13:
                    // Remove User
                    System.out.print("Enter User ID to remove: ");
                    int userIdToRemove = scanner.nextInt();
                    User userToRemove = userManager.findById(userIdToRemove);
                    if (userToRemove != null) {
                        userManager.remove(userToRemove);
                        System.out.println("User removed: " + userToRemove);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 14:
                    // Find User by ID
                    System.out.print("Enter User ID: ");
                    int userIdToFind = scanner.nextInt();
                    User foundUser = userManager.findById(userIdToFind);
                    if (foundUser != null) {
                        System.out.println("User found: " + foundUser);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 15:
                    // Update User Info
                    System.out.print("Enter User ID to update: ");
                    int userIdToUpdate = scanner.nextInt();
                    User userToUpdate = userManager.findById(userIdToUpdate);
                    if (userToUpdate != null) {
                        System.out.print("Enter new First Name: ");
                        String newFirstName = scanner.next();
                        System.out.print("Enter new Last Name: ");
                        String newLastName = scanner.next();

                        userToUpdate.setFirstName(newFirstName);
                        userToUpdate.setLastName(newLastName);
                        userManager.updateUser(userToUpdate);
                        System.out.println("User updated: " + userToUpdate);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 16: // Exit
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while(choice != 16);

        scanner.close();
    }

   /* private static void fillBooks(BookManager bookManager){
        Book book = new Book("cansu", "cansu", Category.DRAMA.getDisplayName());
        Book book1 = new Book( "berke", "berke", Category.DRAMA.getDisplayName());
        Book book2 = new Book( "cadi", "cadi", Category.DRAMA.getDisplayName());
        Book book3 = new Book( "sude", "sude", Category.DRAMA.getDisplayName());

        bookManager.add(book);
        bookManager.add(book1);
        bookManager.add(book2);
        bookManager.add(book3);
    }
    private static void fillUsers(UserManager userManager){
        User user = new User("cansu", "cebesoy", 5.0);
        User user1 = new User("berke", "tinas", 5.0);
        User user2 = new User("sude", "cebesoy", 5.0);
        User user3 = new User("cadi", "cebesoy", 5.0);

        userManager.add(user);
        userManager.add(user1);
        userManager.add(user2);
        userManager.add(user3);
    }*/

}