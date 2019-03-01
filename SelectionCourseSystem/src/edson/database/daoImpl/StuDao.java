package edson.database.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import edson.bean.Course;
import edson.bean.Student;
import edson.utils.PageBean;

public class StuDao extends HibernateDaoSupport{

	private String hql,hql_table;
	
	public PageBean findPageSelection(Integer num) {
		hql="select count(*) from Course c where c.is_selection=1";//查询总共记录数
		hql_table="from Course c where c.is_selection=1";//指定表
		return findPageTool(num);
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


	public Course findCourseById(String course_id) {
		List<Course> cs=(List<Course>) this.getHibernateTemplate().find("from Course c where c.course_id like ?0", course_id);
		return cs.size()>0?cs.get(0):null;
	}

	//left join fetch 填充左边的表
	public PageBean findMySelection(Integer num, String stu_id) {
		hql="select count(*) from Course c left join c.students t where t.stu_id like '"+stu_id+"'";//查询总共记录数
		hql_table="from Course c left join fetch c.students t where t.stu_id like '"+stu_id+"'";//指定表
		return findPageTool(num);
	}


	public void updateStu(Student stu) {
		this.getHibernateTemplate().merge(stu);//解决save或update托管态异常
		
		
	}


	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(course);
	}

//多对多：联表查询中间表，关联实体类中的set集合
	public PageBean findSelection(Integer num, String stu_id) {
		hql="  select count(*) from Course u where u.is_selection=1 and u.course_id not in(select c.course_id from Course c left join c.students t where t.stu_id like '"+stu_id+"')";//查询总共记录数
		hql_table="from Course u where u.is_selection=1 and u.course_id not in(select c.course_id from Course c left join c.students t where t.stu_id like '"+stu_id+"')";//指定表
		return findPageTool(num);
	}


	public Student findStuById(String stu_id) {
		List<Student> s=(List<Student>) this.getHibernateTemplate().find("from Student s where s.stu_id like ?0", stu_id);
		return s.size()>0?s.get(0):null;
	}


	public PageBean searchCourseByTeaName(String tea_name,Integer num) {
		hql="  select count(*) from Course u where u.is_selection=1 and u.tea.tea_name like '"+tea_name+"'";//查询总共记录数
		hql_table="from Course u where u.is_selection=1 and u.tea.tea_name like '"+tea_name+"'";//指定表
		return findPageTool(num);
	}


	public PageBean searchCourseByCourseName(String course_name, Integer num) {
		hql="  select count(*) from Course u where u.is_selection=1 and u.course_name like '"+course_name+"'";//查询总共记录数
		hql_table="from Course u where u.is_selection=1 and u.course_name like '"+course_name+"'";//指定表
		return findPageTool(num);
	}


	
}
