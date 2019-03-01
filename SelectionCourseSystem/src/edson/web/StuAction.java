package edson.web;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edson.bean.Admin;
import edson.bean.Course;
import edson.bean.Student;
import edson.business.serviceImpl.StuService;
import edson.utils.MD5;
import edson.utils.PageBean;


public class StuAction extends ActionSupport implements ModelDriven<Course>{
	
	public StuService stuService;
	private PageBean pb;
	private Integer num;
	private Student stu;
	public Course course=new Course();
	private String pwd1;
	private String pwd2;
	private String tea_name;//查询条件
	
	public String viewAllSelection(){
		try{
			if(num==null)num=1;
			stu=(Student) ActionContext.getContext().getSession().get("stu_user");
			pb=stuService.findSelection(num,stu.getStu_id());//查找除去已选课程外的可选课程
			pb.setPath("/stu_viewAllSelection");
			
			
			
			ActionContext.getContext().getSession().put("pb", pb);
			
			return "success_viewAllSelection";
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
	}
	
	public String selectCourse(){
		try{
			stu=(Student) ActionContext.getContext().getSession().get("stu_user");
			stu=stuService.findStuById(stu.getStu_id());
			course=stuService.findCourseById(course.getCourse_id());
			
			//判断是否选课名额已满
			if(course.getSelection_taken()>=course.getCapacity())return "error";
			
			
			int temp=course.getSelection_taken();
			course.setSelection_taken(++temp);
			stu.getCourses().add(course);
			course.getStudents().add(stu);//student维护外键
			
			//更新数据库
			stuService.updateStu(stu);
			stuService.updateCourse(course);
			//更新session
			ActionContext.getContext().getSession().put("stu_user", stu);
			return "success_selectCourse";
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
	}
	
	public String viewMySelection(){
		
		try{
			if(num==null)num=1;
			stu=(Student) ActionContext.getContext().getSession().get("stu_user");
			pb=stuService.findMySelection(num,stu.getStu_id());
			pb.setPath("/stu_viewMySelection");
			ActionContext.getContext().getSession().put("pb", pb);
			return "success_viewMySelection";
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
		
	}
	
	public String deleteSelection(){

		try{
			
			stu=(Student) ActionContext.getContext().getSession().get("stu_user");
			stu=stuService.findStuById(stu.getStu_id());
			Course temp=stuService.findCourseById(course.getCourse_id());
			int t=temp.getSelection_taken();
			temp.setSelection_taken(--t);
			stu.getCourses().remove(temp);
			temp.getStudents().remove(stu);
			
			//更新数据库
			stuService.updateCourse(temp);
			stuService.updateStu(stu);
			//更新session
			ActionContext.getContext().getSession().put("stu_user", stu);
			
			return "success_deleteSelection";
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
		
	}
	
	public String searchCourseByTeaName(){
		
	try{
		if(num==null)num=1;
		if(tea_name==null)return "error";
		pb=stuService.searchCourseByTeaName(tea_name.trim(),num);
		pb.setPath("/stu_searchCourseByTeaName");
		ActionContext.getContext().getSession().put("pb", pb);	
		return "success_searchCourseByTeaName";
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
	}
	
	public String searchCourseByCourseName(){
		try{
			if(num==null)num=1;
			if(course.getCourse_name()==null || course.getCourse_name()=="")return "error";
			pb=stuService.searchCourseByCourseName(course.getCourse_name().trim().trim(),num);
			pb.setPath("/stu_searchCourseByCourseName");
			ActionContext.getContext().getSession().put("pb", pb);	
			return "success_searchCourseByCourseName";
			}catch(Exception e){
				e.printStackTrace();
				this.addActionError("操作失败，请稍候尝试！");
				return "error";
			}
	}
	
	
	public String loginOut(){
		try{
			ActionContext.getContext().getSession().remove("stu_user");
			return "success_loginOut";
		
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
		
	}
	
	public String updatePwdUI(){
		return "success_updatePwdUI";
	}
	
	public String updatePwd(){
		try{
			if(pwd1==null || pwd2==null || !pwd1.equals(pwd2)){
				
				return "error";
			}
			stu=(Student) ActionContext.getContext().getSession().get("stu_user");
			stu=stuService.findStuById(stu.getStu_id());
			stu.setStu_pwd(MD5.getMD5(pwd1));
			stuService.updateStu(stu);
			return loginOut();
		
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
	}


	public void setStuService(StuService stuService) {
		this.stuService = stuService;
	}


	public void setPb(PageBean pb) {
		this.pb = pb;
	}


	public void setNum(Integer num) {
		this.num = num;
	}


	public PageBean getPb() {
		return pb;
	}

	@Override
	public Course getModel() {
		// TODO Auto-generated method stub
		return course;
	}

	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public void setTea_name(String tea_name) {
		this.tea_name = tea_name;
	}

	
	
	
	
	
	
	
	

}
