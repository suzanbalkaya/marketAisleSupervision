package marketAisleSupervision.user.models.Dao.impl;


import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import marketAisleSupervision.user.models.Dao.UserDao;
import marketAisleSupervision.user.models.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    @Override
    public List<User> loginEmail(String email, String password)
    {
        Query query = getSession().createQuery("from User u where u.email =:email and u.password=:password");
        query.setParameter("email",email);
        query.setParameter("password",password);
        return query.list();
    }

    @Override
    public List<User> loginUserName(String name, String password) {
        Query query = getSession().createQuery("from User u where u.userName =:name and u.password=:password");
        query.setParameter("name",name);
        query.setParameter("password",password);
        return query.list();
    }

    @Override
    public void save(User user) {
       getSession().save(user);
    }

    @Override
    public void delete(User user) {
        getSession().delete(user);
        return;
    }

    @Override
    public List<User> getAll() {
        return getSession().createQuery("from Users").list();
    }

    @Override
    public void update(User user) {
        getSession().update(user);
        return;
    }

    @Override
    public User getUser(int userId) {
        return (User) getSession().load(User.class, new Integer(userId));
    }
}
