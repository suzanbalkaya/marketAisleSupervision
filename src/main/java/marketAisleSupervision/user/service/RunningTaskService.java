package marketAisleSupervision.user.service;

import marketAisleSupervision.user.models.Entity.RunningTasks;

/*
 * Created by suzan on 20.10.2016.
 */
public interface RunningTaskService {
    public RunningTasks getRunningTask(Integer runningTaskId) ;
    public RunningTasks getTaskId(Integer taskId) ;
    public void createRunningTask(RunningTasks runningTasks);
    public RunningTasks getTaskIdStatus(Integer taskId,Integer status) ;
}