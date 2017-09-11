package cn.itcast.web.action;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private UserService userService;
	private User user= new User();
	
	public String login() throws Exception {
		
			User u=userService.getUserByCodePassword(user);
			
			ActionContext.getContext().getSession().put("user", u);
		
		return "toHome";
	}
	
	public String regist() throws Exception {
		//1 调用Service保存注册用户
		try {
			userService.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		//2 重定向到登陆页面
	return "toLogin";
}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User getModel() {
		
		return user;
	}
	
}
