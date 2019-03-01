package edson.web;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edson.bean.Admin;
import edson.bean.Student;
import edson.bean.Teacher;
import edson.business.serviceImpl.AdminService;
import edson.utils.MD5;
import edson.utils.PageBean;
/**
 * 后台教师页面
 * @author Administrator
 *
 */
public class AdminTeaAction extends ActionSupport implements ModelDriven<Teacher>{
	
	private Teacher tea=new Teacher();
	public AdminService adminService;
	private PageBean pb;
	private Integer num;//页码
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++教师+++++++++++++++++
		public String addTeacher(){
			try{
				if(tea.getTea_id().trim()=="")return "error";//后台校验
				tea.setTea_pwd(MD5.getMD5(tea.getTea_pwd()));
				adminService.save(tea);
				this.addActionError("添加成功");
				return "success_addTeacher";
			}catch(Exception e){
				e.printStackTrace();
				this.addActionError("操作失败，请稍候尝试！");
				return "error";
			}
		}
		
		public String findPageTeacher(){
			if(num==null)num=1;
			pb=adminService.findPageTeacher(num);
			pb.setPath("/adminTea_findPageTeacher");
			ActionContext.getContext().getSession().put("pb", pb);
			return "success_findPageTeacher";
		}
		
		public String searchTeaById(){
			
			if(tea.getTea_id()==null || tea.getTea_id().trim()==""){
				this.addActionError("操作失败，请稍候尝试！");
				return "error";
			}
			
			pb=adminService.searchTeaById(tea.getTea_id());
			pb.setPath("/adminTea_searchTeaById");
			ActionContext.getContext().getSession().put("pb", pb);
			
			return "success_findPageTeacher";
		}
		
		public String searchTeaByName(){
			
			if(tea.getTea_name()==null || tea.getTea_name().trim()==""){
				this.addActionError("操作失败，请稍候尝试！");
				return "error";
			}
			
			if(num==null)num=1;
			pb=adminService.searchTeaByName(tea.getTea_name().trim(),num);
			pb.setPath("/adminTea_searchTeaByName");
			ActionContext.getContext().getSession().put("pb", pb);
			
			return "success_findPageTeacher";
		}
		
		public String updateTeacherUI(){
			
			pb=adminService.searchTeaById(tea.getTea_id());
			ServletActionContext.getRequest().setAttribute("tea", pb.getPageData().get(0));
			
			return "success_addTeacher";
			
		}
		
		public String updateTeacher(){
			
			try{
				Teacher t=(Teacher) adminService.searchTeaById(tea.getTea_id()).getPageData().get(0);
				tea.setCourses(t.getCourses());
				tea.setTea_pwd(MD5.getMD5(tea.getTea_pwd()));
				adminService.updateTea(tea);
				
				this.addActionError("修改成功");
				return "success_updateTeacher";
			}catch(Exception e){
				e.printStackTrace();
				this.addActionError("操作失败，请稍候尝试！");
				return "error";
			}
			
		}
		
		public String deleteTeacher(){
			
			try{
				adminService.deleteTea(tea);
				this.addActionError("已删除");
				return "success_updateTeacher";
			}catch(Exception e){
				e.printStackTrace();
				this.addActionError("操作失败，请稍候尝试！");
				return "error";
			}
			
		}

		@Override
		public Teacher getModel() {
			
			return tea;
		}

		public void setTea(Teacher tea) {
			this.tea = tea;
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
		
		

}
