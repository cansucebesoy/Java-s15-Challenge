import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class InvoiceManager extends GenericManager<Invoice> implements InvoiceManagement {

    public InvoiceManager() {
        this.items = new ArrayList<>();
        this.nextId = 1;
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        Invoice updatedInvoice = findById(invoice.getId());
        if(updatedInvoice != null){
            updatedInvoice.setBooks(invoice.getBooks());
            updatedInvoice.setUser(invoice.getUser());
            updatedInvoice.setLoanDate(invoice.getLoanDate());
        }
    }

    @Override
    public Invoice createInvoice(User user, List<Book> books) {
        return new Invoice(user,books,new Date(), nextId++);
    }

    /*@Override
    public void viewInvoice() {

    }


    @Override
    public void calculateLateFee() {

    }*/

}
