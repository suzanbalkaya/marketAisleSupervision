package marketAisleSupervision.user.controllers;


import marketAisleSupervision.user.models.Entity.RunningTasks;
import marketAisleSupervision.user.models.Entity.Task;
import marketAisleSupervision.user.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/createTask", method = RequestMethod.POST)
    public ResponseEntity createTask(@RequestBody Task task) {
        try {
            taskService.createTask(task);
            return new ResponseEntity(task, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/finishedTask", method = RequestMethod.PUT)
    public ResponseEntity finishedTask(@RequestParam Integer userId, @RequestParam Integer taskId) {
        try {
            Task task = taskService.finishedTask(userId, taskId);
            if (task == null) {
                throw new Exception();
            }
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/canceledTask", method = RequestMethod.PUT)
    public ResponseEntity canceledTask(@RequestParam Integer userId, @RequestParam Integer taskId) {
        try {
            Task task = taskService.canceledTask(userId, taskId);
            if (task == null) {
                throw new Exception();
            }
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/acceptedTask", method = RequestMethod.PUT)
    public ResponseEntity acceptedTask(@RequestParam Integer userId, @RequestParam Integer taskId) {
        try {
            Task task = taskService.acceptedTask(userId, taskId);
            if (task == null) {
                throw new Exception();
            }
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "notAcceptedTask", method = RequestMethod.PUT)
    public ResponseEntity notAcceptedTask(@RequestParam Integer userId, @RequestParam Integer taskId) {
        try {
            Task task = taskService.notAcceptedTask(userId, taskId);
            if (task == null) {
                throw new Exception();
            }
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/getAdminTaskList", method = RequestMethod.GET)
    public ResponseEntity getAdminTaskList(@RequestParam Integer adminId) {
        try {
            return new ResponseEntity(taskService.adminListTask(adminId), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/getUserTaskList", method = RequestMethod.GET)
    public ResponseEntity getUserTaskList(@RequestParam Integer userId) {
        try {
            return new ResponseEntity(taskService.userTaskList(userId), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/getTask", method = RequestMethod.GET)
    public ResponseEntity getTask(@RequestParam Integer taskId) {
        try {
            return new ResponseEntity(taskService.getTask(taskId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/startedTask", method = RequestMethod.POST)
    public ResponseEntity startedTask(@RequestBody RunningTasks runningTasks) {
        try {
            Task task = taskService.getTask(runningTasks.getTaskId());
            taskService.startedTask(runningTasks, task);
            return new ResponseEntity(runningTasks, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value="/getInsertedTaskList",method = RequestMethod.GET)
    public ResponseEntity getInsertedTaskList(){
        try{
            return new ResponseEntity(taskService.getInsertedTaskList(),HttpStatus.OK);

        }catch (Exception ex){
            return new ResponseEntity((HttpStatus.NOT_FOUND));
        }
    }
}
