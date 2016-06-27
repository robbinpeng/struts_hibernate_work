package hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity(name="User_table")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int userId;
	@Column(name="User_Name")
	String userName;
	@Column(name="User_Message")
	String userMessage;
	
	public int getUserId(){
		return userId;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getUserMessage(){
		return userMessage;
	}
	public void setUserMessage(String userMessage){
		this.userMessage = userMessage;
	}
}
