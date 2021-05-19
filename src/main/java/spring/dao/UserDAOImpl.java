package spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getUserList() {
        return entityManager.createQuery("select  u from  user  u", User.class).getResultList();
    }

    @Override
    @Transactional
    public User show(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void update(User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    @Transactional
    public void delete(int id) {

       entityManager.createQuery("delete from user where id = :id").setParameter("id", id).executeUpdate();


      //  entityManager.remove(entityManager.find(User.class,id));

    }
}
