package account.domain;

public interface UserRepository {
    void clear();
    boolean store(User user);
    boolean update(User user);
    User get(UserID id);
}