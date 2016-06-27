package hello;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DAO {
	
	private static DataSource dataSource;
	
	public void dbcp() {
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			Properties pro = new Properties();
			pro.setProperty("driverClassName", "com.mysql.jdbc.Driver");
			pro.setProperty("url", "jdbc:mysql://localhost:3306/world");
			pro.setProperty("username", "root");
			pro.setProperty("password", "1234");
			pro.setProperty("initialSize", "100");
			pro.setProperty("maxActive", "500");
			pro.setProperty("maxIdle", "200");
			pro.setProperty("maxWait", "600");
			pro.setProperty("useUnicode", "true");
			pro.setProperty("characterEncoding", "gbk");
			pro.setProperty("defaultAutoCommit", "true");
			pro.setProperty("defaultTransactionIsolation", "READ_UNCOMMITTED");
			pro.setProperty("useSSL", "false");
			pro.setProperty("serverTimezone", "UTC");
			
			dataSource = BasicDataSourceFactory.createDataSource(pro);
			conn = dataSource.getConnection();
			String sql = "select * from country limit 10";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				System.out.println("record:" + rs.getString(1) + "," +rs.getString(2) + "," + rs.getString(3) + ",squre:" + rs.getDouble(5) + ".");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			DAO dao = new DAO();
			dao.dbcp();
	}

}
