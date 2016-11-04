package marketAisleSupervision.user.service.impl;


import marketAisleSupervision.user.models.Entity.Task;
import marketAisleSupervision.user.response.LoginResponse;
import marketAisleSupervision.user.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import marketAisleSupervision.user.models.Dao.UserDao;
import marketAisleSupervision.user.models.Entity.User;
import marketAisleSupervision.user.service.UserService;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    TaskService taskService;
    @Override
    public LoginResponse login(String userEmailOrUserName, String password) {
        password = encipheringMD5(password);
        LoginResponse loginResponse = new LoginResponse();
        if (userEmailOrUserName.isEmpty() || password.isEmpty()) {
            System.out.println("kullanıcı adı ve şifre boş olamaz");
            return null;
        } else if (isEmailValid(userEmailOrUserName)) {
            List<User> users=userDao.loginEmail(userEmailOrUserName, password);
            if(users.size()<2) {
                loginResponse.setUser(users.get(0));
                loginResponse.setTaskList(taskService.userTaskList(loginResponse.getUser().getId()));
                return  loginResponse;
            }
            else
                return null;
        } else {
            List<User> users=userDao.loginUserName(userEmailOrUserName, password);
            if(users.size()<2){
                loginResponse.setUser( users.get(0));
                loginResponse.setTaskList(taskService.userTaskList(loginResponse.getUser().getId()));

                return loginResponse;
            }
            else
                return null;
        }
    }

    @Override
    public void save(User userEntity) {
        if (isEmailValid(userEntity.getEmail())) {
            userEntity.setPassword(encipheringMD5(userEntity.getPassword()));
            userDao.save(userEntity);
        }

    }

    @Override
    public void delete(User userEntity) {
        userDao.delete(userEntity);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void update(User userEntity) {
        userDao.update(userEntity);
    }

    @Override
    public User getUser(int userId) {
        return userDao.getUser(userId);
    }

    @Override
    public List<Task> getTaskHistory(int userId) {

        return taskService.getTaskHistory(userId);
    }

    private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

    public static boolean isEmailValid(String emailInput) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN,
                Pattern.CASE_INSENSITIVE);
        return pattern.matcher(emailInput).find();
    }



    private String encipheringMD5(String password) {
        MessageDigest messageDigestNesnesi = null;
        try {
            messageDigestNesnesi = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigestNesnesi.update(password.getBytes());
        byte[] messageDigestDizisi = messageDigestNesnesi.digest();
        StringBuffer sb32 = new StringBuffer();
        for (int i = 0; i < messageDigestDizisi.length; i++) {
            sb32.append(Integer.toString((messageDigestDizisi[i] & 0xff) + 0x100, 32));
        }
        return sb32.toString();
    }


}