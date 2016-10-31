package marketAisleSupervision.user.service.impl;

import marketAisleSupervision.user.models.Dao.RunningTasksDao;
import marketAisleSupervision.user.models.Entity.RunningTasks;
import marketAisleSupervision.user.models.Entity.Task;
import marketAisleSupervision.user.service.RunningTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by suzan on 20.10.2016
 */
@Service("runningTaskService")
public class RunningTaskServiceImpl implements RunningTaskService{

    @Autowired
    RunningTasksDao runningTasksDao;
    @Override
    public RunningTasks getRunningTask(Integer runningTaskId) {
        List<RunningTasks> runningTask = runningTasksDao.getRunningTask(runningTaskId);
        if(runningTask.size()==1)
            return runningTask.get(0);
        else
            return null;

    }

    @Override
    public RunningTasks getTaskId(Integer taskId) {
        List<RunningTasks> runningTask = runningTasksDao.getTaskId(taskId);
        if(runningTask.size()==1)
            return runningTask.get(0);
        else
            return null;
    }


    @Override
    public void createRunningTask(RunningTasks runningTasks) {
        runningTasksDao.create(runningTasks);
    }

    @Override
    public RunningTasks getTaskIdStatus(Integer taskId,Integer status) {
        List<RunningTasks> runningTask = runningTasksDao.getTaskIdStatus(taskId,status);
        if(runningTask.size()==1)
            return runningTask.get(0);
        else
            return null;
    }
}
