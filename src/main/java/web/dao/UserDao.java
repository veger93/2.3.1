package web.dao;
import web.model.User;
import java.util.List;

public interface UserDao {
    List<User> allUser();
    User getById(int id);
    void add(User user);
    void delete(int id);
    void edit(User user);
}
