package edson.web;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edson.bean.Course;
import edson.bean.Student;
import edson.bean.Teacher;
import edson.business.serviceImpl.TeaService;
import edson.utils.MD5;
import edson.utils.PageBean;

public class TeaAction extends ActionSupport implements ModelDriven<Teacher>{
	
	
	public TeaService teaService;
	private PageBean pb;
	private Integer num;
	private Teacher tea=new Teacher();
	private String pwd1;
	private String pwd2;

	public String viewMyCourse(){
		try{
			if(num==null)num=1;
			tea=(Teacher) ActionContext.getContext().getSession().get("tea_user");
			
			pb=teaService.findMyCourse(num,tea.getTea_id());
			pb.setPath("/tea_viewMyCourse");
			ActionContext.getContext().getSession().put("pb", pb);
			return "success_viewMyCourse";
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
	}
	/*
	 * 查看开课信息
	 */
	public String viewMySelection(){
		try{
			if(num==null)num=1;
			tea=(Teacher) ActionContext.getContext().getSession().get("tea_user");
			
			pb=teaService.findMySelection(num,tea.getTea_id());
			pb.setPath("/tea_viewMySelection");
			ActionContext.getContext().getSession().put("pb", pb);
			return "success_viewMySelection";
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
	}
	
	public String viewTheStu(){
		try{
			if(num==null)num=1;
			String course_id=ServletActionContext.getRequest().getParameter("course_id");
			pb=teaService.findCourseStudents(num,course_id);
			pb.setPath("/tea_viewTheStu?course_id="+course_id);
			ActionContext.getContext().getSession().put("pb", pb);
			return "success_viewTheStu";
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
	}
	
	public String logOut(){
		
		try{
			ActionContext.getContext().getSession().remove("tea_user");
			return "success_logOut";
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
			tea=(Teacher) ActionContext.getContext().getSession().get("tea_user");
			tea=teaService.findTeaById(tea.getTea_id());
			tea.setTea_id(MD5.getMD5(pwd1));
			teaService.updateTea(tea);
			return logOut();
		
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
	}
	
	
	@Override
	public Teacher getModel() {
		// TODO Auto-generated method stub
		return tea;
	}
	
	public void setTeaService(TeaService teaService) {
		this.teaService = teaService;
	}

	public void setPb(PageBean pb) {
		this.pb = pb;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	

	public void setTea(Teacher tea) {
		this.tea = tea;
	}



	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}
	




	
}