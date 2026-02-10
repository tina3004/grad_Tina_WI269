public interface UserDAOInterface {
    User getUserByName(String name);

    void addOwner(User user);

    void updateOwner(User user);

    void deleteOwner(int userId);
}
