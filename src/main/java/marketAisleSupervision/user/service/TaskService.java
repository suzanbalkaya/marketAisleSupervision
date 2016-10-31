package marketAisleSupervision.user.service;


import marketAisleSupervision.user.models.Entity.RunningTasks;
import marketAisleSupervision.user.models.Entity.Task;

import java.util.List;

public interface TaskService {
    public void createTask(Task task);
    public List<Task> adminListTask(Integer adminId);
    public List<Task> userListTask(Integer userId);
    public Task getTask(Integer taskId);
    public void startedTask(RunningTasks runningTasks, Task task);
    public Task  finishedTask(Integer userId,Integer taskId);
    public Task  canceledTask(Integer userId,Integer taskId);
    public Task  acceptedTask(Integer userId,Integer taskId);
    public Task  notAcceptedTask(Integer userId,Integer taskId);
    public  List<Task> getTaskHistory(Integer userId);

}