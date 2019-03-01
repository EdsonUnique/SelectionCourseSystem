package edson.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edson.bean.Admin;
import edson.bean.Course;
import edson.bean.Student;
import edson.business.serviceImpl.AdminService;
import edson.utils.PageBean;



public class AdminSelectionAction extends ActionSupport implements ModelDriven<Course>{
	

	public AdminService adminService;
	private PageBean pb;
	private Integer num;//页码
	private String startTime;
	private String endTime;
	private Integer is_start;
	private Course course=new Course();
	
	public String findAllCourse(){
		if(num==null)num=1;
		pb=adminService.findPageCourse(num);
		pb.setPath("/adminSelection_findAllCourse");
		ActionContext.getContext().getSession().put("pb", pb);
		return "success_findAllCourse";
	}
	
	public String addSelection(){
		try{
			pb=adminService.searchCourseById(course.getCourse_id().trim());
			if(pb.getPageData().size()<1 || ((Course) pb.getPageData().get(0)).getIs_selection()==1)return "error";//已经成为选课内容
			Course cour=(Course) pb.getPageData().get(0);
			cour.setCapacity(course.getCapacity());
			cour.setIs_selection(1);//成为选课内容
			adminService.updateCourse(cour);
			
			return "success_search";
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
	}
	
	public String searchBySelectionId(){
		try{
			pb=adminService.searchCourseById(course.getCourse_id().trim());
			//便于页面显示
		
			ActionContext.getContext().getSession().put("pb", pb);
			
			
			return "success_findAllCourse";
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
	}
	
	public String searchBySelectionName(){
		try{
			if(num==null)num=1;
			pb=adminService.searchCourseByName(course.getCourse_name().trim(), num);
			
			ActionContext.getContext().getSession().put("pb", pb);
			
			return "success_findAllCourse";
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
	}
	
	public String deleteSelection(){
		try{
			pb=adminService.searchCourseById(course.getCourse_id());
			if(pb.getPageData().size()<1 || ((Course) pb.getPageData().get(0)).getIs_selection()==0)return "error";//已经成为选课内容
			course=(Course) pb.getPageData().get(0);
			course.setIs_selection(0);
			course.setCapacity(0);//去除容量
			adminService.updateCourse(course);
			
			return "success_search";
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
	}
	
	public String findAllSelection(){
		
		if(num==null)num=1;
		pb=adminService.findPageSelection(num);
		pb.setPath("/adminSelection_findAllSelection");
		ActionContext.getContext().getSession().put("pb", pb);
		
		return "success_findAllSelection";
	}
	
	
	public String startCheck(){
		//开放选课时间
		
		try {
			Date startDate=null;
			Date endDate=null;
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			if(startTime==null || startTime.trim()=="" || endTime.trim()=="" || endTime==null)return "error";
			startDate=formatter.parse(startTime);
			endDate=formatter.parse(endTime);
			
			
			Date nowDate=new Date();
		    
			if(endDate.getTime()<nowDate.getTime() 
					|| startDate.getTime()>endDate.getTime()
					||(ServletActionContext.getServletContext().getAttribute("is_start")!=null 
					&& ((Integer)ServletActionContext.getServletContext().getAttribute("is_start"))==1)){
				return "error";
			}
			
			//将开课时间存入域中
			is_start=1;
			ServletActionContext.getServletContext().setAttribute("is_start", is_start);
			ServletActionContext.getServletContext().setAttribute("startDate", startDate);
			ServletActionContext.getServletContext().setAttribute("endDate", endDate);
			//将开课时间存入session
			ActionContext.getContext().getSession().put("startDate", startDate.toLocaleString());
			ActionContext.getContext().getSession().put("endDate", endDate.toLocaleString());
			ActionContext.getContext().getSession().put("is_start", is_start);
			
			
			return "success_startCheck";
		} catch (ParseException e) {
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
		
		
	}
	
	public String endSelection(){
		ServletActionContext.getServletContext().setAttribute("is_start", 0);
		ServletActionContext.getServletContext().removeAttribute("startDate");
		ServletActionContext.getServletContext().removeAttribute("endDate");
		//将开课时间移出session
		ActionContext.getContext().getSession().remove("startDate");
		ActionContext.getContext().getSession().remove("endDate");
		ActionContext.getContext().getSession().put("is_start", 0);
		return "success_startCheck";
	}
	
	public String viewAllSelection(){
		if(num==null)num=1;
		pb=adminService.findPageSelection(num);
		pb.setPath("/adminSelection_viewAllSelection");
		ActionContext.getContext().getSession().put("pb", pb);
		
		return "success_viewAllSelection";
	}

	public String confirmSelection(){
		try{
			adminService.updateSelection(course,1);
			
			return "success_confirmSelection";
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
	}
	
	public String cancelConfirmSelection(){
		try{
			adminService.updateSelection(course,0);
			
			return "success_confirmSelection";
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
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

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public Course getModel() {
		// TODO Auto-generated method stub
		return course;
	}
	
	

	
}
