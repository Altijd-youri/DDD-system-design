package account.port.adapter.persistence;

import account.domain.*;

import java.util.ArrayList;
import java.util.List;

public class MemoryUserRepository implements UserRepository {
    private static final List<User> users = new ArrayList<>();

    @Override
    public boolean store(User user) {
        for (User existUser : users) {
            if (existUser.getID().equals(user.getID())) {
                return false;
            }
        }
        users.add(user);
        return true;
    }

    @Override
    public boolean update(User user) {
        for (User u : users) {
            if (u.getID().toString().equals(user.getID().toString())) {
                users.remove(user);
                users.add(user);
                return true;
            }
        }
        return false;
    }

    @Override
    public User get(UserID id) {
        for (User u : users){
            if (u.getID().toString().equals(id.toString())){
                return u;
            }
        }
        return null;
    }
}
