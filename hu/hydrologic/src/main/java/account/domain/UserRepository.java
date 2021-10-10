package account.domain;

public interface UserRepository {
    boolean store(User user);
    boolean update(User user);
    User get(UserID id);
}