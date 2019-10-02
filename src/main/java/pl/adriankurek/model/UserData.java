package pl.adriankurek.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pl.adriankurek.api.UserDataApi;

public class UserData implements UserDataApi {
    private final static String DATABASE_NAME = "dataBase";
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public UserData() {
		openConnection();
	}

    @Override
    public List<User> getUsers() {
        String hql = "FROM User";
		Query query = entityManager.createQuery(hql);
		List <User> users = query.getResultList();
        return users;
    }

    @Override
    public void insertUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
		entityManager.getTransaction().commit();
    }

    @Override
    public void deleteUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.remove(user);
		entityManager.getTransaction().commit();
    }

    @Override
    public void updateUser(User user) {
    	long id = user.getId();
    	String hql = "UPDATE User SET name = '" + user.getName() + "', city = '" + user.getCity()
		+ "' WHERE id = " + id;
    	Query query = entityManager.createQuery(hql);
    	
        entityManager.getTransaction().begin();
        query.executeUpdate();
		entityManager.getTransaction().commit();
    }

    private void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory(DATABASE_NAME);
		entityManager = entityManagerFactory.createEntityManager();
	}

	private void closeConnection() {
		entityManager.close();
		entityManagerFactory.close();
    }
}