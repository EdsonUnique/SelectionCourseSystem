package edson.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edson.bean.Admin;
import edson.bean.Student;
import edson.bean.Teacher;
import edson.business.serviceImpl.AdminService;
import edson.business.serviceImpl.AdminServiceInter;
import edson.utils.MD5;
import edson.utils.PageBean;

/**
 * 登录页面和后台学生操作请求处理
 * @author Administrator
 *
 */
public class AdminAction extends ActionSupport implements ModelDriven<Student>{
	
	private String username;
	private String pwd;
	private int role;//0--学生  1--教师  2--管理员
	private Admin admin;
	private Student stu=new Student();
	private Teacher tea;
	public AdminService adminService;
	private PageBean pb;
	private Integer num;//页码
	private String pwd1;
	private String pwd2;
	
	
	public String login(){
		try{
			if(role==0){
				//查找学生对象
				stu=adminService.findStudent(username.trim(),MD5.getMD5(pwd));
				if(stu!=null){
					ActionContext.getContext().getSession().put("stu_user", stu);
					return "success_stu";
				}
			}else if(role==1){
				//查找教师用户
				tea=adminService.findTea(username.trim(),MD5.getMD5(pwd));
				if(tea!=null){
					ActionContext.getContext().getSession().put("tea_user", tea);
					return "success_tea";
				}
			}else if(role==2){
				//查找管理员用户
				admin=adminService.findAdmin(username.trim(),pwd);
				if(admin!=null){
					ActionContext.getContext().getSession().put("admin_user", admin);
					return "success_admin";
				}
				
			}
			
			this.addActionError("用户名或密码错误");
			
			return "login_index";
		}catch(Exception e){
		e.printStackTrace();
		this.addActionError("操作失败，请稍候尝试！");
		return "error";
	}
		
	}
	
	public String loginOut(){
		
		ActionContext.getContext().getSession().remove("admin_user");
		return "success_loginOut";
	}
	
	public String updatePwdUI(){
		
		return "success_updatePwdUI";
	}
	@Test
	public String updatePwd() {
		
		try{
			if(pwd1==null || pwd2==null || !pwd1.equals(pwd2)){
				
				return "error";
			}
			admin=(Admin) ActionContext.getContext().getSession().get("admin_user");
			admin.setAdmin_pwd(pwd1);
			adminService.updateAdmin(admin);
			return loginOut();
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
	}
	
	public String addStudent(){
		try{
			if(stu.getStu_id().trim()=="")return "error";//后台校验
			stu.setStu_pwd(MD5.getMD5(stu.getStu_pwd()));
			adminService.save(stu);
			this.addActionError("添加成功");
			return "success_addStudent";
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
	}
	
	public String findPageStudent(){
		if(num==null)num=1;
		pb=adminService.findPageStudent(num);
		pb.setPath("/admin_findPageStudent");
		ActionContext.getContext().getSession().put("pb", pb);
		return "success_findPageStudent";
	}
	
	public String searchStuById(){
		
		if(stu.getStu_id()==null || stu.getStu_id().trim()==""){
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
		pb=adminService.searchStuById(stu.getStu_id().trim());
		pb.setPath("/admin_searchStuById");
		ActionContext.getContext().getSession().put("pb", pb);
		
		return "success_findPageStudent";
	}
	
	public String searchStuByName(){
		
		if(stu.getStu_name()==null || stu.getStu_name().trim()==""){
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
		if(num==null)num=1;
		pb=adminService.searchStuByName(stu.getStu_name().trim(),num);
		pb.setPath("/admin_searchStuByName");
		ActionContext.getContext().getSession().put("pb", pb);
		
		return "success_findPageStudent";
	}
	
	public String updateStudentUI(){
		
		pb=adminService.searchStuById(stu.getStu_id().trim());
		ServletActionContext.getRequest().setAttribute("stu", pb.getPageData().get(0));
		
		return "success_addStudent";
		
	}
	
	public String updateStudent(){
		
		try{
			Student s=(Student) adminService.searchStuById(stu.getStu_id().trim()).getPageData().get(0);
			stu.setCourses(s.getCourses());
			stu.setStu_pwd(MD5.getMD5(stu.getStu_pwd()));
			adminService.updateStu(stu);
			
			this.addActionError("修改成功");
			return "success_updateStudent";
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
	}
	
	public String deleteStudent(){
		
		try{
			adminService.deleteStu(stu);
			this.addActionError("已删除");
			return "success_updateStudent";
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError("操作失败，请稍候尝试！");
			return "error";
		}
		
	}

	

	
	
	
	
	
	
	
	
	
	
	









	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}






















	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public String getPwd() {
		return pwd;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public Student getModel() {
		return stu;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}
	
	
	
	
}
