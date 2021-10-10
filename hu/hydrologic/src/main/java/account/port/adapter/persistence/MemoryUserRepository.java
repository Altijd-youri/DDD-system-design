package account.port.adapter.persistence;

import account.domain.*;

import java.util.ArrayList;
import java.util.List;

public class MemoryUserRepository implements UserRepository {
    private List<User> users = new ArrayList<>();


    @Override
    public void store(User user) {
        users.add(user);
    }

    @Override
    public void update(User user) {
       for (User u : users){
           if (user.getUserID().equals(u.getUserID())){
               u = user;
           }
        }
    }

    @Override
    public User getUser(String id) {
//        UserID userID = new UserID(id);
//        Email email = new Email("jhon@live.nl");
//        User user = new User(userID,email, Role.User,"jhon","Doe");
        return null;
    }
}
