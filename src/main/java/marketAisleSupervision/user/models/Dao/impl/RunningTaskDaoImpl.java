package marketAisleSupervision.user.models.Dao.impl;


import marketAisleSupervision.user.models.Dao.RunningTasksDao;
import marketAisleSupervision.user.models.Entity.RunningTasks;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RunningTaskDaoImpl implements RunningTasksDao{

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    @Override
    public void create(RunningTasks runningTasks) {
        getSession().save(runningTasks);
    }

    @Override
    public List<RunningTasks> getRunningTask(Integer runningTaskId) {
        Query query = getSession().createQuery("from RunningTasks r where r.id =:runningTaskId");
        query.setParameter("runningTaskId",runningTaskId);
        return query.list();
    }

    @Override
    public List<RunningTasks> getTaskId(Integer taskId) {
        Query query = getSession().createQuery("from RunningTasks r where r.taskId =:taskId");
        query.setParameter("taskId",taskId);
        return query.list();
    }
    @Override
    public List<RunningTasks> getTaskIdStatus(Integer taskId, Integer status) {
        Query query = getSession().createQuery("from RunningTasks r where r.taskId =:taskId and r.status=:status");
        query.setParameter("taskId",taskId);
        query.setParameter("status",status);
        return query.list();
    }

}
