package hws.com.bdcom.test;

import hws.com.bdcom.dao.User;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import utils.BaseJDBC;
import utils.MatchProp;

public class Test {

	public static void main(String[] args) {
		List<User> userList = new ArrayList<User>();
		String sql = "select * from user";
		try {
			List<Object> objList =MatchProp.matchProp(BaseJDBC.getResultSet(BaseJDBC.getConn(), sql), User.class);
			userList = (List<User>)(Object)objList;
			System.out.println(userList);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	

}
