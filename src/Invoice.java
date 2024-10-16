
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Invoice implements Identifiable {

    private User user;
    private List<Book> books;
    private Date loanDate;
    private Integer id;

    public Invoice(User user, List<Book> books,Date loanDate, Integer id) {
        this.user = user;
        this.books = books;
        this.loanDate = loanDate;
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }
    @Override
    public Integer getId() {
        return id;
    }
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(id, invoice.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "user=" + user +
                ", books=" + books +
                ", loanDate=" + loanDate +
                ", id=" + id +
                '}';
    }
}
