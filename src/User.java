import java.util.Objects;

public class User implements Identifiable {

    private String firstName;
    private String lastName;
    private Integer id;
    private Double balance;
    public static final int MAX_BOOK_LIMIT = 5;


    public User(String firstName, String lastName, Double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance =balance;
    }

    public User(Integer id){
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id + '\'' +
                ", balance=" + balance +
                '}';
    }


}





