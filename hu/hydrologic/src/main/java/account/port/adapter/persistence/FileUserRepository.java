package account.port.adapter.persistence;

import account.domain.User;
import account.domain.UserID;
import account.domain.UserRepository;

public class FileUserRepository implements UserRepository {
    public boolean store(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User get(UserID id) {
        return null;
    }

    public User getUser(String id) {
        return null;
    }
}