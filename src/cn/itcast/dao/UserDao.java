package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDao {
	User getBuUserCode(String usercode);

	void save(User u);
	
	
}
