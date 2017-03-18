package cn.muke.employee.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.muke.employee.dao.EmployeeDao;
import cn.muke.employee.domain.Employee;
import cn.muke.employee.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private HibernateUtil hibernateUtil;
	private Session session;
	
	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}
	//根据员工姓名和密码查询 进行登录
	public Employee login(Employee employee) {
		String hql="from Employee where username=? and password=?";
		session=hibernateUtil.getSession();
		Query query=session.createQuery(hql);
		query.setParameter(0, employee.getUsername());
		query.setParameter(1, employee.getPassword());
		List<Employee> list=query.list();
		if(list.size()>0){
			return list.get(0);
		}
		hibernateUtil.closeSession(session);
		return null;
	}
	//查找员工总记录数
	public int findCount() {
		String hql="select count(*) from Employee";
		session=hibernateUtil.getSession();
		Query query=session.createQuery(hql);
		List<Long > list=query.list();
		if(list.size()>0){
			return list.get(0).intValue();
		}
		hibernateUtil.closeSession(session);
		return 0;
	}
	public List<Employee> findByPage(int begin, int pageSize) {
		String hql="from Employee";
		session=hibernateUtil.getSession();
		Query query=session.createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<Employee> list=query.list();
		hibernateUtil.closeSession(session);
		return list;
	}
	//DAO层 保存员工的方法
	public void save(Employee employee) {

		session=hibernateUtil.getSession();
		session.save(employee);
		hibernateUtil.closeSession(session);
	}
	//Dao层 根据ID 查员工
	public Employee findById(Integer eid) {
		
		session=hibernateUtil.getSession();
		
		Employee employee=(Employee) session.get(Employee.class, eid);
		hibernateUtil.closeSession(session);
		return employee;
	}
	//DAO修改员工
	public void update(Employee employee) {
		session=hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		session.update(employee);
		transaction.commit();

		hibernateUtil.closeSession(session);
	}
	//Dao删除员工
	public void delete(Employee employee) {
		session = hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.delete(employee);
		transaction.commit(); 
		hibernateUtil.closeSession(session);

	}

}
