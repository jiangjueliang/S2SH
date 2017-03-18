package cn.muke.employee.dao;

import java.util.List;

import cn.muke.employee.domain.Department;

/**
 * 部门Dao层接口
 * @author jiang
 *
 */
public interface DepartmentDao {

	int findCount();

	List<Department> findByPage(int begin, int pageSize);

	public void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();
}
