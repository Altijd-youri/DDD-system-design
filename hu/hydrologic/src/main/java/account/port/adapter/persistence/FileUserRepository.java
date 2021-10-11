package account.port.adapter.persistence;

import account.domain.User;
import account.domain.UserRepository;

public class FileUserRepository implements UserRepository {
    public void store(User user) {

    }

    @Override
    public void update(User user) {

    }

    public User getUser(String id) {
        return null;
    }
}