package edson.database.daoImpl;




import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import edson.bean.Admin;
import edson.bean.Course;
import edson.bean.Student;
import edson.bean.Teacher;
import edson.business.serviceImpl.AdminServiceInter;
import edson.utils.PageBean;


public class AdminDao extends HibernateDaoSupport  implements AdminDaoInter{
	
	private String hql;
	private String hql_table;

	public Admin findAdmin(String username, String pwd) {
		
		List<Admin> admins=(List<Admin>)this.getHibernateTemplate()
							.find("from Admin a where a.admin_name like ?0 and admin_pwd like ?1",username,pwd);
							
		return admins.isEmpty()?null:admins.get(0);
		
	}

	public void save(Student stu) {
		this.getHibernateTemplate().save(stu);
		
	}
	
	public PageBean<Student> findPageStudent(final Integer pagenum) {
		hql="select count(*) from Student";//查询总共记录数
		hql_table="from Student";//指定表
		return findPageTool(pagenum);
	}
	

	public PageBean<Student> findPageTool(final Integer pagenum) {
		Integer totalRecord;
		
		totalRecord=findTotalRecord(hql,null);
		
		List<Student> cs=this.getHibernateTemplate().execute(new HibernateCallback<List<Student>>() {

			@Override
			public List<Student> doInHibernate(Session session)
					throws HibernateException {
				
				return  session.createQuery(hql_table)
										.setFirstResult((pagenum-1)*6)
										.setMaxResults(6)
										.list();
				
			}
		});
				
				
		
		PageBean pb=new PageBean(pagenum,totalRecord,cs);
		
		return pb;
	}
	
	public Integer findTotalRecord(String hql,Object[] params) {
		List<Long> pageRecord;
		if(params==null || params.length<=0){
			pageRecord=(List<Long>) this.getHibernateTemplate().find(hql);
		}else{
			pageRecord=(List<Long>) this.getHibernateTemplate().find(hql,Integer.valueOf(params[0].toString()));
		}
		if(pageRecord.size()<=0)return null;
		return pageRecord.get(0).intValue();
	}

	public PageBean searchStuById(String stu_id) {
		hql="select count(*) from Student stu where stu.stu_id like '"+stu_id+"'";
		hql_table="from Student stu where stu.stu_id like '"+stu_id+"'";//指定表
		return findPageTool(1);
	}

	public PageBean searchStuByName(String stu_name, Integer num) {
		hql="select count(*) from Student stu where stu.stu_name like '"+stu_name+"'";
		hql_table="from Student stu where stu.stu_name like '"+stu_name+"'";//指定表
		return findPageTool(num);
	}

	public void updateStu(Student stu) {
		this.getHibernateTemplate().update(stu);
	}

	public void deleteStu(Student stu) {
		this.getHibernateTemplate().delete(stu);
	}
	
	//++++++++++++++++++++++++++++++++++++++++++教师
	public void save(Teacher tea) {
		this.getHibernateTemplate().save(tea);
		
	}
	
	public PageBean<Teacher> findPageTeacher(final Integer pagenum) {
		hql="select count(*) from Teacher";//查询总共记录数
		hql_table="from Teacher";//指定表
		return findPageTeaTool(pagenum);
	}
	

	public PageBean<Teacher> findPageTeaTool(final Integer pagenum) {
		Integer totalRecord;
		
		totalRecord=findTotalRecord(hql,null);
		
		List<Teacher> cs=this.getHibernateTemplate().execute(new HibernateCallback<List<Teacher>>() {

			@Override
			public List<Teacher> doInHibernate(Session session)
					throws HibernateException {
				
				return  session.createQuery(hql_table)
										.setFirstResult((pagenum-1)*6)
										.setMaxResults(6)
										.list();
				
			}
		});
				
				
		
		PageBean pb=new PageBean(pagenum,totalRecord,cs);
		
		return pb;
	}
	
	public PageBean searchTeaById(String tea_id) {
		hql="select count(*) from Teacher tea where tea.tea_id like '"+tea_id +"'";
		hql_table="from Teacher tea where tea.tea_id like '"+tea_id +"'";//指定表
		return findPageTeaTool(1);
	}

