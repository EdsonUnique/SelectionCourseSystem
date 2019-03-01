package edson.business.serviceImpl;

import org.springframework.transaction.annotation.Transactional;

import edson.bean.Teacher;
import edson.database.daoImpl.TeaDao;
import edson.utils.PageBean;

@Transactional
public class TeaService {
	
	public TeaDao teaDao;

	public void setTeaDao(TeaDao teaDao) {
		this.teaDao = teaDao;
	}

	public PageBean findMyCourse(Integer num, String tea_id) {
		// TODO Auto-generated method stub
		return teaDao.findMyCourse(num,tea_id);
	}

	public PageBean findMySelection(Integer num, String tea_id) {
		// TODO Auto-generated method stub
		return teaDao.findMySelection(num,tea_id);
	}

	public PageBean findCourseStudents(Integer num, String course_id) {
		// TODO Auto-generated method stub
		return teaDao.findCourseStudents(num,course_id);
	}

	public Teacher findTeaById(String tea_id) {
		// TODO Auto-generated method stub
		return teaDao.findTeaById(tea_id);
	}

	public void updateTea(Teacher tea) {

		teaDao.updateTea(tea);
	}

	

}
