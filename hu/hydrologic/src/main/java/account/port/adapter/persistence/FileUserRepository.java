package account.port.adapter.persistence;

import account.domain.User;
import account.domain.UserRepository;

public class FileUserRepository implements UserRepository {
    @Override
    public void store(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public User getUser(String id) {
        return null;
    }
}