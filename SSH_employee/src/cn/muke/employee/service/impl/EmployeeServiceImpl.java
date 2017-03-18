package cn.muke.employee.service.impl;

import java.util.List;

import cn.muke.employee.dao.EmployeeDao;
import cn.muke.employee.domain.Department;
import cn.muke.employee.domain.Employee;
import cn.muke.employee.domain.PageBean;
import cn.muke.employee.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public Employee login(Employee employee) {
		
		return employeeDao.login(employee);
	}

	public PageBean<Employee> findByPage(Integer currPage) {
		PageBean<Employee> pageBean =new PageBean<Employee>();
		//封装当前页数
				pageBean.setCurrPage(currPage);
				//封装每页显示的记录数
				int pageSize=3;
				pageBean.setPageSize(pageSize);
				//封装总记录数
				int totalCount=employeeDao.findCount();
				pageBean.setTotalCount(totalCount);
				//封装总页数
				double tc=totalCount;
				Double num=Math.ceil(tc/pageSize);
				pageBean.setTotalPage(num.intValue());
				//封装每页显示的数据
				int begin=(currPage-1)*pageSize;
				List<Employee> list=employeeDao.findByPage(begin,pageSize);
				pageBean.setList(list);
				return pageBean;
		
	}
	//业务层保存员工的方法
	public void save(Employee employee) {
		employeeDao.save(employee);
		
	}
	//业务层根据ID查员工
	public Employee findById(Integer eid) {
		return employeeDao.findById(eid);
	}
    //业务层修改员工

	public void update(Employee employee) {
		// TODO Auto-generated method stub
		
			employeeDao.update(employee);
			
		}
	//业务层删除员工
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.delete(employee);
	}
	}

	
	
	
