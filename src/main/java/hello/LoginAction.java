package hello;

import hello.User;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action{
	private User user;
	
	public static final String SUCCESS = "success";
	
	public static final String ERROR = "error";
	
	private static final Logger logger = Logger.getLogger(LoginAction.class);
	
	public String execute() throws Exception
	{
		logger.debug("begin to validate user name and password");
		logger.info("info:begin to validate user name and password");
		logger.warn("warn:begin to validate user name and password");
		
		if("zhangsan".equals(user.getUsername()) && "123".equals(user.getPassword()))
			return SUCCESS;
		else
			return ERROR;
	}
	
	public User getUser()
	{
		logger.debug("get user");
		return user;
	}
	
	public void setUser(User user){
		this.user = user;
	}
}

