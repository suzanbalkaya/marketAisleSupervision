package marketAisleSupervision.user.service;

import marketAisleSupervision.user.models.Entity.Task;
import marketAisleSupervision.user.models.Entity.User;
import marketAisleSupervision.user.response.LoginResponse;

import java.io.Serializable;
import java.util.List;


public interface UserService {
    public LoginResponse login(String userEmailOrUserName, String password);

    public void save(User userEntity) ;

    public void delete(User userEntity);

    public List<User> getAll() ;

    public void update(User userEntity) ;

    public User getUser(int userId);
    public List<Task> getTaskHistory(int userId);
}
