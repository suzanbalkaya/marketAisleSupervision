package marketAisleSupervision.user.models.Dao;

import marketAisleSupervision.user.models.Entity.Task;

import java.util.List;

public interface TaskDao {
    public void createTask(Task task);
    public List<Task> adminListTask(Integer adminId);
    public List<Task> userListTask(Integer userId);
    public List<Task> getTask(Integer taskId);
    public void updateTask(Task task);
    public List<Task> getTaskHistory(Integer userId);
}