package tutorial;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import hello.User;

public class HelloWorld extends ActionSupport {
	
	public static final String MESSAGE = "Struts is up and running....";
	
	private Map<String,Object> dataMap;
	
	public String execute() throws Exception {
		setMessage(MESSAGE);
		return SUCCESS;
	}
	
	private String message;
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String json() {
		dataMap = new HashMap<String, Object>();
		User user = new User();
		user.setUsername("zhangsan");
		user.setPassword("123");
		dataMap.put("user", user);
		
		return SUCCESS;
	}
	
	public Map<String,Object> getDataMap(){
		return dataMap;
	}
}
