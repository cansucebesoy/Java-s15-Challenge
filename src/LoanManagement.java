import java.util.List;

public interface LoanManagement {
    Invoice loanBook(User user, List<Book> books);
    void returnBook(User user, List<Book> books);
}
