package com.course.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.course.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public User findByUsername(String username) {
		// 呼叫DB
		return null;
	}

	@Override
	public void addUser(String username, String password) {
		// Entity
		User user = new User(username, password);
		System.out.println("Add User");
		
		Configuration configuration = new Configuration().configure();
	    SessionFactory sessionFactory = configuration.buildSessionFactory();
	    // 取得Session
	    Session session = sessionFactory.openSession();
		// 開啟交易/事務
		Transaction transaction = session.beginTransaction();
		// 新增
		session.save(user);
		// 提交
		transaction.commit();
		// 關閉連線
		session.close();
		
	}

}
