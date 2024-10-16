import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LoanManager implements LoanManagement {
    //kitabi teslim edilmemis faturalar
    private Map<Integer, List<Invoice>>  activeInvoices;
    private InvoiceManager invoiceManager;
    private BookManager bookManager;

    public LoanManager(InvoiceManager invoiceManager, BookManager bookManager) {
        this.activeInvoices = new HashMap<>();
        this.invoiceManager = invoiceManager;
        this.bookManager = bookManager;
    }
    @Override
    public Invoice loanBook(User user, List<Book> books) {
        List<Book> loanableBooks = books.stream().filter(book -> book.getAvailable() == Boolean.TRUE).collect(Collectors.toList());
        if(loanableBooks.isEmpty()){
            return null;
        }
        List<Invoice> userInvoices = activeInvoices.getOrDefault(user.getId(), new ArrayList<>());

        int totalLoanedBooks = userInvoices.stream()
                .mapToInt(invoice -> invoice.getBooks().size())
                .sum();
        if (totalLoanedBooks + loanableBooks.size() > User.MAX_BOOK_LIMIT) {
            return null;
        }
        // Calculate the total cost for the current loanable books
        double totalCost = loanableBooks.size() * Book.LOAN_COST;

        // Check if the user has enough balance to cover the loan cost
        if (user.getBalance() < totalCost) {
            return null;  // User doesn't have enough balance to borrow these books
        }
        user.setBalance(user.getBalance() - totalCost);
        // !!! ilk invoice yaratildiginda id olarak 2 veriyor, ve nextId 3 oluyor
        Invoice invoice = invoiceManager.createInvoice(user, loanableBooks);
        if(activeInvoices.containsKey(user.getId())){
            userInvoices.add(invoice);
        } else {
            userInvoices.add(invoice);
            activeInvoices.put(user.getId(), userInvoices);
        }
        //activeInvoices.computeIfAbsent(user.getId(), k -> new ArrayList<>()).add(invoice);
        invoiceManager.add(invoice);
        loanableBooks.forEach(book -> {
            book.setAvailable(Boolean.FALSE);
            // kitaplar referans olarak paslandigindan book.setAvailble diyince
            // hafizada ayni yer guncelleniyor, bookManager'dan updateBook
            // cagrisina gerek kalmiyor.
            // bookManager.updateBook(book);
        });
        return invoice;
    }

    @Override
    public void returnBook(User user, List<Book> books) {
        if(!activeInvoices.containsKey(user.getId())){
            return;
        }
        books.forEach(book -> {
            List<Invoice> userInvoices = activeInvoices.get(user.getId());
            Optional<Invoice> invoiceWithBook = userInvoices.stream().filter(invoice -> invoice.getBooks().contains(book)).findFirst();
            if(invoiceWithBook.isPresent()){
                List<Book> listWithBook = invoiceWithBook.get().getBooks();
                listWithBook.remove(book);
                book.setAvailable(Boolean.TRUE);
                // kitaplar referans olarak paslandigindan book.setAvailble diyince
                // hafizada ayni yer guncelleniyor, bookManager'dan updateBook
                // cagrisina gerek kalmiyor.
                // bookManager.updateBook(book);
                user.setBalance(Book.LOAN_COST + user.getBalance());
                if(listWithBook.isEmpty()){
                    userInvoices.remove(invoiceWithBook.get());
                }
            }
        });
    }
}

/*
"invoice 1": ["book 1", "book 2"]
"invoice 2": ["book 3", "book 4", "book 5"]

// activeInvoices
{
    "cansu": ["invoice 1", "invoice 2"]
}

returnBook("cansu", ["book 4", "book 5", "book 3"])

// activeInvoices.get("cansu")
userInvoices = ["invoice 1", "invoice 2"]

"invoice 1" -> ["book 1", "book 2"].contains("book 4") -> FALSE
"invoice 2" -> ["book 3", "book 4", "book 5"].contains("book 5") -> TRUE

        ...stream.findFirst();
Optional<Invoice> invoiceOptional -> invoiceOptional.get()
    Invoice invoice;

if(invoiceOptional.isPresent())

    Optional<"invoice 2">.get() -> "invoice 2"
"invoice 2".getBooks() -> ["book 3", "book 4", "book 5"]

--- BOOK 4 ---
        ["book 3", "book 4", "book 5"].remove("book 4") -> ["book 3", "book 5"]
        "invoice 2".getBooks() -> ["book 3", "book 5"]

--- BOOK 5 ---
        ["book 3", "book 5"].remove("book 5") -> ["book 3"]
        "invoice 2".getBooks() -> ["book 3"]

--- BOOK 3 ---
        ["book 3"].remove("book 3") -> []
        "invoice 2".getBooks() -> []

// activeInvoices
"invoice 1": ["book 1", "book 2"]
"invoice 2": []

{
    "cansu": ["invoice 1", "invoice 2"]
}

userInvoices = ["invoice 1", "invoice 2"]
Optional<"invoice 2">

["invoice 1", "invoice 2"].remove(Optional<"invoice 2">.get())
["invoice 1", "invoice 2"].remove("invoice 2")

{
    "cansu": ["invoice 1" +
        ""]
}*/
