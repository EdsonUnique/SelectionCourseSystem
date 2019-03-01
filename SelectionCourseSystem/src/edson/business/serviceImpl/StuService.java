package edson.business.serviceImpl;

import org.springframework.transaction.annotation.Transactional;

import edson.bean.Course;
import edson.bean.Student;
import edson.database.daoImpl.StuDao;
import edson.utils.PageBean;
@Transactional
public class StuService {

	
		public StuDao stuDao;

		public void setStuDao(StuDao stuDao) {
			this.stuDao = stuDao;
		}

		public PageBean findPageSelection(Integer num) {
			// TODO Auto-generated method stub
			return stuDao.findPageSelection(num);
		}

		public Course findCourseById(String course_id) {
			// TODO Auto-generated method stub
			return stuDao.findCourseById(course_id);
		}

		public PageBean findMySelection(Integer num, String stu_id) {
			// TODO Auto-generated method stub
			return stuDao.findMySelection(num,stu_id);
		}

		public void updateStu(Student stu) {
			// TODO Auto-generated method stub
			stuDao.updateStu(stu);
		}

		public void updateCourse(Course course) {
			// TODO Auto-generated method stub
			stuDao.updateCourse(course);
		}

		public PageBean findSelection(Integer num, String stu_id) {
			// TODO Auto-generated method stub
			return stuDao.findSelection(num,stu_id);
		}

		public Student findStuById(String stu_id) {
			// TODO Auto-generated method stub
			return stuDao.findStuById(stu_id);
		}

		public PageBean searchCourseByTeaName(String tea_name,Integer num) {
			// TODO Auto-generated method stub
			return stuDao.searchCourseByTeaName(tea_name,num);
		}

		public PageBean searchCourseByCourseName(String course_name, Integer num) {
			// TODO Auto-generated method stub
			return stuDao.searchCourseByCourseName(course_name,num);
		}

		
}
