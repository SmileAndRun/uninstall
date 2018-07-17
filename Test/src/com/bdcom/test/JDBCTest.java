package com.bdcom.test;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JDBCTest {
	
	private static String DRIVERCLASSNAME = "com.mysql.jdbc.Driver";
	private static String URL="jdbc:mysql://localhost:3306/test";
	private static Connection conn = null;
	private static String user = "root";
	private static String password = "root";
	private static PreparedStatement pre = null;
	private static ResultSet rs = null;
	private static  Map<String,Object> map = null;
	private static DateFormat format = null;
	
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
	public static Object  matchProp(ResultSet rs,Class<?> className) throws SQLException, ParseException, InstantiationException, IllegalAccessException{
		ResultSetMetaData rsm = rs.getMetaData();//获得列集
		int count = rsm.getColumnCount();
		//columns = new ArrayList<String>(count);
		//values = new ArrayList<Object>(count);
		map = new HashMap<String,Object>(count);
		
		for(int i=0;i<count;i++){
			Object obj = rs.getObject(i);
			String key = rsm.getColumnName(i + 1).toLowerCase();
			//columns.add(key);//列名都是从1开始
			//values.add(obj);
			map.put(key, obj);
		}
		Field[] fields = className.getDeclaredFields();//获取该class的所有属性
		Object classObject = className.newInstance();//实例化一个对象实例
		for(int i=0;i<fields.length;i++){
			Field field = fields[i];
			field.setAccessible(true);//将属性设置为可以编辑的状态
			String name = fields[i].getName();
			Object value = map.get(name.toLowerCase());
			if(null != value){
				if(value instanceof Boolean){
					field.set(classObject, ((Boolean) value).booleanValue());
				}else if(value instanceof String){
					field.set(classObject,value.toString());
				}else if(value instanceof Integer){
					field.set(classObject,Integer.valueOf(value.toString().trim()).intValue());
				}else if(value instanceof Float){
					field.set(classObject,new Float(value.toString()).floatValue());
				}else if(value instanceof Double){
					field.set(classObject,new Double(value.toString().trim()).doubleValue());
				}else if(value instanceof Short){
					field.set(classObject,Short.valueOf(value.toString().trim()).shortValue());
				}else if(value instanceof Long){
					field.set(classObject,Long.valueOf(value.toString().trim()).longValue());
				}else if(value instanceof Byte){
					field.set(classObject,Byte.valueOf(value.toString()).byteValue());
				}else if(value instanceof Date){//sql的Date
					format = DateFormat.getDateInstance();
					field.set(classObject,format.parse(value.toString()));
				}else if(value instanceof Time){
					format = DateFormat.getTimeInstance();
					field.set(classObject,format.parse(value.toString()));
				}
			}
		}
		return classObject;
	}

}