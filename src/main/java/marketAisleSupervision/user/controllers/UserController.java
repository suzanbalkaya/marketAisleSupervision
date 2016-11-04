package marketAisleSupervision.user.controllers;


import marketAisleSupervision.user.models.Entity.Task;
import marketAisleSupervision.user.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import marketAisleSupervision.user.models.Entity.User;
import marketAisleSupervision.user.service.UserService;

import java.util.List;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            userService.save(user);
            return new ResponseEntity<User>(user, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<User>(HttpStatus.NOT_ACCEPTABLE);

        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<LoginResponse> loginUser(@RequestParam String userEmailOrUserName, @RequestParam String password){
        try{
            return new ResponseEntity<LoginResponse>(userService.login(userEmailOrUserName,password),HttpStatus.OK);
        }catch (Exception ex){
            return  new ResponseEntity<LoginResponse>(HttpStatus.NOT_FOUND);
        }
    }

   /* @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<User> create(@RequestBody User user) {
        try {
            userService.save(user);
            return new ResponseEntity<User>(user, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

    }*/

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<User> update(@RequestBody User user) {
        try {
            userService.update(user);
            return new ResponseEntity<User>(user, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<User> get(@RequestParam int userId) {
        try {
            User user = userService.getUser(userId);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

    }
    @RequestMapping(value = "/taskHistory", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getTaskHistory(@RequestParam int userId) {
        try {
            List<Task> task = userService.getTaskHistory(userId);
            return new ResponseEntity<List<Task>>(task, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<List<Task>>(HttpStatus.NOT_FOUND);
        }

    }


}