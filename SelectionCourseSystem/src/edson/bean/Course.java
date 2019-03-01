package edson.bean;

import java.util.HashSet;
import java.util.Set;

public class Course {
	
	private String course_id="";
	private String course_name="";
	private Integer credit=0;
	private Integer is_selection=0;//是否为选课内容
	
	private Integer selection_taken=0;//已选该课的学生数量
	private Integer is_on=0;//是否开课
	private Integer capacity=0;
	
	private Set<Student>students=new HashSet<Student>();
	private Teacher tea;
	
	
	public Teacher getTea() {
		return tea;
	}
	public void setTea(Teacher tea) {
		this.tea = tea;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Integer getSelection_taken() {
		return selection_taken;
	}
	public void setSelection_taken(Integer selection_taken) {
		this.selection_taken = selection_taken;
	}
	public Integer getIs_on() {
		return is_on;
	}
	public void setIs_on(Integer is_on) {
		this.is_on = is_on;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	
	
	public Integer getIs_selection() {
		return is_selection;
	}
	public void setIs_selection(Integer is_selection) {
		this.is_selection = is_selection;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	@Override
	public int hashCode() {
		Course c = (Course) this;
        return c.course_id.hashCode();

	}
	@Override
	public boolean equals(Object obj) {
		if(obj==null)return false;
		
		 if (obj instanceof Course) {
	            Course c = (Course) obj;
	            return (this.course_id.equals(c.course_id));
	        }
	     return super.equals(obj);

	}
	
	
	
	
}
