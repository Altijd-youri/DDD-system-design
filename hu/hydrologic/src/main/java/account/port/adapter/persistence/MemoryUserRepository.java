package account.port.adapter.persistence;

import account.domain.*;

import java.util.ArrayList;
import java.util.List;

public class MemoryUserRepository implements UserRepository {
    private static final List<User> users = new ArrayList<>();

    @Override
    public boolean store(User user) {
        users.add(user);
        return true;
    }

    @Override
    public boolean update(User user) {
       for (int i = 0; i < users.size(); i++){
           if (users.get(i).getID().equals(user.getID())){
               users.set(i, user);
               return true;
           }
        }
       return false;
    }

    @Override
    public User get(UserID id) {
        for (User user : users){
            if (user.getID().equals(id)){
                return user;
            }
        }
        return null;
    }
}
