package service.impl;


import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernameSessionFactory;
import entity.Users;
import service.UserDAO;

public class UsersDAOImpl implements UserDAO {

	public boolean usersLongin(Users users) {
		//事务对象
		Transaction tx = null; 
		String hql = "";
		try {
			Session session = MyHibernameSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "select * from users where username=? and password=?";
			Query query = session.createSQLQuery(hql);
			query.setParameter(0, users.getUsername());
			query.setParameter(1, users.getPassword());
			List<Users> list = query.list();
			tx.commit();//提交事物
			if (list.size() > 0) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			if (tx != null) {
				//tx.commit();
				tx = null;
			}
		}
	}

}
