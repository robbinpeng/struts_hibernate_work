package hibernate;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class TestConnect {
	
	public static void main(String[] args){
	
		Configuration configuration = new Configuration();
		configuration.configure();
		//configuration.addAnnotatedClass(hibernate.User.class);
		configuration.addResource("User.hbm.xml");
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sf = configuration.buildSessionFactory(sr);
		
		User1 user1 = new User1();
		user1.setUserName("Robbin");
		user1.setUserMessage(makeMD5("Hello world from Robbin"));
		
		User1 user2 = new User1();
		user2.setUserName("Candy");
		user2.setUserMessage(makeMD5("Hello world from Candy!"));
		
		User1 user3 = new User1();
		user3.setUserName("Nina");
		user3.setUserMessage(makeMD5("Hello world from Nina!"));
		
		//saving objects to session
		Session ss = sf.openSession();
		ss.beginTransaction();
		ss.save(user1);
		ss.save(user2);
		ss.save(user3);
		ss.getTransaction().commit();
		
		ss.beginTransaction();
		User1 user4 = (User1)ss.load(User1.class,new Integer(2));
		System.out.println("the result is:" + user4.getUserName() + ",telling: " + user4.getUserMessage());
		
		ss.delete(user1);
		ss.getTransaction().commit();
		
		Query query = ss.createQuery("from User1 where userName=?");
		query.setString(0, "Nina");
		List arr = query.list();
		System.out.println("record:" + arr.size());
		
		User1 user5 = (User1)arr.get(0); 
		String pass = makeMD5("Hello world from Nina!");
		if(pass.equals(user5.getUserMessage()))System.out.println("The password is right!");
		else System.out.println("Wrong password!");
		ss.close();
	}
	
	public static String makeMD5(String password) {
		MessageDigest md;
		try{
			md = MessageDigest.getInstance("MD5");
			// compute Md5 function:
			md.update(password.getBytes());
			
			String pwd = new BigInteger(1, md.digest()).toString();
			
			return pwd;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}
	
}
