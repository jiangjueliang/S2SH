package cn.muke.employee.service;

import java.util.List;

import cn.muke.employee.domain.Department;
import cn.muke.employee.domain.PageBean;

/**
 * 部门业务层接口
 * @author jiang
 *
 */
public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);
	public void save(Department department);
	Department findById(Integer did);
	void update(Department department);
	void delete(Department department);
	List<Department> findAll();
	
}
