package cn.muke.employee.dao.impl;
/**
 * 部门DAO层实现类
 */
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.muke.employee.dao.DepartmentDao;
import cn.muke.employee.dao.EmployeeDao;
import cn.muke.employee.domain.Department;
import cn.muke.employee.domain.Employee;
import cn.muke.employee.util.HibernateUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	private HibernateUtil hibernateUtil;
	private Session session;
	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}
	//查询总记录数
	public int findCount() {
		String hql="select count(*) from Department";
		session=hibernateUtil.getSession();
		Query query=session.createQuery(hql);
		List<Long> list=query.list();
		if(list.size()>0){
			return list.get(0).intValue();
		}
		hibernateUtil.closeSession(session);
		return 0;
	}
	/**
	 * 查询每页显示的数据
	 */
	public List<Department> findByPage(int begin, int pageSize) {
		String hql="from Department";
		session=hibernateUtil.getSession();
		Query query=session.createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<Department> list=query.list();
		hibernateUtil.closeSession(session);
		return list;
	}
	/**
	 * 实现部门存储的方法
	 */

	public void save(Department department){
		session=hibernateUtil.getSession();
		session.save(department);
		hibernateUtil.closeSession(session);
	}
	//实现根据ID 查询部门
	public Department findById(Integer did) {
		session=hibernateUtil.getSession();
		Department department=(Department) session.get(Department.class, did);
		hibernateUtil.closeSession(session);
		return department;
	}
	//修改部门
	public void update(Department department) {
		session=hibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		session.update(department);
		transaction.commit();
		hibernateUtil.closeSession(session);
		
	}
	//根据ID删除部门
	public void delete(Department department) {
		// TODO Auto-generated method stub
		session=hibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		session.delete(department);
		transaction.commit();
		hibernateUtil.closeSession(session);
	}
	//DAO中查询所有部门的方法
	public List<Department> findAll() {
		String hql="from Department";
		session=hibernateUtil.getSession();
		Query query=session.createQuery(hql);
		List<Department> list=query.list();
		return list;
	}
	
}
