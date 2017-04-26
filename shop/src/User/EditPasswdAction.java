package User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Factory.DAOFactory;
import pojo.Users;

public class EditPasswdAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
//		String username = request.getParameter("username");
		String username = (String) request.getSession().getAttribute("username");
		try{
			
			Users user =DAOFactory.getUserDAOInstance().queryByUsername(username);
			if(user.getPassword().equals(oldPassword)){
				if(DAOFactory.getUserDAOInstance().editPasswd(user.getUid(), newPassword)==1){//密码修改成功
					request.setAttribute("status", "密码修改成功！");
				}else{
					request.setAttribute("status", "密码修改失败！");
				}
			}
		}catch(Exception e){
			
		}
		
		
		return "User.jsp";
	}

}
