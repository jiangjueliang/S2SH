package cn.muke.employee.action;

import java.util.List;

import cn.muke.employee.domain.Department;
import cn.muke.employee.domain.Employee;
import cn.muke.employee.domain.PageBean;
import cn.muke.employee.service.DepartmentService;
import cn.muke.employee.service.EmployeeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 员工登录的Action
 * @author jiang
 *
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{

	private Employee employee=new Employee();
	public Employee getModel() {
		return employee;
	}
	//注入业务层的类
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	private DepartmentService departmentService;
	

public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
private Integer currPage=1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	/**
	 *用户登录的动作 
	 */
	public String login(){
		System.out.println("login方法执行了");
		//调用业务层
		Employee existEmployee= employeeService.login(employee);
		if(existEmployee==null){
			this.addActionError("用户名或密码错误");
			return INPUT;
		}else {
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}
	//查找全部员工的动作
	public String findAll(){
		PageBean<Employee> pageBean=employeeService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	//添加员工的动作
	public String saveUI(){
		//查询所有部门
		List<Department> list=departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);//集合用SET，对象用PUSh
		return "saveUI_ok";
	}
	//保存员工的动作
	public String addEmployee(){
		employeeService.save(employee);
		return "add_ok";
	}
	//跳转修改员工页面的动作
	public String editUI(){
		//根据员工Id查询员工
		employee=employeeService.findById(employee.getEid());
		//查询所有的部门
		List<Department> list=departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editUI_ok";
	}
	//修改员工的动作
	public String editEmployee(){
		employeeService.update(employee);
		return "edit_ok";
	}
	//删除员工的动作
	public String delete(){
		employeeService.delete(employee);
		return"employee_delete_ok";
	}
}
