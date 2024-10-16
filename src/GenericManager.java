import java.util.ArrayList;
import java.util.List;

public abstract class GenericManager<T extends Identifiable> implements GenericManagement<T> {

    protected List<T> items = new ArrayList<>();
    protected int nextId = 1;

    @Override
    public void add(T item) {
        if(item.getId() == null){
            item.setId(nextId++);
        }
        items.add(item);
    }

    @Override
    public void remove(T item) {
        items.removeIf(existingItem -> existingItem.getId().equals(item.getId()));
    }

    @Override
    public T findById(int id) {
        for(T item : items){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }

    @Override
    public List<T> findAll(){
        return new ArrayList<>(items);
    }
}
