import java.util.List;

public interface GenericManagement<T> {
    void add(T item);
    void remove(T item);
    T findById(int id);
    List<T> findAll();
}
