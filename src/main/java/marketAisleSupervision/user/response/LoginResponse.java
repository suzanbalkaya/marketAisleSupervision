package marketAisleSupervision.user.response;

import marketAisleSupervision.user.models.Entity.Task;
import marketAisleSupervision.user.models.Entity.User;

import java.util.List;

/**
 * Created by suzan on 01.11.2016.
 */
public class LoginResponse {
    private User user;
    private List<Task> taskList;

    public LoginResponse() {
    }

    public LoginResponse(User user, List<Task> taskList) {
        this.user = user;
        this.taskList = taskList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
