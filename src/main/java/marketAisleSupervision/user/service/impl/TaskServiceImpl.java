package marketAisleSupervision.user.service.impl;

import marketAisleSupervision.user.models.Dao.TaskDao;
import marketAisleSupervision.user.models.Entity.RunningTasks;
import marketAisleSupervision.user.models.Entity.Task;
import marketAisleSupervision.user.models.Enum.TaskStatusEnum;
import marketAisleSupervision.user.service.RunningTaskService;
import marketAisleSupervision.user.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
@Service("taskService")
     public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskDao taskDao;
    @Autowired
    RunningTaskService runningTaskService;

    @Override
    public void createTask(Task task) {
        task.setStatus(TaskStatusEnum.INSERTED.getValue());
        taskDao.createTask(task);
    }

    @Override
    public List<Task> adminListTask(Integer adminId) {
        return taskDao.adminListTask(adminId);
    }

    @Override
    public List<Task> userTaskList(Integer userId) {
        return taskDao.userTaskList(userId);
    }

    @Override
    public Task getTask(Integer taskId) {
        List<Task> tasks = taskDao.getTask(taskId);
        if(tasks.size()==1)
            return tasks.get(0);
        else
            return null;
    }

    @Override
    public void startedTask(RunningTasks runningTasks, Task task) {
        runningTasks.setStatus(TaskStatusEnum.STARTED.getValue());
        runningTaskService.createRunningTask(runningTasks);
        task.setStatus(TaskStatusEnum.STARTED.getValue());
        task.setUserId(runningTasks.getUserId());
        task.setModifilDate(runningTasks.getCreatedDate());
        taskDao.updateTask(task);
    }

    @Override
    public  Task finishedTask(Integer userId, Integer taskId) {
        try {
            Date input = new Date();

            LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            Task task = getTask(taskId);
            if (task.getStatus() == TaskStatusEnum.STARTED.getValue()) {
                task.setModifilDate(date.toString());
                task.setStatus(TaskStatusEnum.FINSHED.getValue());
                taskDao.updateTask(task);

                RunningTasks runningTask = runningTaskService.getTaskId(taskId);
                runningTask.setStatus(TaskStatusEnum.FINSHED.getValue());
                runningTask.setUserId(userId);
                runningTask.setCreatedDate(date.toString());
                runningTaskService.createRunningTask(runningTask);
                return task;
            }else
                throw new Exception();
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public Task canceledTask(Integer userId, Integer taskId) {
        try {
            Date input = new Date();

            LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            Task task = getTask(taskId);
            if (task.getStatus() == TaskStatusEnum.STARTED.getValue()) {
                task.setModifilDate(date.toString());
                task.setStatus(TaskStatusEnum.CANCELLED.getValue());
                taskDao.updateTask(task);

                RunningTasks runningTask = runningTaskService.getTaskId(taskId);
                runningTask.setStatus(TaskStatusEnum.CANCELLED.getValue());
                runningTask.setUserId(userId);
                runningTask.setCreatedDate(date.toString());
                runningTaskService.createRunningTask(runningTask);
                return task;
            }else
                throw new Exception();
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public Task acceptedTask(Integer userId, Integer taskId) {
        try {
            Date input = new Date();

            LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            Task task = getTask(taskId);
            if (task.getStatus() == TaskStatusEnum.FINSHED.getValue()) {
                task.setModifilDate(date.toString());
                task.setStatus(TaskStatusEnum.ACCEPTED.getValue());
                taskDao.updateTask(task);

                RunningTasks runningTask = runningTaskService.getTaskIdStatus(taskId,TaskStatusEnum.FINSHED.getValue());
                runningTask.setStatus(TaskStatusEnum.ACCEPTED.getValue());
                runningTask.setUserId(userId);
                runningTask.setCreatedDate(date.toString());
                runningTaskService.createRunningTask(runningTask);
                return task;
            }else
                throw new Exception();
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public Task notAcceptedTask(Integer userId, Integer taskId) {
        try {
            Date input = new Date();

            LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            Task task = getTask(taskId);
            if (task.getStatus() == TaskStatusEnum.FINSHED.getValue()) {
                task.setModifilDate(date.toString());
                task.setStatus(TaskStatusEnum.NOTACCEPTED.getValue());
                taskDao.updateTask(task);

                RunningTasks runningTask = runningTaskService.getTaskIdStatus(taskId,TaskStatusEnum.FINSHED.getValue());
                runningTask.setStatus(TaskStatusEnum.NOTACCEPTED.getValue());
                runningTask.setUserId(userId);
                runningTask.setCreatedDate(date.toString());
                runningTaskService.createRunningTask(runningTask);
                return task;
            }else
                throw new Exception();
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public List<Task> getTaskHistory(Integer userId) {

        return taskDao.getTaskHistory(userId);
    }

    @Override
    public List<Task> getInsertedTaskList() {
        return taskDao.getInsertedTaskList();
    }


}