	public PageBean searchTeaByName(String tea_name, Integer num) {
		hql="select count(*) from Teacher tea where tea.tea_name like '"+tea_name+"'";
		hql_table="from Teacher tea where tea.tea_name like '"+tea_name+"'";//指定表
		return findPageTeaTool(num);
	}

	public void updateTea(Teacher tea) {
		this.getHibernateTemplate().update(tea);
	}

	public void deleteTea(Teacher tea) {
		this.getHibernateTemplate().delete(tea);
	}
	
	
	//++++++++++++++++++++++++++++++++++++++课程
	public void save(Course course) {
		this.getHibernateTemplate().save(course);
		
	}
	
	public PageBean<Course> findPageCourse(final Integer pagenum) {
		hql="select count(*) from Course";//查询总共记录数
		hql_table="from Course";//指定表
		return findPageCourseTool(pagenum);
	}
	

	public PageBean<Course> findPageCourseTool(final Integer pagenum) {
		Integer totalRecord;
		
		totalRecord=findTotalRecord(hql,null);
		
		List<Course> cs=this.getHibernateTemplate().execute(new HibernateCallback<List<Course>>() {

			@Override
			public List<Course> doInHibernate(Session session)
					throws HibernateException {
				
				return  session.createQuery(hql_table)
										.setFirstResult((pagenum-1)*6)
										.setMaxResults(6)
										.list();
				
			}
		});
				
				
		
		PageBean pb=new PageBean(pagenum,totalRecord,cs);
		
		return pb;
	}
	
	public PageBean searchCourseById(String course_id) {
		hql="select count(*) from Course course where course.course_id like '"+course_id+"'";
		hql_table="from Course course where course.course_id like '"+course_id+"'";//指定表
		return findPageTeaTool(1);
	}

	public PageBean searchCourseByName(String course_name, Integer num) {
		hql="select count(*) from Course course where course.course_name like '"+course_name+"'";
		hql_table="from Course course where course.course_name like '"+course_name+"'";//指定表
		return findPageCourseTool(num);
	}

	public void updateCourse(Course course) {
		this.getHibernateTemplate().update(course);
	}

	public void deleteCourse(Course course) {
		this.getHibernateTemplate().delete(course);
	}

	public List<Teacher> findAllTeacher() {
		
		return (List<Teacher>) this.getHibernateTemplate().find("from Teacher");
	}

	

	

	public Course searchBySelectionName(String course_name) {
		List<Course> cs= (List<Course>) this.getHibernateTemplate().find("from Course c where c.course_name like ?0", course_name);
		
		return cs.size()>0?cs.get(0):null;
	}

	public Course findCourseById(String course_id) {
		List<Course> cs= (List<Course>) this.getHibernateTemplate().find("from Course c where c.course_id like ?0", course_id);
		
		return cs.size()>0?cs.get(0):null;
		
	}

	public PageBean finPageSelection(Integer num) {
		hql="select count(*) from Course s where s.is_selection=1";//查询总共记录数
		hql_table="from Course s where s.is_selection=1";//指定表
		return findPageTool(num);
	}

	public void updateSelection(Course course,int state) {
		Course s=(Course) this.getHibernateTemplate().find("from Course s where s.course_id like ?0", course.getCourse_id()).get(0);
		s.setIs_on(state);
		this.getHibernateTemplate().update(s);
	
	}

	public void updateAdmin(Admin admin) {
		this.getHibernateTemplate().update(admin);
	}

	public Student findStudent(String username, String pwd) {
		List<Student>s=(List<Student>) this.getHibernateTemplate().find("from Student s where s.stu_id like ?0 and s.stu_pwd like ?1", username,pwd);
		return s.size()>0?s.get(0):null;
	}

	public Teacher findTea(String username, String pwd) {
		
		List<Teacher> teas=(List<Teacher>) this.getHibernateTemplate().find("from Teacher t where t.tea_id like ?0 and t.tea_pwd like ?1", username,pwd);
		
		return teas.size()>0?teas.get(0):null;
	}
	
}
