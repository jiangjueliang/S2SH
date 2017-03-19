package cn.muke.employee.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;







public class AuthInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		ActionContext ac=ActionContext.getContext();
		if(ac.getSession().get("existEmployee")!=null){
			String result=invocation.invoke();//invocation.invoke()返回的值是方法名，如login,saveUI,findAll
			System.out.println("拦截器中invocation.invoke()返回的值是方法名："+result);
			return result;
		}else{
			System.out.println("AuthInterceptor拦截器拦截了您的操作，未登入或账号密码有误");
			return "login";
		}
	}
	/**
	 * 自定义拦截器
	 */
		
}
