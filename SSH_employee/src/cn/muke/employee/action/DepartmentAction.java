package cn.muke.employee.action;
/**
 * 部门的action
 */
import cn.muke.employee.domain.Department;
import cn.muke.employee.domain.PageBean;
import cn.muke.employee.service.DepartmentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	/**
	 * 实现模型驱动
	 */
	private Department department=new Department();
	public Department getModel() {
		return department;
	}
	private Integer currPage=1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	//注入部门的sevice
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	//查找部门的动作
	public String findAll(){
		PageBean<Department> pageBean= departmentService.findByPage(currPage);
		//将pagebean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	//添加部门的动作、
	public String addDepartment(){
		departmentService.save(department);
		return "add_ok";
	}
	//执行编辑的动作
	public String edit(){
		department=departmentService.findById(department.getDid());
		return "edit_ok";
	}
	//修改部门的动作
	public String updateDepartment(){
		departmentService.update(department);
		return "update_ok";
	}
	//删除部门的动作
	public String deleteDepartment(){
		department=departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "delete_ok";
	}
	public String show(){
		return "show_ok";
	}

}
