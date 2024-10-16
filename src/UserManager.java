import java.util.ArrayList;
import java.util.List;

public class UserManager extends GenericManager<User> implements UserManagement {

    public UserManager() {
        this.items = new ArrayList<>();
        this.nextId = 1;
    }

    @Override
    public void updateUser(User user) {
        User updatedUser = findById(user.getId());
        if(updatedUser != null){
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
        }
    }
}
