package marketAisleSupervision.user.models.Dao;

import marketAisleSupervision.user.models.Entity.User;

import java.io.Serializable;
import java.util.List;


public interface UserDao {
    public List<User> loginEmail(String email,String password);
    public List<User> loginUserName(String name, String password);

    public void save(User user) ;

    public void delete(User user);

    public List<User> getAll() ;

    public void update(User user) ;

    public User getUser(int userId);
}
