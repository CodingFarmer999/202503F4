package com.course.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.course.entity.User;
import com.course.service.ConnectionService;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private ConnectionService connectionService;
	
	@Override
	public User findByUsername(String username) {
		// 呼叫DB
		return null;
	}

	@Override
	public void addUser(User user) {

		System.out.println("Add User");
		
//		Configuration configuration = new Configuration().configure();
//	    SessionFactory sessionFactory = configuration.buildSessionFactory();
//	    // 取得Session
//	    Session session = sessionFactory.openSession();
	    
	    
	    //  Try With Resource
	    try (Session session = connectionService.getSession();) {
			// 開啟交易/事務
			Transaction transaction = session.beginTransaction();

			// 新增 Hibernate 5.0
			// session.save(user);
			
			// Hibernate 6.0 以上
			session.persist(user);

			// 提交
			transaction.commit();
			
			// 關閉連線
			// session.close();
	    }


		
	}

	@Override
	public void delUser(User user) {
	    //  Try With Resource
	    try (Session session = connectionService.getSession();) {
			// 開啟交易/事務
			Transaction transaction = session.beginTransaction();

			// Hibernate 5.0
			//session.delete(user);
			
			// Hibernate 6.0 以上
			session.remove(user);

			// 提交
			transaction.commit();

	    }
		
	}

	@Override
	public void updateUser(User user) {
	    //  Try With Resource
	    try (Session session = connectionService.getSession();) {
			// 開啟交易/事務
			Transaction transaction = session.beginTransaction();

			// Hibernate 5.0
			//session.update(user);
			
			// Hibernate 6.0 以上
			session.merge(user);

			// 提交
			transaction.commit();
	    }
		
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		User user = null;
	    try (Session session = connectionService.getSession();) {
	    	// JPQL
	    	// String sql = "select * from user u where u.username = ? and u.password = ?";
	    	// String sql = "select u from User u where u.username = ?1 and u.password = ?2";
	    	// Query<User> query = session.createQuery(sql, User.class);
	    	
	    	// NativeSQL
//	    	String nativeSql = "select * from USER u where u.username = ?1 and u.password = ?2";
//	    	Query<User> query = session.createNativeQuery(nativeSql, User.class);
//	    	
//	    	query.setParameter(1, username);
//	    	query.setParameter(2, password);
	    	
	    	
	    	// Named
	    	String nativeSql = "select * from USER u where u.username = :u1 and u.password = :p1";
	    	Query<User> query = session.createNativeQuery(nativeSql, User.class);
	    	query.setParameter("p1", password);
	    	query.setParameter("u1", username);
	    	
	    	List<User> users = query.getResultList();
	    	user = users.get(0);
	    	
	    }
		return user;
	}

}
