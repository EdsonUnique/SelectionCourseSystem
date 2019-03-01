package edson.web;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edson.bean.Course;
import edson.bean.Teacher;
import edson.business.serviceImpl.AdminService;
import edson.utils.PageBean;

public class AdminCourseAction extends ActionSupport implements ModelDriven<Course>{
	
	private Course course=new Course();
	public AdminService adminService;
	private PageBean pb;
	private Integer num;//页码
	private String t_c_id;//教师编号
	private Teacher tea;
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++课程+++++++++++++++++
	
	public String addCourseUI(){
		List<Teacher> teas=adminService.findAllTeacher();
		ActionContext.getContext().getSession().put("teas", teas);
		return "success_addCourse";
	}
	
	public String addCourse(){
		try{
			if(course.getCourse_id().trim()=="")return "error";//后台校验
			adminService.save(course);
			this.addActionError("添加成功");
			return "success_addCourse";
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
	}
	
	public String findPageCourse(){
		if(num==null)num=1;
		pb=adminService.findPageCourse(num);
		pb.setPath("/adminCourse_findPageCourse");
		ActionContext.getContext().getSession().put("pb", pb);
		return "success_findPageCourse";
	}
			
	public String searchCourseById(){
		
		if(course.getCourse_id()==null || course.getCourse_id().trim()==""){
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
		pb=adminService.searchCourseById(course.getCourse_id().trim());
		pb.setPath("/adminCourse_searchCourseById");
		ActionContext.getContext().getSession().put("pb", pb);
		
		return "success_findPageCourse";
	}
	
	public String searchCourseByName(){
		
		if(course.getCourse_name()==null || course.getCourse_name().trim()==""){
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
		if(num==null)num=1;
		pb=adminService.searchCourseByName(course.getCourse_name().trim(),num);
		pb.setPath("/adminCourse_searchCourseByName");
		ActionContext.getContext().getSession().put("pb", pb);
				
		return "success_findPageCourse";
	}
	
	public String updateCourseUI(){
		
		pb=adminService.searchCourseById(course.getCourse_id());
		ServletActionContext.getRequest().setAttribute("course", pb.getPageData().get(0));
		List<Teacher> teas=adminService.findAllTeacher();
		ActionContext.getContext().getSession().put("teas", teas);
		
		return "success_addCourse";
		
	}
	
	public String updateCourse(){
		
		try{
			tea=(Teacher) adminService.searchTeaById(course.getTea().getTea_id()).getPageData().get(0);
			
			//使数据库中未更改的字段保持一致
			Course c=(Course) adminService.searchCourseById(course.getCourse_id()).getPageData().get(0);
			course.setCapacity(c.getCapacity());
			course.setIs_on(c.getIs_on());
			course.setIs_selection(c.getIs_selection());
			course.setSelection_taken(c.getSelection_taken());
			course.setStudents(c.getStudents());
			
			course.setTea(tea);
			adminService.updateCourse(course);
			this.addActionError("修改成功");
			return "success_updateCourse";
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
	}
	
	public String deleteCourse(){
				
		try{
			adminService.deleteCourse(course);
			this.addActionError("已删除");
			return "success_updateCourse";
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
	}

	@Override
	public Course getModel() {
		
		return course;
	}

	public void setcourse(Course course) {
		this.course = course;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public void setPb(PageBean pb) {
		this.pb = pb;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setT_c_id(String t_c_id) {
		this.t_c_id = t_c_id;
	}
			
			
	
	

	
}
