package edson.utils;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.websocket.Session;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class CheckSessionInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		if(ActionContext.getContext().getSession().get("stu_user")==null
				&&ActionContext.getContext().getSession().get("tea_user")==null
				&&ActionContext.getContext().getSession().get("admin_user")==null){
			
				return 	"wrong";
			}
			
			return 	invocation.invoke();
	}

	

}
