package edson.bean;

import java.util.HashSet;
import java.util.Set;

public class Student {
	
	private String stu_id="";
	private String stu_name="";
	private Integer stu_gender=0;
	private String stu_birth="";
	private String stu_pwd="";
	
	private Set<Course> courses=new HashSet<Course>();
	
	
	
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public String getStu_id() {
		return stu_id;
	}
	@Override//重写hashcode和equals方法，list、set等集合操作对于实体对象才有效
	public int hashCode() {
		Student c = (Student) this;
        return c.stu_id.hashCode();

	}
	@Override
	public boolean equals(Object obj) {
		if(obj==null)return false;
		
		 if (obj instanceof Student) {
	            Student c = (Student) obj;
	            return (this.stu_id.equals(c.stu_id));
	        }
	     return super.equals(obj);

	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public Integer getStu_gender() {
		return stu_gender;
	}
	public void setStu_gender(Integer stu_gender) {
		this.stu_gender = stu_gender;
	}
	public String getStu_birth() {
		return stu_birth;
	}
	public void setStu_birth(String stu_birth) {
		this.stu_birth = stu_birth;
	}
	public String getStu_pwd() {
		return stu_pwd;
	}
	public void setStu_pwd(String stu_pwd) {
		this.stu_pwd = stu_pwd;
	}
	
	
}
