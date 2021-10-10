package account.domain;

public interface UserRepository {
    public void store(User user);
    public User getUser(String id);
}