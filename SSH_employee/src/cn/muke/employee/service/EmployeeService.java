package cn.muke.employee.service;

import cn.muke.employee.domain.Employee;
import cn.muke.employee.domain.PageBean;

/**
 * 业务层接口
 * @author jiang
 *
 */
public interface EmployeeService {

	public Employee login(Employee employee);

	public PageBean<Employee> findByPage(Integer currPage);

	public void save(Employee employee);

	public Employee findById(Integer eid);

	public void update(Employee employee);

	public void delete(Employee employee);

	
}
