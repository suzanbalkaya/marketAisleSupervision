package marketAisleSupervision.user.models.Dao;


import marketAisleSupervision.user.models.Entity.RunningTasks;

import java.util.List;

public interface RunningTasksDao {
    public void create(RunningTasks runningTasks);
    public List<RunningTasks> getRunningTask(Integer runningTaskId);
    public List<RunningTasks> getTaskId(Integer taskId);
    public List<RunningTasks> getTaskIdStatus(Integer taskId,Integer status);
}
