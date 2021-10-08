package hydrologic.src.main.java.account.port.adapter.persistence;

import hydrologic.src.main.java.account.domain.User;
import hydrologic.src.main.java.account.domain.UserRepository;

public class FileUserRepository implements UserRepository {
    public void store(User user) {
        
    }

    public User getUser(String id) {
        return null;
    }
}