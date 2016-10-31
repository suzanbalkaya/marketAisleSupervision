package marketAisleSupervision.user.models.Dao.impl;


import marketAisleSupervision.user.models.Dao.TaskDao;
import marketAisleSupervision.user.models.Entity.Task;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TaskDaoImpl implements TaskDao {
    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    @Override
    public void createTask(Task task) {
        getSession().save(task);
        return;
    }

    @Override
    public List<Task> adminListTask(Integer adminId) {
        Query query = getSession().createQuery("from Task t where t.adminId =:adminId");
        query.setParameter("adminId",adminId);
        return query.list();
    }

    @Override
    public List<Task> userListTask(Integer userId) {
        Query query = getSession().createQuery("from Task t where t.userId =:userId");
        query.setParameter("userId",userId);
        return query.list();
    }

    @Override
    public List<Task> getTask(Integer taskId) {
        Query query = getSession().createQuery("from Task t where t.id =:taskId");
        query.setParameter("taskId",taskId);
        return query.list();
    }

    @Override
    public void updateTask(Task task) {
        getSession().update(task);
    }

    @Override
    public List<Task> getTaskHistory(Integer userId) {
        Query query =getSession().createQuery("from Task t where t.userId =:userId");
        query.setParameter("userId",userId);
        return  query.list();

    }
}