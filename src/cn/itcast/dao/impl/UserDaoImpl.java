package cn.itcast.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public User getBuUserCode(String usercode) {
		return getHibernateTemplate().execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				
				String sql="from User where user_code = ? ";
				Query query = session.createQuery(sql);
				query.setParameter(0, usercode);
				User user = (User) query.uniqueResult();
				return user;
			}
		});
		

	}

	@Override
	public void save(User u) {
		
		getHibernateTemplate().save(u);
	}

}
