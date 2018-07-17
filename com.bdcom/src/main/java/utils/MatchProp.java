package utils;

import java.lang.reflect.Field;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchProp {

	private static Map<String, Object> map = null;
	private static SimpleDateFormat sdf = null;
	private static List<Object> objList = null;

	public static List<Object> matchProp(ResultSet rs, Class<?> className)
			throws SQLException, ParseException, InstantiationException,
			IllegalAccessException {
		ResultSetMetaData rsm = rs.getMetaData();// 获得列集
		int count = rsm.getColumnCount();
		map = new HashMap<String, Object>(count);
		objList = new ArrayList<Object>();
		Object classObject = null;
		
		while (rs.next()) {
			classObject = className.newInstance();// 实例化一个对象实例
			
			for (int i = 0; i < count; i++) {
				Object obj = rs.getObject(i + 1);
				String key = rsm.getColumnName(i + 1).toLowerCase();
				// columns.add(key);//列名都是从1开始
				// values.add(obj);
				map.put(key, obj);
			}

			Field[] fields = className.getDeclaredFields();// 获取该class的所有属性
			
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				Class<?> type = field.getType();//获取实例对象中的属性的类型
				field.setAccessible(true);// 将属性设置为可以编辑的状态
				String name = fields[i].getName();
				Object value = map.get(name.toLowerCase());
				if (null != value) {
					if (value instanceof Boolean) {
						field.set(classObject, ((Boolean) value).booleanValue());
					} else if (value instanceof String) {
						field.set(classObject, value.toString());
					} else if (value instanceof Integer) {
						field.set(classObject,
								Integer.valueOf(value.toString().trim())
										.intValue());
					} else if (value instanceof Float) {
						field.set(classObject,
								new Float(value.toString()).floatValue());
					} else if (value instanceof Double) {
						field.set(classObject, new Double(value.toString()
								.trim()).doubleValue());
					} else if (value instanceof Short) {
						field.set(classObject,
								Short.valueOf(value.toString().trim())
										.shortValue());
					} else if (value instanceof Long) {
						field.set(classObject,
								Long.valueOf(value.toString().trim())
										.longValue());
					} else if (value instanceof Byte) {
						field.set(classObject, Byte.valueOf(value.toString())
								.byteValue());
					}else if (value instanceof Timestamp) {
						sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date date = (Date)sdf.parseObject(value.toString());
						if(type == String.class){
							field.set(classObject, sdf.format(date));
						}else{
							field.set(classObject, new Timestamp(date.getTime()));
						}
					} else if (value instanceof Time) {
						sdf = new SimpleDateFormat("HH:mm:ss");
						Time time = (Time)value;
						if(type == String.class){
							field.set(classObject, sdf.format(time));
						}else{
							field.set(classObject, time);
						}
						
					}else if (value instanceof Date) {
						sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date date = (Date)value;
						if(type == String.class){
							field.set(classObject, sdf.format(date));
						}else{
							field.set(classObject, date);
						}
					} 
				}
			}
			objList.add(classObject);
		}
		return objList;

	}
}
