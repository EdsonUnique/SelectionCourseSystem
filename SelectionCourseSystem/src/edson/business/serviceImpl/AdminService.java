package edson.business.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import edson.bean.Admin;
import edson.bean.Course;
import edson.bean.Student;
import edson.bean.Teacher;
import edson.database.daoImpl.AdminDao;
import edson.utils.PageBean;

@Transactional
public class AdminService implements AdminServiceInter {
	
	AdminDao adminDao;
	
	//查找admin对象
	public Admin findAdmin(String username, String pwd) {
		// TODO Auto-generated method stub
		return adminDao.findAdmin( username, pwd);
	}
	
	
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}


	public void save(Student stu) {
		
		adminDao.save(stu);
		
	}
	
	public void save(Teacher tea) {
		
		adminDao.save(tea);
		
	}


	public PageBean findPageStudent(Integer num) {
		
		return adminDao.findPageStudent( num);
	}


	public PageBean searchStuById(String stu_id) {
		
		return adminDao.searchStuById(stu_id);
	}


	public PageBean searchStuByName(String stu_name,Integer num) {
		// TODO Auto-generated method stub
		return adminDao.searchStuByName(stu_name,num);
	}


	public void updateStu(Student stu) {
		adminDao.updateStu(stu);
	}


	public void deleteStu(Student stu) {
		adminDao.deleteStu(stu);
	}


	public PageBean findPageTeacher(Integer num) {
		// TODO Auto-generated method stub
		return adminDao.findPageTeacher(num);
	}


	public PageBean searchTeaById(String tea_id) {
		// TODO Auto-generated method stub
		return adminDao.searchTeaById(tea_id);
	}


	public PageBean searchTeaByName(String tea_name, Integer num) {
		// TODO Auto-generated method stub
		return adminDao.searchTeaByName(tea_name, num);
	}


	public void updateTea(Teacher tea) {
		adminDao.updateTea(tea);
		
	}


	public void deleteTea(Teacher tea) {
		adminDao.deleteTea(tea);
		
	}


	public void save(Course course) {
		adminDao.save(course);
	}


	public PageBean findPageCourse(Integer num) {
		return adminDao.findPageCourse(num);
	}


	public PageBean searchCourseById(String course_id) {
		return adminDao.searchCourseById(course_id);
	}


	public PageBean searchCourseByName(String course_name, Integer num) {
		return adminDao.searchCourseByName(course_name, num);
	}


	public void updateCourse(Course course) {
		adminDao.updateCourse(course);
		
	}


	public void deleteCourse(Course course) {
		adminDao.deleteCourse(course);
	}


	public List<Teacher> findAllTeacher() {
		return adminDao.findAllTeacher();
	}


	/*public void addSelection(Selection selection) {
		adminDao.addSelection(selection);
	}*/


	/*public void deleteSelection(String course_id) throws SQLException {
		adminDao.deleteSelection(course_id);
	}*/


	public Course searchBySelectionId(String course_id) {
		return adminDao.findCourseById(course_id);
	}


	public Course searchBySelectionName(String course_name) {
		return adminDao.searchBySelectionName(course_name);
	}


	public PageBean findPageSelection(Integer num) {
		// TODO Auto-generated method stub
		return adminDao.finPageSelection(num);
	}


	public void updateSelection(Course course,int state) {
		 adminDao.updateSelection(course,state);
	}


	public void updateAdmin(Admin admin) {
		adminDao.updateAdmin(admin);
	}


	public Student findStudent(String username, String pwd) {
		return adminDao.findStudent(username,pwd);
	}


	public Teacher findTea(String username, String pwd) {
		// TODO Auto-generated method stub
		return adminDao.findTea(username,pwd);
	}


	
	
}
