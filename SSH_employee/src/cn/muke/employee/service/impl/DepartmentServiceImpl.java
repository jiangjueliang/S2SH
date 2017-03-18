package cn.muke.employee.service.impl;
/**
 * 部门业务层实现类
 */
import java.util.List;

import cn.muke.employee.dao.DepartmentDao;
import cn.muke.employee.domain.Department;
import cn.muke.employee.domain.PageBean;
import cn.muke.employee.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{

	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	//分页查询部门的方法
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean=new PageBean<Department>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount=departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc=totalCount;
		Double num=Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin=(currPage-1)*pageSize;
		List<Department> list=departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	//业务层保存部门的方法
	public void save(Department department) {

		departmentDao.save(department);
	}
	//业务层根据部门ID进行查询的方法
	public Department findById(Integer did) {
		return departmentDao.findById(did);
	}
	//业务层修改部门的方法
	public void update(Department department) {

		departmentDao.update(department);
	}
	//业务层删除部门的方法
	
	public void delete(Department department) {
		// TODO Auto-generated method stub
		departmentDao.delete(department);
		
	}
	//业务层查询所有部门的方法
	public List<Department> findAll() {
		List<Department> list=departmentDao.findAll();
		return list;
	}
	
	
	
	
}
