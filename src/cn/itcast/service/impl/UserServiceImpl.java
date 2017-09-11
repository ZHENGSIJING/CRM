package cn.itcast.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.utils.MD5Utils;


public class UserServiceImpl implements UserService{
	
	private UserDao ud;

	@Override
	public User getUserByCodePassword(User u) {
		
		User existU = ud.getBuUserCode(u.getUser_code());
		
		if(existU==null){
			
			throw new RuntimeException("用户不存在!");
		}
		
		if(!existU.getUser_password().equals(MD5Utils.md5(u.getUser_password()))){
			throw new RuntimeException("密码错误!");
		}
		
		return existU;
	}

	@Override
	public void saveUser(User u) {
		User existU = ud.getBuUserCode(u.getUser_code());
		
		if(existU!=null){
			throw new RuntimeException("用户已存在");
		}
		
		u.setUser_password(MD5Utils.md5(u.getUser_password()));
		
		ud.save(u);
		
		
		
		
	}
	

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

}
