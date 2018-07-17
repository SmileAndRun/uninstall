package hws.com.bdcom.dao;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class User {
	private int id;
	private String username;
	private String password;
	private String nick_name;
	private int sex;
	private Timestamp  register_date;
	private Date date;
	private Time time;
	
	
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Timestamp getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Timestamp register_date) {
		this.register_date = register_date;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", nick_name=" + nick_name + ", sex=" + sex
				+ ", register_date=" + register_date + ", date=" + date
				+ ", time=" + time + "]";
	}

	
	
	
}
