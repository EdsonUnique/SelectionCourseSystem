package edson.database.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import edson.bean.Student;
import edson.bean.Teacher;
import edson.utils.PageBean;

public class TeaDao extends HibernateDaoSupport{

	private String hql,hql_table;

	public PageBean findMyCourse(Integer num, String tea_id) {
		hql="select count(*) from Course c left join c.tea t where t.tea_id like '"+tea_id+"'";//查询总共记录数
		hql_table="from Course c left join fetch c.tea t where t.tea_id like '"+tea_id+"'";//指定表
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

	public PageBean findMySelection(Integer num, String tea_id) {
		hql="select count(*) from Course c left join c.tea t where c.is_selection=1 and t.tea_id like '"+tea_id+"'";//查询总共记录数
		hql_table="from Course c left join fetch c.tea t where c.is_selection=1 and t.tea_id like '"+tea_id+"'";//指定表
		return findPageTool(num);
	}

	public PageBean findCourseStudents(Integer num, String course_id) {
		hql="select count(*) from Student s left join s.courses t where t.course_id like '"+course_id+"'";//查询总共记录数
		hql_table="from Student s left join fetch s.courses t where t.course_id like '"+course_id+"'";//指定表
		return findPageTool(num);
	}

	public Teacher findTeaById(String tea_id) {
		List<Teacher> ts=(List<Teacher>) this.getHibernateTemplate().find("from Teacher t where t.tea_id like ?0", tea_id);
		return ts.size()>0?ts.get(0):null;
	}

	public void updateTea(Teacher tea) {

		this.getHibernateTemplate().update(tea);
	}

}
