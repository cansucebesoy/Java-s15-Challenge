import java.util.List;

public interface InvoiceManagement {
    void updateInvoice(Invoice invoice);
    Invoice createInvoice(User user, List<Book> books);
}
