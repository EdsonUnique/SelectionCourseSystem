package edson.bean;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
	
	private String tea_id="";
	private String tea_name="";
	private Integer tea_gender=0;
	private String tea_birth="";
	private String tea_pwd="";
	
	private Set<Course>courses=new HashSet<Course>();
	
	
	
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public String getTea_id() {
		return tea_id;
	}
	public void setTea_id(String tea_id) {
		this.tea_id = tea_id;
	}
	public String getTea_name() {
		return tea_name;
	}
	public void setTea_name(String tea_name) {
		this.tea_name = tea_name;
	}
	public Integer getTea_gender() {
		return tea_gender;
	}
	public void setTea_gender(Integer tea_gender) {
		this.tea_gender = tea_gender;
	}
	public String getTea_birth() {
		return tea_birth;
	}
	public void setTea_birth(String tea_birth) {
		this.tea_birth = tea_birth;
	}
	public String getTea_pwd() {
		return tea_pwd;
	}
	public void setTea_pwd(String tea_pwd) {
		this.tea_pwd = tea_pwd;
	}
	
	
}
