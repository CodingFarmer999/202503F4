package com.course.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
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

}
