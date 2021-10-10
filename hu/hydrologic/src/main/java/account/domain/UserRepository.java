package account.domain;

public interface UserRepository {
    void store(User user);
    User getUser(String id);
}