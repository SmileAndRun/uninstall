package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BaseJDBC{
	
	private static String DRIVERCLASSNAME = "com.mysql.jdbc.Driver";
	private static String URL="jdbc:mysql://localhost:3306/test";
	private static Connection conn = null;
	private static String user = "root";
	private static String password = "root";
	private static PreparedStatement pre = null;
	private static ResultSet rs = null;
	
	
	static{
		try {
			Class.forName(DRIVERCLASSNAME);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() throws SQLException{
		
		conn = DriverManager.getConnection(URL, user, password);
		
		return conn;
		
	}
	
	public static ResultSet getResultSet(Connection conn,String sql) throws SQLException{
		pre = conn.prepareStatement(sql);
		rs = pre.executeQuery();
		
		return rs;
	}
	
	public static void close() throws SQLException{
		if(null != rs){
			rs.close();
			if(null != pre){
				pre.close();
				if(null != conn){
					conn.close();
				}
			}
		}
	}
	

}