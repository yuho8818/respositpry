package EditUser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Factory.DAOFactory;
import pojo.Users;

public class EditPasswdAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取用户的用户名值
		int uid = Integer.parseInt(String.valueOf(
				request.getSession().getAttribute("uid")));
		//获取旧密码
		String oldPasswd = request.getParameter("oldPasswd");
		//获取新密码
		String passwd = request.getParameter("passwd1");
		String confirdPasswd = request.getParameter("passwd2");
		try{
			//根据用户名查询用户
			Users user =DAOFactory.getUserDAOInstance().
				queryByUsername(String.valueOf(
						request.getSession().getAttribute("username")));
			//判断输入的旧密码跟原来的旧密码是否一致，
			//如果一致进行修改
			if(user.getPassword().equals(oldPasswd)){
				if(isValidPassword(passwd,confirdPasswd)){//验证密码
					request.setAttribute("status", "密码为空或者密码不一致！");
				}
				if(DAOFactory.getUserDAOInstance().
						editPasswd(uid, passwd)==1){//密码修改成功
					request.setAttribute("status", "密码修改成功！");
				}else{//密码修改失败
					request.setAttribute("status", "密码修改操作失败，请重试！");
				}
			}else{//输入密码错误
				request.setAttribute("status", "原密码错误，你不能修改密码！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "editpassed.jsp";
	}
	//验证密码，如果密码为空且长度小于6并且跟确认密码不统一
	//返回true
	public boolean isValidPassword(String passwd,String confirdPasswd){
		return passwd==null||confirdPasswd==null
		||passwd.length()<6||confirdPasswd.length()<6
		||!passwd.equals(confirdPasswd);
	}
}
