package edson.utils;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 选课是否开始或进行中
 * @author Administrator
 *
 */
public class MyInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
			ServletContext ctx=ServletActionContext.getServletContext();
			Date startDate=(Date) ctx.getAttribute("startDate");
			Date endDate=(Date) ctx.getAttribute("endDate");
			Date nowDate=new Date();
			
			if(startDate!=null && endDate!=null && nowDate.getTime()>startDate.getTime() && nowDate.getTime()<endDate.getTime()){
				return invocation.invoke();//开始选课
			}
		
			ctx.setAttribute("is_start", 0);//关闭选课
			
			
			return 	"no_start";
		
	}

	
	

}
